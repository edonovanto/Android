package com.novanto.myrecyclerviewexercise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Hero> list = new ArrayList<>();
    RecyclerView rvHeroes;
    String title = "List";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHeroes =findViewById(R.id.rv_heroes);
        rvHeroes.setHasFixedSize(true);

        getList();
        setActionTitleBar(title);
        showRecyclerList();
    }

    public ArrayList<Hero> getList() {
        String[] nameHero =getResources().getStringArray(R.array.data_name);
        String[] descHero = getResources().getStringArray(R.array.data_description);
        String[] photoHero = getResources().getStringArray(R.array.data_photo);



        for (int i=0; i<nameHero.length;i++){
            Hero hero = new Hero();
            hero.setName(nameHero[i]);
            hero.setDesc(descHero[i]);
            hero.setPhoto(photoHero[i]);

            list.add(hero);
        }
        return list;
    }

    void showRecyclerList(){
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        AdapterHeroList adapterHeroList = new AdapterHeroList(list);
        rvHeroes.setAdapter(adapterHeroList);

        adapterHeroList.setOnItemClickCallBack(new AdapterHeroList.OnItemClickCallBack() {
            @Override
            public void OnItemClick(Hero data) {
                showSelectedHero(data);
            }
        });
    }

    void showRecyclerGrid(){
        rvHeroes.setLayoutManager(new GridLayoutManager(this,2));
        AdapterGridList adapterGridList = new AdapterGridList(list);
        rvHeroes.setAdapter(adapterGridList);

        adapterGridList.setOnItemClickCallback(new AdapterGridList.OnItemClickCallback() {
            @Override
            public void OnItemClick(Hero data) {
                showSelectedHero(data);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selected_mode){
        switch (selected_mode){
            case R.id.action_list:
                title = "List";
                showRecyclerList();
                break;
            case R.id.action_grid:
                title = "Grid";
                showRecyclerGrid();
                break;
        }
        setActionTitleBar(title);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    void setActionTitleBar(String title){
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }

    void showSelectedHero(Hero data){
        Toast.makeText(this,"Kamu memilih " + data.getName(), Toast.LENGTH_SHORT).show();
    }
}
