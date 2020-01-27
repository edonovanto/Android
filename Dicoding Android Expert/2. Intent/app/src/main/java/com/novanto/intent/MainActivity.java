package com.novanto.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMoveActivity = findViewById(R.id.btn_move_activity);
        Button btnMoveWithData = findViewById(R.id.move_with_data);
        Button btnMoveWithObj = findViewById(R.id.btn_move_act_obj);
        btnMoveWithData.setOnClickListener(this);
        btnMoveActivity.setOnClickListener(this);
        btnMoveWithObj.setOnClickListener(this);
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
            case R.id.btn_move_act_obj:
                ArrayList<Person> person = new ArrayList<>();
                person.add(new Person("Edo",20,"Jakarta"));
                person.add(new Person("Edo2",20,"Jakarta2"));

                Intent moveWithObject = new Intent(MainActivity.this,MoveWithObjectAct.class);
                moveWithObject.putParcelableArrayListExtra(MoveWithObjectAct.EXTRA_PERSON, person);
                startActivity(moveWithObject);
                break;
        }
    }
}
