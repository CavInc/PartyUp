package tk.cavinc.connexion.data.networks.res;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by cav on 27.04.20.
 */

public class GetUserPost {
    //{u'email': u'test@kempir.com', u'pass': u'324242342343'}

    @SerializedName("email")
    @Expose
    private String mEmail;

    @SerializedName("pass")
    @Expose
    private String mPass;

    public GetUserPost(String email, String pass) {
        mEmail = email;
        mPass = pass;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getPass() {
        return mPass;
    }
}
