package tk.cavinc.connexion.ui.helpers;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import tk.cavinc.connexion.data.models.UserModel;
import tk.cavinc.connexion.data.networks.UserGetApi;
import tk.cavinc.connexion.data.networks.res.GetGuid;
import tk.cavinc.connexion.data.networks.res.GetUsersResult;

import static android.content.ContentValues.TAG;

/**
 * Created by cav on 02.05.20.
 */

public class WorkViewModel extends ViewModel {
    private ArrayList<UserModel> mUsers;

    MutableLiveData<ArrayList<UserModel>> liveData;

    public LiveData<ArrayList<UserModel>> getLiveData(Retrofit retrofit, String guid){
        if (liveData == null) {
            liveData = new MutableLiveData<>();
            loadUsers(retrofit,guid);
        }
        return liveData;
    }

    public ArrayList<UserModel> getUsers() {
        return mUsers;
    }

    public void setUsers(ArrayList<UserModel> users) {
        mUsers = users;
    }

    // загружаем данные
    public void loadUsers(Retrofit retrofit, String guid){
        retrofit.create(UserGetApi.class).getUsers(new GetGuid(guid)).enqueue(new Callback<GetUsersResult>() {
            @Override
            public void onResponse(Call<GetUsersResult> call, Response<GetUsersResult> response) {
                GetUsersResult data = response.body();
                if (response.isSuccessful()) {
                    Log.d(TAG, data.getStatus() + " user count:" + data.getUserCount());
                    mUsers = (ArrayList<UserModel>) data.getUsers();
                    if (liveData!= null) {
                        liveData.postValue(mUsers);
                    }
                    for (UserModel l : mUsers){
                        Log.d(TAG,l.getEmail()+" "+l.getName());
                    }
                } else {
                    Log.d(TAG,data.getError());
                }
            }

            @Override
            public void onFailure(Call<GetUsersResult> call, Throwable t) {
                Log.d(TAG,t.getMessage());
            }
        });

    }
}
