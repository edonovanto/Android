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
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

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
    public void onBindViewHolder(@NonNull final tvViewHolder holder, int position) {
        Movie movie = list.get(position);

        Glide.with(holder.itemView.getContext())
                .load(movie.getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imageView);

        holder.tvName.setText(movie.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(list.get(holder.getAdapterPosition()));
            }
        });
    }

    public interface OnItemClickCallback{
        void onItemClicked(Movie movie);
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
