package com.novanto.fragmen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder>{
    Context mCtx;
    ArrayList<CallModel> callModels;

    public RVAdapter(Context mCtx, ArrayList<CallModel> callModels){
        this.mCtx = mCtx;
        this.callModels = callModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_call, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    //aksi yang akan ditampilkan di list
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final CallModel call = callModels.get(position);
        holder.tvId.setText(call.getId() + "");
        holder.tvName.setText(call.getName());
        holder.tvDuration.setText(call.getDuration());
    }

    @Override
    public int getItemCount() {
        return callModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, tvName, tvDuration;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvName = itemView.findViewById(R.id.tvName);
            tvDuration = itemView.findViewById((R.id.tvDuration));
        }
    }
}
