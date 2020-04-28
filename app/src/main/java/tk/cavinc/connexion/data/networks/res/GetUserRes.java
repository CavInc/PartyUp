package tk.cavinc.connexion.data.networks.res;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
    private User user;

    public boolean isStatus() {
        return status;
    }

    public int getResult() {
        return result;
    }

    public String getError() {
        return error;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public class User{
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("guid")
        @Expose
        private String guid;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getGuid() {
            return guid;
        }

        public void setGuid(String guid) {
            this.guid = guid;
        }
    }
}
