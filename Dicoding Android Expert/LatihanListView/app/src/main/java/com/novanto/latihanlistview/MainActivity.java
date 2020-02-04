package com.novanto.latihanlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Hero_Adapter hero_adapter;
    private String[] data_name;
    private  String[] data_desc;
    private TypedArray data_photo;
    private ArrayList<Hero> heroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv_main);
        hero_adapter = new Hero_Adapter(this);
        listView.setAdapter(hero_adapter);

        prepare();
        addData();

    }

    void prepare(){
        this.data_name = getResources().getStringArray(R.array.data_name);
        data_desc = getResources().getStringArray(R.array.data_description);
        data_photo = getResources().obtainTypedArray(R.array.data_photo);
    }

    void addData(){
        heroes = new ArrayList<>();

        for (int i = 0;i< data_name.length;i++){
            Hero hero = new Hero();
            hero.setPhoto(data_photo.getResourceId(i,-1));
            hero.setHero_name(this.data_name[i]);
            hero.setDesc(data_desc[i]);
            heroes.add(hero);
        }

        hero_adapter.setHeroes(heroes);
    }
}
