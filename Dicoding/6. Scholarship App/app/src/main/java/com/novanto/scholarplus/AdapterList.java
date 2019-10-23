package com.novanto.scholarplus;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ListViewHolder> {
    private ArrayList<Beasiswa> listBeasiswa;
    private OnItemClickCallback onItemClickCallBack;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallBack){
        this.onItemClickCallBack = onItemClickCallBack;
    }


    public AdapterList(ArrayList<Beasiswa> list){
        this.listBeasiswa = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_beasiswa,viewGroup,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Beasiswa beasiswa = listBeasiswa.get(position);
        Glide.with(holder.itemView.getContext())
                .load(beasiswa.getPhoto())
                .apply(new RequestOptions().override(100,100))
                .into(holder.imgPhoto);
        holder.tvName.setText(beasiswa.getName());
        holder.tvDetail.setText(beasiswa.getDetail());
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onItemClickCallBack.onItemClicked(listBeasiswa.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBeasiswa.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvDetail;
        ImageView imgPhoto;

        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDetail = itemView.findViewById(R.id.tv_detail);
        }
    }

    public interface OnItemClickCallback{
        void onItemClicked(Beasiswa data);
    }
}
