package com.novanto.myrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHeroes;
    private ArrayList<Hero> list = new ArrayList<>();
    private final String STATE_TITLE = "state_string";
    private final String STATE_LIST = "state_list";
    private final String STATE_MODE = "state_mode";
    private String title = "Mode List";
    private int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHeroes = findViewById(R.id.rv_heroes);
        rvHeroes.setHasFixedSize(true); //untuk apa

        if (savedInstanceState == null) {
            setActionBarTitle(title);
            list.addAll(getListHeroes());
            showReyclerList();
            mode = R.id.action_list;
        } else {
            title = savedInstanceState.getString(STATE_TITLE);
            ArrayList<Hero> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(title);
            if (stateList != null) {
                list.addAll(stateList);
            }
            setMode(stateMode);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, title);
        outState.putParcelableArrayList(STATE_LIST, list);
        outState.putInt(STATE_MODE, mode);
    }

    public ArrayList<Hero> getListHeroes(){

        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDesc = getResources().getStringArray(R.array.data_description);
        String[] dataPhoto = getResources().getStringArray(R.array.data_photo);

        ArrayList<Hero> listHero = new ArrayList<>();
        for(int i=0; i<dataName.length;i++){
            Hero hero = new Hero();
            hero.setName(dataName[i]);
            hero.setDesc(dataDesc[i]);
            hero.setPhoto(dataPhoto[i]);

            listHero.add(hero);
        }
        return listHero;
    }

    void showReyclerList(){
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        ListHeroAdapter listHeroAdapter = new ListHeroAdapter(list);
        rvHeroes.setAdapter(listHeroAdapter);

        listHeroAdapter.setOnItemClickCallback(new ListHeroAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Hero data) {
                showSelectedHero(data);
            }
        });
    }

    void showRecylerGrid(){
        rvHeroes.setLayoutManager(new GridLayoutManager(this,3));
        GridHeroAdapter gridHeroAdapter = new GridHeroAdapter(list);
        rvHeroes.setAdapter(gridHeroAdapter);

        gridHeroAdapter.setOnClickCallback(new GridHeroAdapter.OnItemClickCallback() {
            @Override
            public void onItemClick(Hero data) {
                showSelectedHero(data);
            }
        });
    }

    void showRecyclerCard(){
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        CardViewHeroAdapter cardHeroAdapter = new CardViewHeroAdapter(list);
        rvHeroes.setAdapter(cardHeroAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    void setMode(int selected_mode){
        switch (selected_mode){
            case R.id.action_list:
                title = "Mode List";
                showReyclerList();
                break;
            case R.id.action_grid:
                title = "Mode Grid";
                showRecylerGrid();
                break;
            case R.id.action_cardView:
                title = "Mode Card";
                showRecyclerCard();
                break;
        }

        mode = selected_mode;
        setActionBarTitle(title);
    }

    private void setActionBarTitle(String title) {
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }

    private void showSelectedHero(Hero hero){
        Toast.makeText(this, "Kamu Memilih " + hero.getName(), Toast.LENGTH_SHORT).show();
    }
}
