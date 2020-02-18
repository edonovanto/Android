package com.novanto.mymovieandtv;

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

public class TVAdapter extends RecyclerView.Adapter<TVAdapter.tvViewHolder> {
    ArrayList<Movie> list;

    public TVAdapter(ArrayList<Movie> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public tvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tv,parent,false);
        return new tvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull tvViewHolder holder, int position) {
        Movie movie = list.get(position);

        Glide.with(holder.itemView.getContext())
                .load(movie.getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imageView);

        holder.tvName.setText(movie.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class tvViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView imageView;

        public tvViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_tvShow);
            imageView = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
