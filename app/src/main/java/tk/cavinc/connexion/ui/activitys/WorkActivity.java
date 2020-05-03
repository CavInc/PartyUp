package tk.cavinc.connexion.ui.activitys;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import tk.cavinc.connexion.R;
import tk.cavinc.connexion.data.managers.DataManager;
import tk.cavinc.connexion.ui.fragments.MeetMeFragment;
import tk.cavinc.connexion.ui.fragments.StreamFragment;
import tk.cavinc.connexion.ui.helpers.WorkViewModel;

/**
 * Created by cav on 29.04.20.
 */

public class WorkActivity extends AppCompatActivity {

    private DataManager mDataManager;
    private WorkPageAdapter mWorkPageAdapter;

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
        mDataManager = DataManager.getInstance();

        mWorkPageAdapter = new WorkPageAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(mWorkPageAdapter);

        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);

        WorkViewModel model = ViewModelProviders.of(this).get(WorkViewModel.class);
        model.loadUsers(mDataManager.getRetrofit(),mDataManager.getPreManager().getRegistryUserGuid());
    }


    private class WorkPageAdapter extends FragmentPagerAdapter {

        public WorkPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new StreamFragment();
                case 1:
                    return new MeetMeFragment();
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
                    return "Стрим";
                case 1:
                    return "Знакомства";
                default:
                    return null;
            }
        }
    }
}

