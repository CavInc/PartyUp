package tk.cavinc.connexion.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import tk.cavinc.connexion.R;
import tk.cavinc.connexion.ui.helpers.OnBackPressedListener;

/**
 * Created by cav on 13.04.20.
 */

public class RegistrySixGenderFragment extends BaseFragment implements View.OnClickListener,OnBackPressedListener {
    private Button mSixMale;
    private Button mSixFemale;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.registry_six_fragment, container, false);
        mSixMale = rootView.findViewById(R.id.six_male_bt);
        mSixMale.setOnClickListener(this);
        mSixFemale = rootView.findViewById(R.id.six_female_bt);
        mSixFemale.setOnClickListener(this);
        rootView.findViewById(R.id.registry_next).setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.registry_next) {
            setLoadFramentListener(new RegistryPhotoFragment(),"REG_PHOTO");
        }
        if (view.getId() == R.id.six_female_bt) {
            mSixFemale.setBackground(getResources().getDrawable(R.drawable.button_red_bg));
        }
        if (view.getId() == R.id.six_male_bt) {
            mSixMale.setBackground(getResources().getDrawable(R.drawable.button_red_bg));
        }
    }

    @Override
    public void onBackPressed() {
        setLoadFramentListener(new RegistryUserFragment(),"REG_USER");
    }
}
