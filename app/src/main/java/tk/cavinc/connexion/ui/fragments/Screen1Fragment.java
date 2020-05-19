package tk.cavinc.connexion.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tk.cavinc.connexion.R;

/**
 * Created by cav on 07.05.20.
 */

public class Screen1Fragment extends Fragment {
    private TabLayout mTabLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.screen1_fragment, container, false);
        mTabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
        mTabLayout.addTab(mTabLayout.newTab().setText("Фотолинейка"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Стрим"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Знакомства"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Быстрые знакомства"));

        mTabLayout.addOnTabSelectedListener(mOnTabSelectedListener);

        viewFragmet(new HotOrNotFragment(),"HOORNOT");
        return rootView;
    }

    private void viewFragmet(Fragment fragment,String tag){
        FragmentTransaction trz = getActivity().getSupportFragmentManager().beginTransaction();
        trz.replace(R.id.container1,fragment,tag);
        trz.commit();
    }


    TabLayout.OnTabSelectedListener mOnTabSelectedListener = new TabLayout.OnTabSelectedListener() {

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            switch (tab.getPosition()){
                case 0:
                    viewFragmet(new HotOrNotFragment(),"HOORNOT");
                    break;
                case 1:
                    viewFragmet(new StreamFragment(),"HOORNOT");
                    break;
                case 2:
                    viewFragmet(new MeetMeFragment(),"HOORNOT");
                    break;
                case 3:
                    viewFragmet(new SpeedDatingFragment(),"HOORNOT");
                    break;
            }
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };


}
