package tk.cavinc.connexion.data.managers;

import android.content.SharedPreferences;

import tk.cavinc.connexion.utils.App;

/**
 * Created by cav on 27.04.20.
 */

public class PrefManager {

    private static final String REGISTRY_USER_ID = "RUID";
    private static final String REGISTRY_USER_GUID = "RUG";
    private static final String LOGIN = "LOGIN_USER";
    private static final String USER_PHOTO = "USER_PHOTO";
    private static final String WARNING_MEETME = "WMME";
    private static final String USER_EMAIL = "USER_EMAL";
    private static final String USER_NAME = "USER_NAME";
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

    public boolean isLogin(){
        return mSharedPreferences.getBoolean(LOGIN,false);
    }

    public void setLogin(boolean value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(LOGIN,value);
        editor.apply();
    }

    public String getUserPhoto(){
        return mSharedPreferences.getString(USER_PHOTO,null);
    }

    public void setUserPhoto(String userPhoto) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(USER_PHOTO,userPhoto);
        editor.apply();
    }

    public boolean isWarningMeetMe(){
        return mSharedPreferences.getBoolean(WARNING_MEETME,false);
    }

    public void setWarningMeetme(boolean flag){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(WARNING_MEETME,flag);
        editor.apply();
    }

    public void setRegistryUserEmail(String registryUserEmail) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(USER_EMAIL,registryUserEmail);
        editor.apply();
    }

    public void setRegistryUserName(String registryUserName) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(USER_NAME,registryUserName);
        editor.apply();
    }
}
