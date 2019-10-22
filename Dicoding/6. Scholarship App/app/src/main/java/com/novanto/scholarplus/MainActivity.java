package com.novanto.scholarplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvBeasiswa;
    private ArrayList<Beasiswa> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvBeasiswa = findViewById(R.id.rv_beasiswa);
        rvBeasiswa.setHasFixedSize(true);

        list.addAll(DataBeasiswa.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvBeasiswa.setLayoutManager(new LinearLayoutManager(this));
        AdapterList adapterList = new AdapterList(list);
        rvBeasiswa.setAdapter(adapterList);
    }


}
