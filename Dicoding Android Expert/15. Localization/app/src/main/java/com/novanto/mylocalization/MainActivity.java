package com.novanto.mylocalization;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvHello, tvPlural, tvXliff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHello = findViewById(R.id.tv_hello);
        tvPlural = findViewById(R.id.tv_plural);
        tvXliff = findViewById(R.id.tv_xliff);

        int PokeCount = 3;
        String hello = String.format(getResources().getString(R.string.hello_world),"Edo Novanto", PokeCount, "Natasya");
        tvHello.setText(hello);

        int SongCount = 1;
        String pluralText = getResources().getQuantityString(R.plurals.numberOfSongsAvailable, SongCount, SongCount);
        tvPlural.setText(pluralText);

        tvXliff.setText(getResources().getString(R.string.app_homeurl));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.action_change_setting){
            Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
