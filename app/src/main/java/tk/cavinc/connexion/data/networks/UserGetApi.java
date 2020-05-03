package tk.cavinc.connexion.data.networks;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;
import tk.cavinc.connexion.data.models.UserModel;
import tk.cavinc.connexion.data.networks.res.GetGuid;
import tk.cavinc.connexion.data.networks.res.GetUserPost;
import tk.cavinc.connexion.data.networks.res.GetUserRes;
import tk.cavinc.connexion.data.networks.res.GetUsersResult;

/**
 * Created by cav on 27.04.20.
 */

public interface UserGetApi {
    @POST("api/getuser")
    Call<GetUserRes> getData(@Body GetUserPost userPost);

    @POST("api/adduser")
    Call<GetUserRes> addUser(@Body UserModel getUserRes);

   @POST("/api/getusers")
    Call<GetUsersResult> getUsers(@Body GetGuid guid);
}
