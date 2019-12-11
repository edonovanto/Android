package com.android.sqlite;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    public MainActivity ma;
    public ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ma = this;
        recyclerView = findViewById(R.id.recyclerView);
        FloatingActionButton btnAdd = findViewById(R.id.btnAdd);

        loadData();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                BottomSheetAdd bottomSheetAdd = new BottomSheetAdd(null, 0);
                bottomSheetAdd.show(fragmentManager, "TAG");
            }
        });
    }

    private void loadData(){
        ArrayList<Contact> list = new ArrayList<>();
        DBHelper dbHelper = new DBHelper(getApplicationContext());
        String query = "SELECT * FROM sqlite";
        Cursor cursor = dbHelper.getReadableDatabase().rawQuery(query,  null);
        for (int i=0; i<cursor.getCount(); i++){
            cursor.moveToPosition(i);
            Contact contact = new Contact(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            list.add(contact);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}
