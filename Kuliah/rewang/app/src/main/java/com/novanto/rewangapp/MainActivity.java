package com.novanto.rewangapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnMoveActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveActivity = findViewById(R.id.login);
        btnMoveActivity.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                Intent moveIntent = new Intent(MainActivity.this, Menu.class);
                startActivity(moveIntent);
                break;
        }
    }

}
