package com.novanto.mylistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Hero_Adapter extends BaseAdapter {
    private Context context;
    private ArrayList<Hero> heroes = new ArrayList<>();

    public Hero_Adapter(Context context) {
        this.context = context;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    @Override
    public int getCount() {
        return heroes.size();
    }

    @Override
    public Object getItem(int i) {
        return heroes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_hero, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        Hero hero = (Hero) getItem(i);
        viewHolder.bind(hero);

        return itemView;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescripion;
        private ImageView imgPhoto;

        ViewHolder(View view){
            txtName = view.findViewById(R.id.txt_name);
            txtDescripion = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind(Hero hero){
            txtName.setText(hero.getName());
            txtDescripion.setText(hero.getDescription());
            imgPhoto.setImageResource(hero.getPhoto());
        }

    }
}
