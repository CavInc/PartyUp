package tk.cavinc.connexion.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import tk.cavinc.connexion.data.models.ChatModel;

/**
 * Created by cav on 24.05.20.
 */

public class ChatAdapter extends RecyclerView.Adapter{
    private List<ChatModel> data;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
