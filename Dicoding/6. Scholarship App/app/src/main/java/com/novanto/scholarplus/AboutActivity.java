package com.novanto.scholarplus;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_me);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Another Activity");

    }

}
