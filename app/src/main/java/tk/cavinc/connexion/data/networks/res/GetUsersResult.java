package tk.cavinc.connexion.data.networks.res;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import tk.cavinc.connexion.data.models.UserModel;

/**
 * Created by cav on 02.05.20.
 */

public class GetUsersResult {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("user_count")
    @Expose
    private Integer userCount;

    @SerializedName("users")
    @Expose
    private List<UserModel> users;

    @SerializedName("result")
    @Expose
    private Integer result;

    @SerializedName("error")
    @Expose
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    public List<UserModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
