package tk.cavinc.connexion.ui.fragments;

import android.app.Fragment;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import tk.cavinc.connexion.R;
import tk.cavinc.connexion.data.models.UserModel;
import tk.cavinc.connexion.ui.helpers.OnBackPressedListener;
import tk.cavinc.connexion.ui.helpers.RegistryViewModel;
import tk.cavinc.connexion.utils.ConstantManager;

/**
 * Created by cav on 13.04.20.
 */

public class RegistrySixGenderFragment extends BaseFragment implements View.OnClickListener,OnBackPressedListener {
    private RegistryViewModel mUserModel;

    private Button mSixMale;
    private Button mSixFemale;

    private int six;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserModel = ViewModelProviders.of(getActivity()).get(RegistryViewModel.class);
    }

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
    public void onResume() {
        super.onResume();
        UserModel model = mUserModel.getUserModel();
        if (model.getSix() == ConstantManager.FEMALE) {
            mSixFemale.setBackground(getResources().getDrawable(R.drawable.button_red_bg));
            mSixMale.setBackground(getResources().getDrawable(R.drawable.button_gray_bg));
            six = ConstantManager.FEMALE;
        }
        if (model.getSix() == ConstantManager.MALE) {
            mSixMale.setBackground(getResources().getDrawable(R.drawable.button_red_bg));
            mSixFemale.setBackground(getResources().getDrawable(R.drawable.button_gray_bg));
            six = ConstantManager.MALE;
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.registry_next) {
            storeData();
            setLoadFramentListener(new RegistryPhotoFragment(),"REG_PHOTO");
        }
        if (view.getId() == R.id.six_female_bt) {
            mSixFemale.setBackground(getResources().getDrawable(R.drawable.button_red_bg));
            mSixMale.setBackground(getResources().getDrawable(R.drawable.button_gray_bg));
            six = ConstantManager.FEMALE;
        }
        if (view.getId() == R.id.six_male_bt) {
            mSixMale.setBackground(getResources().getDrawable(R.drawable.button_red_bg));
            mSixFemale.setBackground(getResources().getDrawable(R.drawable.button_gray_bg));
            six = ConstantManager.MALE;
        }
    }

    private void storeData(){
        UserModel model = mUserModel.getUserModel();
        model.setSix(six);
        mUserModel.setUserModel(model);
    }

    @Override
    public void onBackPressed() {
        setLoadFramentListener(new RegistryUserFragment(),"REG_USER");
    }
}
