package tk.cavinc.connexion.ui.fragments;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import tk.cavinc.connexion.R;
import tk.cavinc.connexion.data.models.UserModel;
import tk.cavinc.connexion.ui.helpers.RegistryViewModel;

/**
 * Created by cav on 13.04.20.
 */

public class RegistryAgeFragment extends BaseFragment implements View.OnClickListener,LifecycleOwner {

    private Lifecycle lifecycleRegistry;
    private RegistryViewModel mUserModel;

    private EditText mAge;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserModel = ViewModelProviders.of(getActivity()).get(RegistryViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.registry_age_fragment, container, false);
        rootView.findViewById(R.id.registry_next).setOnClickListener(this);
        mAge = rootView.findViewById(R.id.registry_age);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        UserModel model = mUserModel.getUserModel();
        if (model.getAge() != 0) {
            mAge.setText(String.valueOf(model.getAge()));
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.registry_next) {
            setAge();
            setLoadFramentListener(new RegistryUserFragment(),"REG_USER");
        }
    }

    private void setAge() {
        UserModel model = mUserModel.getUserModel();
        model.setAge(Integer.parseInt(mAge.getText().toString()));
        mUserModel.setUserModel(model);
    }

    @Override
    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }
}
