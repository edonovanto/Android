package com.novanto.scholarplus;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvBeasiswa;
    private ArrayList<Beasiswa> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Home");

        rvBeasiswa = findViewById(R.id.rv_beasiswa);
        rvBeasiswa.setHasFixedSize(true);

        list.addAll(DataBeasiswa.getListData());
        showRecyclerList();
    }

    private void showSelectedBeasiswa(Beasiswa beasiswa){
        Intent moveIntent = new Intent(MainActivity.this, DetailBeasiswa.class);

        moveIntent.putExtra("Photo",beasiswa.getPhoto());
        moveIntent.putExtra("Judul",beasiswa.getName());
        moveIntent.putExtra("Detail",beasiswa.getDetail());
        moveIntent.putExtra("Syarat",beasiswa.getSyarat());

        startActivity(moveIntent);
    }

    private void showRecyclerList() {
        rvBeasiswa.setLayoutManager(new LinearLayoutManager(this));
        AdapterList adapterList = new AdapterList(list);
        rvBeasiswa.setAdapter(adapterList);

        adapterList.setOnItemClickCallback(new AdapterList.OnItemClickCallback() {
            @Override
            public void onItemClicked(Beasiswa data) {
                showSelectedBeasiswa(data);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int selectedMode) {
        switch (selectedMode){
            case R.id.about_me:
                Intent moveIntent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(moveIntent);
                break;
        }
    }


}
