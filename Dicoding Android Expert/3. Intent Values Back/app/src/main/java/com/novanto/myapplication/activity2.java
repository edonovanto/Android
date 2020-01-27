package com.novanto.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class activity2 extends AppCompatActivity implements View.OnClickListener {

    private TextView number;
    private Button btn_add;
    private Button btn_substract;
    private int number1;
    private int number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        number = findViewById(R.id.tv_numbers);
        btn_add = findViewById(R.id.add);
        btn_substract = findViewById(R.id.subtract);

        number1 = getIntent().getIntExtra("number1",0);
        number2 = getIntent().getIntExtra("number2",0);

        number.setText("Number : " + number1 + ", " + number2);

        btn_add.setOnClickListener(this);
        btn_substract.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add:
                int result = number1 + number2;
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result",result);
                setResult(RESULT_OK, resultIntent);
                finish();
                break;
            case R.id.subtract:
                result = number1 - number2;
                resultIntent = new Intent();
                resultIntent.putExtra("result",result);
                setResult(RESULT_OK, resultIntent);
                finish();
                break;
        }
    }
}
