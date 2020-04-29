package tk.cavinc.connexion.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tk.cavinc.connexion.R;
import tk.cavinc.connexion.data.managers.DataManager;
import tk.cavinc.connexion.data.networks.UserGetApi;
import tk.cavinc.connexion.data.networks.res.GetUserPost;
import tk.cavinc.connexion.data.networks.res.GetUserRes;
import tk.cavinc.connexion.ui.activitys.RegistryActivity;
import tk.cavinc.connexion.ui.activitys.WorkActivity;
import tk.cavinc.connexion.utils.Func;

/**
 * Created by cav on 13.04.20.
 */

public class LoginFragment extends Fragment implements View.OnClickListener{
    private static final String TAG = "DDD";
    private DataManager mDataManager;

    private EditText mEmail;
    private EditText mPass;

    private TextView mLoginMsg;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataManager = DataManager.getInstance();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.login_fragment, container, false);

        rootView.findViewById(R.id.login_registry).setOnClickListener(this);
        rootView.findViewById(R.id.login_login).setOnClickListener(this);

        mEmail = rootView.findViewById(R.id.login_email);
        mPass = rootView.findViewById(R.id.login_pass);

        mLoginMsg = rootView.findViewById(R.id.login_msg);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login_registry) {
            Intent intent = new Intent(getActivity(), RegistryActivity.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.login_login) {
            sendData();
        }
    }

    private void sendData() {
        GetUserPost userPost = new GetUserPost(mEmail.getText().toString(), Func.MD5(mPass.getText().toString()));
        mDataManager.getRetrofit().create(UserGetApi.class)
                .getData(userPost)
                .enqueue(new Callback<GetUserRes>() {
                    @Override
                    public void onResponse(Call<GetUserRes> call, Response<GetUserRes> response) {
                        GetUserRes data = response.body();
                        Log.d(TAG,"DATA :"+data.getResult()+" "+data.isStatus());
                        if (data.getUser().getGuid() == null) {
                            Log.d(TAG,"NO USER");
                            mLoginMsg.setText("Не верный email или пароль");
                            mLoginMsg.setVisibility(View.VISIBLE);
                        } else {
                            mLoginMsg.setVisibility(View.GONE);
                            mDataManager.getPreManager().setLogin(true);
                            Intent intent = new Intent(getActivity(),WorkActivity.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<GetUserRes> call, Throwable t) {
                        Toast.makeText(getActivity(),t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                    }
                });
    }
}
