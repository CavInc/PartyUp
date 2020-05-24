package tk.cavinc.connexion.ui.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tk.cavinc.connexion.R;
import tk.cavinc.connexion.data.managers.DataManager;
import tk.cavinc.connexion.ui.adapters.ChatAdapter;

/**
 * Created by cav on 07.05.20.
 */

public class ScChatFragment extends Fragment {
    private DataManager mDataManager;
    private ChatAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataManager = DataManager.getInstance();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.schat_fragment, container, false);
        mRecyclerView = rootView.findViewById(R.id.chat_lv);

        return rootView;
    }
}


