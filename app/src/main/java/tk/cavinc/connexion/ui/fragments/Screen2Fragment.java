package tk.cavinc.connexion.ui.fragments;

;import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import tk.cavinc.connexion.R;
import tk.cavinc.connexion.data.managers.DataManager;

/**
 * Created by cav on 07.05.20.
 */

public class Screen2Fragment extends Fragment {
    private static final String TAG = "S2F";
    private DataManager mDataManager;

    private TabLayout mTabLayout;

    private FrameLayout mFrameLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataManager = DataManager.getInstance();
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.screen2_fragment, container, false);

        mTabLayout = (TabLayout) rootView.findViewById(R.id.tabs_sc2);
        mTabLayout.addTab(mTabLayout.newTab().setText("Чаты"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Уведомления"));
        mTabLayout.addOnTabSelectedListener(mOnTabSelectedListener);
        viewFragmet(new ScChatFragment(),"CHAT");

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.scr2_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,"PAUSE S2F");
    }


    TabLayout.OnTabSelectedListener mOnTabSelectedListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab.getPosition() == 0) {
                viewFragmet(new ScChatFragment(),"CHAT");
            } else if (tab.getPosition() == 1) {
                viewFragmet(new ScEventsFragments(),"EVENTS");
            }
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };

    private void viewFragmet(Fragment fragment,String tag){
        FragmentTransaction trz = getActivity().getSupportFragmentManager().beginTransaction();
        trz.replace(R.id.container2,fragment,tag);
        trz.commit();
    }


}
