package tk.cavinc.connexion.data.networks;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import tk.cavinc.connexion.data.models.UserModel;
import tk.cavinc.connexion.data.networks.res.GetUserPost;
import tk.cavinc.connexion.data.networks.res.GetUserRes;

/**
 * Created by cav on 27.04.20.
 */

public interface UserGetApi {
    @POST("api/getuser")
    Call<GetUserRes> getData(@Body GetUserPost userPost);
}
