package tk.cavinc.connexion.ui.helpers;

import android.arch.lifecycle.ViewModel;

import tk.cavinc.connexion.data.models.UserModel;

/**
 * Created by cav on 17.04.20.
 */

public class RegistryViewModel extends ViewModel{
    private UserModel mUserModel = new UserModel();

    /*
    public RegistryViewModel(UserModel model){
        mUserModel = model;
    }
    */

    public UserModel getUserModel() {
        return mUserModel;
    }

    public void setUserModel(UserModel userModel) {
        mUserModel = userModel;
    }
}
