package com.novanto.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMoveActivity = findViewById(R.id.btn_move_activity);
        Button btnMoveWithData = findViewById(R.id.move_with_data);
        btnMoveWithData.setOnClickListener(this);
        btnMoveActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.move_with_data:
                Intent moveWithData = new Intent(MainActivity.this, MoveWithDataActivity.class);
                moveWithData.putExtra(MoveWithDataActivity.NAME, "Edo");
                moveWithData.putExtra(MoveWithDataActivity.AGE, 17);
                startActivity(moveWithData);
                break;

        }
    }
}
