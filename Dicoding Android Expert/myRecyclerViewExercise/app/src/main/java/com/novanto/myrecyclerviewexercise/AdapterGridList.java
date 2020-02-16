package com.novanto.myrecyclerviewexercise;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class AdapterGridList extends RecyclerView.Adapter<AdapterGridList.GridViewHolder> {
    ArrayList<Hero> list;
    OnItemClickCallback onItemClickCallback;

    public AdapterGridList(ArrayList<Hero> list) {
        this.list = list;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_hero,parent,false);

        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder holder, int position) {
        Hero hero = list.get(position);

        Glide.with(holder.itemView.getContext())
                .load(hero.getPhoto())
                .apply(new RequestOptions())
                .into(holder.photo);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.OnItemClick(list.get(holder.getAdapterPosition()));
            }
        });
    }

    public interface OnItemClickCallback{
        void OnItemClick(Hero data);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView photo;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);

            photo = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
