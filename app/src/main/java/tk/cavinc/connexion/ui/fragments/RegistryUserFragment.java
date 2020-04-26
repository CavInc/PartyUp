package tk.cavinc.connexion.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tk.cavinc.connexion.R;
import tk.cavinc.connexion.ui.helpers.OnBackPressedListener;

/**
 * Created by cav on 13.04.20.
 */

public class RegistryUserFragment extends BaseFragment implements View.OnClickListener,OnBackPressedListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.registry_user_fragment, container, false);
        rootView.findViewById(R.id.registry_next).setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.registry_next) {
            setLoadFramentListener(new RegistrySixGenderFragment(),"REG_SIX");
        }
    }

    @Override
    public void onBackPressed() {
        setLoadFramentListener(new RegistryAgeFragment(),"REG_AGE");
    }
}
