package tk.cavinc.connexion.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import tk.cavinc.connexion.R;
import tk.cavinc.connexion.data.models.UserModel;
import tk.cavinc.connexion.ui.helpers.StreamItemClickListener;
import tk.cavinc.connexion.utils.ConstantManager;

/**
 * Created by cav on 29.04.20.
 */

public class StreamRVAdapter extends RecyclerView.Adapter<StreamRVAdapter.ViewHolder> {
    private ArrayList<UserModel> data;
    private Context mContext;

    public StreamItemClickListener mStreamItemClickListener;

    public StreamRVAdapter(Context context,ArrayList<UserModel> data){
        this.data = data;
        mContext = context;
    }

    public StreamRVAdapter(Context context,ArrayList<UserModel> data,StreamItemClickListener listener){
        this.data = data;
        mStreamItemClickListener = listener;
        mContext = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stream_item,parent,false);
        return new ViewHolder(view,mStreamItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserModel record = data.get(position);
        holder.mUserName.setText(record.getName());
        if (record.getPhoto() != null & record.getPhoto().length() != 0) {
            Picasso.with(mContext)
                    .load(ConstantManager.BASE_URL+ConstantManager.GET_IMAGES+"/"+record.getPhoto())
                    .fit()
                    .into(holder.mUserPhoto);

        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(ArrayList<UserModel> values) {
        //this.data.clear();
        //data.addAll(values);
        //data = values;
       // notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView mUserPhoto;
        private TextView mUserName;

        private StreamItemClickListener mStreamItemClickListener;

        public ViewHolder(View itemView,StreamItemClickListener listener) {
            super(itemView);
            mUserPhoto = itemView.findViewById(R.id.user_photo);
            mUserName = itemView.findViewById(R.id.user_name);
            mStreamItemClickListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
