package tk.cavinc.connexion.data.managers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.File;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tk.cavinc.connexion.data.models.LatLot;
import tk.cavinc.connexion.utils.App;
import tk.cavinc.connexion.utils.ConstantManager;

/**
 * Created by cav on 13.04.20.
 */

public class DataManager {
    private static DataManager INSTANCE = null;

    private Context mContext;
    private PrefManager mPreManager;

    private Retrofit mRetrofit;

    private boolean mPermissionLocate = false; // разрешщение на геолокацию
    private LatLot latLot;

    public static DataManager getInstance() {
        if (INSTANCE==null){
            INSTANCE = new DataManager();
        }
        return INSTANCE;
    }

    public DataManager() {
        mContext = App.getContext();
        mPreManager = new PrefManager();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(ConstantManager.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Context getContext() {
        return mContext;
    }

    public PrefManager getPreManager() {
        return mPreManager;
    }

    // получаем путь папки приложения на Storage
    public File getAppStoragePath(){

        File resutl = mContext.getExternalFilesDir(null);

        return resutl;
    }

    // проверяем включен ли интернетик
    public boolean isOnline(){
        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);;
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }

    // координаты устройства
    public LatLot getCoordinate(){
        return latLot;
    }

    public void setCoordinate(double lat,double lot) {
        latLot = new LatLot(lat,lot);
    }

    public boolean isPermissionLocate() {
        return mPermissionLocate;
    }

    public void setPermissionLocate(boolean permissionLocate) {
        mPermissionLocate = permissionLocate;
    }

}
