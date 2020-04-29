package tk.cavinc.connexion.data.managers;

import android.content.SharedPreferences;

import tk.cavinc.connexion.utils.App;

/**
 * Created by cav on 27.04.20.
 */

public class PrefManager {

    private static final String REGISTRY_USER_ID = "RUID";
    private static final String REGISTRY_USER_GUID = "RUG";
    private SharedPreferences mSharedPreferences;

    public PrefManager(){
        mSharedPreferences = App.sSharedPreferences;
    }


    public int getRegistryUserId(){
        return mSharedPreferences.getInt(REGISTRY_USER_ID,-1);
    }

    public void setRegistryUserId(Integer registryUserId) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(REGISTRY_USER_ID,registryUserId);
        editor.apply();
    }

    public String getRegistryUserGuid(){
        return mSharedPreferences.getString(REGISTRY_USER_GUID,null);
    }

    public void setRegistryUserGuid(String registryUserGuid) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(REGISTRY_USER_GUID,registryUserGuid);
        editor.apply();
    }
}
