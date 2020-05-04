package tk.cavinc.connexion.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import tk.cavinc.connexion.R;
import tk.cavinc.connexion.data.managers.DataManager;
import tk.cavinc.connexion.ui.dialogs.WarningMeetMeDialog;

/**
 * Created by cav on 29.04.20.
 */

public class MeetMeFragment extends Fragment implements OnMapReadyCallback {
    private static final String TAG = "MMF";

    private DataManager mDataManager;

    private GoogleMap mMap;
    private SupportMapFragment mapFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataManager = DataManager.getInstance();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.meetme_fragment, container, false);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        VisibleMap();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!mDataManager.getPreManager().isWarningMeetMe()) {
            WarningMeetMeDialog dialog = new WarningMeetMeDialog();
            dialog.show(getActivity().getSupportFragmentManager(),"WMME");
        }
    }

    private void VisibleMap(){
        if (mapFragment == null) {
            FragmentManager fmx = this.getChildFragmentManager();
            Fragment tzit = fmx.findFragmentById(R.id.map);
            mapFragment = (SupportMapFragment) fmx.findFragmentById(R.id.map);
            if (tzit != null) {
                Log.d(TAG, "ESX MAP");
                mapFragment.getMapAsync(this);
            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.getUiSettings().setMyLocationButtonEnabled(true);

    }
}
