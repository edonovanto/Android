package com.novanto.latihanlistview;

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
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.hero_list,viewGroup,false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Hero hero = (Hero) getItem(i);
        viewHolder.bind(hero);

        return view;
    }

    class ViewHolder {
        private TextView name;
        private TextView desc;
        private ImageView img;

        ViewHolder(View view){
            name = view.findViewById(R.id.txt_name);
            desc = view.findViewById(R.id.txt_description);
            img = view.findViewById(R.id.img_photo);
        }

        void bind(Hero hero){
            name.setText(hero.getHero_name());
            desc.setText(hero.getDesc());
            img.setImageResource(hero.getPhoto());
        }
    }
}
