package tk.cavinc.connexion.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tk.cavinc.connexion.R;
import tk.cavinc.connexion.ui.activitys.RegistryActivity;

/**
 * Created by cav on 13.04.20.
 */

public class LoginFragment extends Fragment implements View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.login_fragment, container, false);

        rootView.findViewById(R.id.login_registry).setOnClickListener(this);
        rootView.findViewById(R.id.login_login).setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login_registry) {
            Intent intent = new Intent(getActivity(), RegistryActivity.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.login_login) {

        }
    }
}
