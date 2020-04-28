package tk.cavinc.connexion.ui.fragments;

import android.app.AlertDialog;
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
import tk.cavinc.connexion.ui.helpers.OnBackPressedListener;
import tk.cavinc.connexion.ui.helpers.RegistryViewModel;
import tk.cavinc.connexion.utils.Func;

/**
 * Created by cav on 13.04.20.
 */

public class RegistryUserFragment extends BaseFragment implements View.OnClickListener,OnBackPressedListener {
    private RegistryViewModel mUserModel;

    private EditText mEmail;
    private EditText mUser;
    private EditText mPass1;
    private EditText mPass2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserModel = ViewModelProviders.of(getActivity()).get(RegistryViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.registry_user_fragment, container, false);
        rootView.findViewById(R.id.registry_next).setOnClickListener(this);
        mEmail = rootView.findViewById(R.id.reg_email);
        mUser = rootView.findViewById(R.id.reg_user_name);
        mPass1 = rootView.findViewById(R.id.reg_user_pass1);
        mPass2 = rootView.findViewById(R.id.reg_user_pass2);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        UserModel model = mUserModel.getUserModel();
        if (model.getEmail() != null) {
            mEmail.setText(model.getEmail());
        }
        if (model.getName() != null) {
            mUser.setText(model.getName());
        }

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.registry_next) {
            testAndNext();

        }
    }

    private void testAndNext() {
        if (mPass1.getText().toString().equals(mPass2.getText().toString())) {
            setData();
            setLoadFramentListener(new RegistrySixGenderFragment(), "REG_SIX");
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Внимание !!!")
                    .setMessage("Пароли не совпадают")
                    .setNegativeButton(R.string.dialog_close,null);
            builder.show();
            return;
        }
    }

    private void setData() {
        UserModel model = mUserModel.getUserModel();
        model.setEmail(mEmail.getText().toString());
        model.setName(mUser.getText().toString());
        //TODO добавить пароль.
        model.setPass(Func.MD5(mPass1.getText().toString()));
        mUserModel.setUserModel(model);
    }

    @Override
    public void onBackPressed() {
        setLoadFramentListener(new RegistryAgeFragment(),"REG_AGE");
    }
}
