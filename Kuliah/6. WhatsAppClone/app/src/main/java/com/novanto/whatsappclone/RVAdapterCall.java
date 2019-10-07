package com.novanto.whatsappclone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapterCall extends RecyclerView.Adapter<RVAdapterCall.ViewHolder> {
    Context mCtx;
    ArrayList<CallModel> callModels;

    public RVAdapterCall(Context mCtx, ArrayList<CallModel> callModels){
        this.mCtx = mCtx;
        this.callModels = callModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_calls, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final CallModel call = callModels.get(position);
        holder.tvName.setText(call.getName());
        holder.tvTime.setText(call.getTime());
    }

    @Override
    public int getItemCount() {
        return callModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvTime, tvChat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_contact);
            tvTime = itemView.findViewById(R.id.tv_time);
        }
    }
}
