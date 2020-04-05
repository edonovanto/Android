package com.novanto.myviewmodel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private ArrayList<WeatherItems> mData = new ArrayList<>();

    public void setData(ArrayList<WeatherItems> items){
        mData.clear();
        mData.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.weather_items,viewGroup, false);
        return new WeatherViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder weatherViewHolder, int position) {
        weatherViewHolder.bind(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class WeatherViewHolder extends RecyclerView.ViewHolder {

        TextView textViewCity;
        TextView textViewTemperature;
        TextView textViewDescription;

        WeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCity = itemView.findViewById(R.id.textCity);
            textViewTemperature = itemView.findViewById(R.id.textTemp);
            textViewDescription = itemView.findViewById(R.id.textDesc);
        }

        void bind(WeatherItems weatherItems) {
            textViewCity.setText(weatherItems.getName());
            textViewTemperature.setText(weatherItems.getTemperature());
            textViewDescription.setText(weatherItems.getDescription());
        }
    }
}
