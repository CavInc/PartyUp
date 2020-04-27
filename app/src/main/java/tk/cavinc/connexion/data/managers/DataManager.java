package tk.cavinc.connexion.data.managers;

import android.content.Context;

import java.io.File;

import tk.cavinc.connexion.utils.App;

/**
 * Created by cav on 13.04.20.
 */

public class DataManager {
    private static DataManager INSTANCE = null;

    private Context mContext;
    private PrefManager mPreManager;

    public static DataManager getInstance() {
        if (INSTANCE==null){
            INSTANCE = new DataManager();
        }
        return INSTANCE;
    }

    public DataManager() {
        mContext = App.getContext();
        mPreManager = new PrefManager();
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

}
