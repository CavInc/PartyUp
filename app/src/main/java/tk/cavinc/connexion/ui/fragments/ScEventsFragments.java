package tk.cavinc.connexion.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tk.cavinc.connexion.R;
import tk.cavinc.connexion.data.managers.DataManager;
import tk.cavinc.connexion.data.models.EventsModel;
import tk.cavinc.connexion.data.networks.UserGetApi;
import tk.cavinc.connexion.data.networks.res.GetEventResult;
import tk.cavinc.connexion.data.networks.res.GetGuid;
import tk.cavinc.connexion.ui.adapters.EventsAdapter;

/**
 * Created by cav on 07.05.20.
 */

public class ScEventsFragments extends Fragment {
    private static final String TAG = "SEF";
    private DataManager mDataManager;

    private RecyclerView mRecyclerView;
    private EventsAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataManager = DataManager.getInstance();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.scevents_fragment, container, false);

        mRecyclerView = rootView.findViewById(R.id.scevents_rv);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(manager);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    private void loadData(){
        mDataManager.getRetrofit().create(UserGetApi.class)
                .getUserEvent(new GetGuid(mDataManager.getPreManager().getRegistryUserGuid()))
                .enqueue(new Callback<GetEventResult>() {
            @Override
            public void onResponse(Call<GetEventResult> call, Response<GetEventResult> response) {
                if (response.isSuccessful()) {
                    GetEventResult data = response.body();
                    ArrayList<EventsModel> record = (ArrayList<EventsModel>) data.getEventsModelList();
                    updateUI(record);
                }
            }

            @Override
            public void onFailure(Call<GetEventResult> call, final Throwable t) {
                Log.d(TAG,t.getLocalizedMessage());
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(),t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    private void updateUI(ArrayList<EventsModel> dataModel){
       if (mAdapter == null) {
           mAdapter = new EventsAdapter(dataModel);
           mRecyclerView.setAdapter(mAdapter);
       } else {
           mAdapter.notifyDataSetChanged();
       }

    }
}
