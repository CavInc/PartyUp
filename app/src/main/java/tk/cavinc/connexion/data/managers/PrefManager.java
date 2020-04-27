package tk.cavinc.connexion.data.managers;

import android.content.SharedPreferences;

import tk.cavinc.connexion.utils.App;

/**
 * Created by cav on 27.04.20.
 */

public class PrefManager {

    private SharedPreferences mSharedPreferences;

    public PrefManager(){
        mSharedPreferences = App.sSharedPreferences;
    }
}
