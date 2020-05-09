package tk.cavinc.connexion.ui.fragments;

;import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import tk.cavinc.connexion.R;
import tk.cavinc.connexion.data.managers.DataManager;

/**
 * Created by cav on 07.05.20.
 */

public class Screen2Fragment extends Fragment {
    private static final String TAG = "S2F";
    private DataManager mDataManager;

    private WorkPageAdapter mWorkPageAdapter;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

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

        mWorkPageAdapter = new WorkPageAdapter(getActivity().getSupportFragmentManager());

        mViewPager = (ViewPager) rootView.findViewById(R.id.viewpager_sc2);
        mViewPager.setAdapter(mWorkPageAdapter);

        mTabLayout = (TabLayout) rootView.findViewById(R.id.tabs_sc2);
        mTabLayout.setupWithViewPager(mViewPager);

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

    private class WorkPageAdapter extends FragmentPagerAdapter {

        public WorkPageAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new ScChatFragment();
                case 1:
                    return new ScEventsFragments();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Чаты";
                case 1:
                    return "Уведомления";
                default:
                    return null;
            }
        }
    }
}
