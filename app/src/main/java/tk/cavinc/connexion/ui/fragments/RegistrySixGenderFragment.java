package tk.cavinc.connexion.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tk.cavinc.connexion.R;

/**
 * Created by cav on 13.04.20.
 */

public class RegistrySixGenderFragment extends BaseFragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.registry_six_fragment, container, false);

        return rootView;
    }

    @Override
    public void onClick(View view) {

    }
}
