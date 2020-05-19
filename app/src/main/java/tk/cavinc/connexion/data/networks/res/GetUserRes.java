package tk.cavinc.connexion.data.networks.res;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import tk.cavinc.connexion.data.models.UserModel;

/**
 * Created by cav on 27.04.20.
 */

public class GetUserRes {
    //{'status': True, 'user': {}, 'result': 200}

    @SerializedName("status")
    @Expose
    private boolean status;

    @SerializedName("result")
    @Expose
    private int result;

    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("user")
    @Expose
    private UserModel user;

    public boolean isStatus() {
        return status;
    }

    public int getResult() {
        return result;
    }

    public String getError() {
        return error;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

}
