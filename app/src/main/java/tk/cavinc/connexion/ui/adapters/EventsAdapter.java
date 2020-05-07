package tk.cavinc.connexion.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import tk.cavinc.connexion.R;
import tk.cavinc.connexion.data.models.EventsModel;
import tk.cavinc.connexion.utils.Func;

/**
 * Created by cav on 07.05.20.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {
    private ArrayList<EventsModel> data;

    public EventsAdapter(ArrayList<EventsModel> dataModel){
        data = dataModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.scevent_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EventsModel record = data.get(position);
        holder.mMsg.setText(record.getMsg());
        holder.mDateEvent.setText(Func.dateToStr(record.getDateEvent(),"HH:mm dd-MM-yyyy"));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mMsg;
        private TextView mDateEvent;

        public ViewHolder(View itemView) {
            super(itemView);
            mMsg = itemView.findViewById(R.id.scevent_msg);
            mDateEvent = itemView.findViewById(R.id.scevent_date);
        }
    }
}
