package tk.cavinc.connexion.ui.activitys;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import tk.cavinc.connexion.R;
import tk.cavinc.connexion.data.managers.DataManager;
import tk.cavinc.connexion.ui.fragments.LoginFragment;

public class MainActivity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_LOCATION = 231;
    private DataManager mDataManager;

    private static final int PERMISSION_REQUEST_CODE = 234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDataManager = DataManager.getInstance();

        if (mDataManager.getPreManager().isLogin()) {
            // входим сразу на рабочий экран
            Intent intent = new Intent(this,WorkActivity.class);
            startActivity(intent);
        }
        viewFragment(new LoginFragment(),"LOGIN");

    }

    // устанавливаем фрагмент в контейнер
    private void viewFragment(Fragment fragment, String tag){
        FragmentTransaction trz = getSupportFragmentManager().beginTransaction();
        trz.replace(R.id.container,fragment,tag);
        trz.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkAndSetPermission();
    }

    private void checkAndSetPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},PERMISSION_REQUEST_CODE);
        }

        if (ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION},PERMISSION_REQUEST_LOCATION);
        } else {
            mDataManager.setPermissionLocate(true);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case PERMISSION_REQUEST_CODE :

                break;
            case PERMISSION_REQUEST_LOCATION:
                System.out.println(permissions);
                System.out.println(grantResults);
                break;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
