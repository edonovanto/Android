package com.novanto.myrecyclerviewexercise;

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

public class AdapterHeroList extends RecyclerView.Adapter<AdapterHeroList.ListView> {
    private ArrayList<Hero> list;
    private OnItemClickCallBack onItemClickCallBack;

    public void setOnItemClickCallBack(OnItemClickCallBack onItemClickCallBack){
        this.onItemClickCallBack = onItemClickCallBack;
    }

    public AdapterHeroList(ArrayList<Hero> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ListView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_hero,parent, false);

        return new ListView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListView holder, int position) {
        final Hero hero = list.get(position);

        Glide.with(holder.itemView.getContext())
                .load(hero.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.photo);
        holder.name.setText(hero.getName());
        holder.desc.setText(hero.getDesc());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallBack.OnItemClick(list.get(holder.getAdapterPosition()));
            }
        });
    }

    public interface OnItemClickCallBack{
        void OnItemClick(Hero data);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ListView extends RecyclerView.ViewHolder {
        TextView name, desc;
        ImageView photo;

        public ListView(@NonNull View itemView) {
            super(itemView);
            photo = itemView.findViewById(R.id.img_item_photo);
            name = itemView.findViewById(R.id.tv_name);
            desc = itemView.findViewById(R.id.tv_desc);
        }
    }
}
