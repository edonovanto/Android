package com.novanto.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvResult;
    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tv_result);

        Button btnMoveActivity = findViewById(R.id.btn_move_activity);
        Button btnMoveWithData = findViewById(R.id.move_with_data);
        Button btnMoveWithObj = findViewById(R.id.btn_move_act_obj);
        Button btnDialNumber = findViewById(R.id.btn_dial_number);
        Button btnResult = findViewById(R.id.btn_move_for_result);
        btnMoveWithData.setOnClickListener(this);
        btnMoveActivity.setOnClickListener(this);
        btnMoveWithObj.setOnClickListener(this);
        btnDialNumber.setOnClickListener(this);
        btnResult.setOnClickListener(this);
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
            case R.id.btn_dial_number:
                String phoneNumber = "082187877341";
                Intent dialPhone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhone);
                break;
            case R.id.btn_move_for_result:
                Intent moveForResult = new Intent(MainActivity.this,MoveForResultActivity.class);
                startActivityForResult(moveForResult,REQUEST_CODE);
                break;
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE){
            if(resultCode == MoveForResultActivity.RESULT_CODE){
                int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE,0);
                tvResult.setText(String.format("Hasil : %s", selectedValue));
            }
        }
    }
}
