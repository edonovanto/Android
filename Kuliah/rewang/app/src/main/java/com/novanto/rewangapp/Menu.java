package com.novanto.rewangapp;

import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, (android.view.Menu) menu);
        return super.onCreateOptionsMenu((android.view.Menu) menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }
    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.profile:
                break;
            case R.id.activity:
                break;
            case R.id.signOut:
                break;
        }
    }
}
