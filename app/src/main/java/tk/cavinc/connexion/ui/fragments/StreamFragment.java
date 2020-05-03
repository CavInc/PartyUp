package tk.cavinc.connexion.ui.fragments;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import tk.cavinc.connexion.R;
import tk.cavinc.connexion.data.managers.DataManager;
import tk.cavinc.connexion.data.models.UserModel;
import tk.cavinc.connexion.ui.adapters.StreamRVAdapter;
import tk.cavinc.connexion.ui.helpers.WorkViewModel;

/**
 * Created by cav on 29.04.20.
 */

public class StreamFragment extends Fragment {
    private DataManager mDataManager;

    private RecyclerView mRecyclerView;

    private StreamRVAdapter mAdapter;
    private WorkViewModel model;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataManager = DataManager.getInstance();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.stream_fragment, container, false);

        mRecyclerView = rootView.findViewById(R.id.stream_lv);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);

        mRecyclerView.setLayoutManager(gridLayoutManager);


        /*
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        */


        model =  ViewModelProviders.of(this).get(WorkViewModel.class);
        //model.loadUsers(mDataManager.getRetrofit(),mDataManager.getPreManager().getRegistryUserGuid());

        LiveData<ArrayList<UserModel>> livedata = model.getLiveData(mDataManager.getRetrofit(),
                mDataManager.getPreManager().getRegistryUserGuid());

        livedata.observe(this, new Observer<ArrayList<UserModel>>() {
            @Override
            public void onChanged(@Nullable ArrayList<UserModel> userModels) {
                updateUI();
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        //updateUI();
    }

    private void updateUI(){
        ArrayList<UserModel> data = model.getUsers();
        if (mAdapter == null){
            mAdapter = new StreamRVAdapter(data);
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setData(data);
            mAdapter.notifyDataSetChanged();
        }
    }
}
