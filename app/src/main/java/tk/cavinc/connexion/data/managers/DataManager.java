package tk.cavinc.connexion.data.managers;

import android.content.Context;

import tk.cavinc.connexion.utils.App;

/**
 * Created by cav on 13.04.20.
 */

public class DataManager {
    private static DataManager INSTANCE = null;

    private Context mContext;
    //private PrefManager mPreManager;

    public static DataManager getInstance() {
        if (INSTANCE==null){
            INSTANCE = new DataManager();
        }
        return INSTANCE;
    }

    public DataManager() {
        mContext = App.getContext();
    }

    public Context getContext() {
        return mContext;
    }
}
