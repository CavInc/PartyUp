package tk.cavinc.connexion.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tk.cavinc.connexion.R;
import tk.cavinc.connexion.ui.activitys.WorkActivity;

/**
 * Created by cav on 07.05.20.
 */

public class Screen1Fragment extends Fragment {
    private WorkPageAdapter mWorkPageAdapter;

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.screen1_fragment, container, false);

        mWorkPageAdapter = new WorkPageAdapter(getActivity().getSupportFragmentManager());
        mViewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        mViewPager.setAdapter(mWorkPageAdapter);

        mTabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);

        return rootView;
    }

    private class WorkPageAdapter extends FragmentPagerAdapter {

        public WorkPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new HotOrNotFragment();
                case 1:
                    return new StreamFragment();
                case 2:
                    return new MeetMeFragment();
                case 3:
                    return new SpeedDatingFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Фотолинейка";
                case 1:
                    return "Стрим";
                case 2:
                    return "Знакомства";
                case 3:
                    return "Быстрые знакомства";
                default:
                    return null;
            }
        }
    }
}
