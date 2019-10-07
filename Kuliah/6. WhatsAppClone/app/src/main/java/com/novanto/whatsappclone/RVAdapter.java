package com.novanto.whatsappclone;

import android.content.Context;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {
    Context mCtx;
    ArrayList<ChatModel> chatModels;


    public RVAdapter (Context mCtx, ArrayList<ChatModel> chatModels){
        this.mCtx = mCtx;
        this.chatModels = chatModels;
    }

    @NonNull
    @Override
    public RVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_chat, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVAdapter.ViewHolder holder, int position) {
        final ChatModel call = chatModels.get(position);
        holder.tvName.setText(call.getName());
        holder.tvTime.setText(call.getTime());
        holder.tvChat.setText(call.getChat());
    }

    @Override
    public int getItemCount() {
        return chatModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvTime, tvChat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_contact);
            tvTime = itemView.findViewById(R.id.tv_time);
            tvChat = itemView.findViewById(R.id.tv_chat);
        }
    }
}
