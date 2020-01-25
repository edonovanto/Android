package com.novanto.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveWithDataActivity extends AppCompatActivity {
    public static final String AGE = "extra_age";
    public static final String NAME = "extra_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_data);

        TextView tvDataRecieved = findViewById(R.id.tv_data_recieved);

        String name = getIntent().getStringExtra(NAME);
        int age = getIntent().getIntExtra(AGE,0);

        String text = "Name : " + name + " Age : " + age;
        tvDataRecieved.setText(text);
    }
}
