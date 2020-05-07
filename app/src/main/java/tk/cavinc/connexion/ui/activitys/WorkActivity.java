package tk.cavinc.connexion.ui.activitys;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import tk.cavinc.connexion.R;
import tk.cavinc.connexion.data.managers.DataManager;
import tk.cavinc.connexion.ui.fragments.MeetMeFragment;
import tk.cavinc.connexion.ui.fragments.Screen1Fragment;
import tk.cavinc.connexion.ui.fragments.Screen2Fragment;
import tk.cavinc.connexion.ui.fragments.Screen3Fragment;
import tk.cavinc.connexion.ui.fragments.Screen4Fragment;
import tk.cavinc.connexion.ui.fragments.SpeedDatingFragment;
import tk.cavinc.connexion.ui.fragments.HotOrNotFragment;
import tk.cavinc.connexion.ui.fragments.StreamFragment;
import tk.cavinc.connexion.ui.helpers.WorkViewModel;

/**
 * Created by cav on 29.04.20.
 */

public class WorkActivity extends AppCompatActivity {

    private DataManager mDataManager;

    private WorkViewModel model;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
        mDataManager = DataManager.getInstance();

        bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bnv);

        bottomNavigationView.setOnNavigationItemSelectedListener(mBottonNavigationListener);


        model = ViewModelProviders.of(this).get(WorkViewModel.class);
        //model.loadUsers(mDataManager.getRetrofit(),mDataManager.getPreManager().getRegistryUserGuid());

        viewFragment(new Screen1Fragment(),"SR1",false);
    }

    // устанавливаем фрагмент в контейнер
    private void viewFragment(Fragment fragment, String tag,boolean userBackTrack){
        FragmentTransaction trz = getSupportFragmentManager().beginTransaction();
        if (userBackTrack) {
            trz.addToBackStack(null);
        }
        trz.replace(R.id.container,fragment,tag);
        trz.commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener mBottonNavigationListener = new  BottomNavigationView.OnNavigationItemSelectedListener(){

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.bnv_sc1:
                    viewFragment(new Screen1Fragment(),"SR1",false);
                    break;
                case R.id.bnv_sc2:
                    viewFragment(new Screen2Fragment(),"SR2",false);
                    break;
                case R.id.bnv_sc3:
                    viewFragment(new Screen3Fragment(),"SR3",false);
                    break;
                case R.id.bnv_sc4:
                    viewFragment(new Screen4Fragment(),"SR4",false);
                    break;
            }
            return true;
        }
    };
}

