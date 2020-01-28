package com.novanto.calculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static int REQUEST_CODE = 100;
    Button btn_hitung;
    EditText edt_1, edt_2;
    TextView tv_result;
    int number1, number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_hitung = findViewById(R.id.btn_hitung);
        edt_1 = findViewById(R.id.edt_number1);
        edt_2 = findViewById(R.id.edt_number2);
        tv_result = findViewById(R.id.tv_result);

        btn_hitung.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_hitung){
            number1 = Integer.parseInt(edt_1.getText().toString());
            number2 = Integer.parseInt(edt_2.getText().toString());

            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            intent.putExtra(SecondActivity.FIRST_NUMBER,number1);
            intent.putExtra(SecondActivity.SECOND_NUMBER,number2);
            startActivityForResult(intent,REQUEST_CODE);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE){
            if(resultCode == SecondActivity.RESULT_CODE){
                int result = data.getIntExtra(SecondActivity.EXTRA_SELECTED_VALUE,0);
                String result2 = String.valueOf(result);
                tv_result.setText(result2);
            }
            else if (resultCode == RESULT_CANCELED){
                tv_result.setText("No Calculation Selected");
            }
            else {
                tv_result.setText("Finish");
            }
        }
    }
}
