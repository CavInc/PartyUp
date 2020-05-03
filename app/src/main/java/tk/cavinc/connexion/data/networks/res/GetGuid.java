package tk.cavinc.connexion.data.networks.res;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by cav on 02.05.20.
 */

public class GetGuid {
    @SerializedName("guid")
    @Expose
    private String guid;

    public GetGuid(String guid){
        this.guid = guid;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}
