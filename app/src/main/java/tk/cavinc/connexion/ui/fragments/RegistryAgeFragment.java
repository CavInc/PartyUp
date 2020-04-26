package tk.cavinc.connexion.ui.fragments;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
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

public class RegistryAgeFragment extends BaseFragment implements View.OnClickListener,LifecycleOwner {

    private Lifecycle lifecycleRegistry;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.registry_age_fragment, container, false);
        rootView.findViewById(R.id.registry_next).setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.registry_next) {
            setLoadFramentListener(new RegistryUserFragment(),"REG_USER");
        }
    }

    @Override
    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }
}
