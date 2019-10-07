package com.novanto.whatsappclone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapterStatus extends RecyclerView.Adapter<RVAdapterStatus.ViewHolder> {
    Context mCtx;
    ArrayList<StatusModel> statusModels;

    public RVAdapterStatus(Context mCtx, ArrayList<StatusModel> statusModels){
        this.mCtx = mCtx;
        this.statusModels = statusModels;
    }

    @NonNull
    @Override
    public RVAdapterStatus.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_calls, viewGroup, false);
        return new RVAdapterStatus.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVAdapterStatus.ViewHolder holder, int position) {
        final StatusModel call = statusModels.get(position);
        holder.tvName.setText(call.getName());
        holder.tvTime.setText(call.getTime());
    }

    @Override
    public int getItemCount() {
        return statusModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_contact);
            tvTime = itemView.findViewById(R.id.tv_time);
        }
    }
}
