package tk.cavinc.connexion.ui.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import tk.cavinc.connexion.R;
import tk.cavinc.connexion.data.managers.DataManager;
import tk.cavinc.connexion.ui.fragments.RegistryAgeFragment;
import tk.cavinc.connexion.ui.helpers.LoadFramentListener;

/**
 * Created by cav on 13.04.20.
 */

public class RegistryActivity extends AppCompatActivity implements LoadFramentListener {
    private ActionBar actionBar;
    private DataManager mDataManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registry);

        setupToolBar();
        viewFragment(new RegistryAgeFragment(),"REG_AGE",false);
    }

    public void setupToolBar(){
        actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Регистрация");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
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

    @Override
    public void onLoadFragment(Fragment fragment, String tag) {
        viewFragment(fragment,tag,false);
    }
}
