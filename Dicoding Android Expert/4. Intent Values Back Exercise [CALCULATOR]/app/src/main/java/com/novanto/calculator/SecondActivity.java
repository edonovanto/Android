package com.novanto.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    public static int RESULT_CODE = 110;
    public static final String EXTRA_SELECTED_VALUE = "extra_selected_value";
    public static String FIRST_NUMBER = "first_number";
    public static String SECOND_NUMBER = "second_number";
    TextView tv1,tv2;
    Button btn_add,btn_subtract;
    private int number1,number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn_add = findViewById(R.id.btn_add);
        btn_subtract = findViewById(R.id.btn_subtract);
        tv1 = findViewById(R.id.tv_angka1);
        tv2 = findViewById(R.id.tv_angka2);

        number1 = getIntent().getIntExtra(FIRST_NUMBER,0);
        number2 = getIntent().getIntExtra(SECOND_NUMBER,0);

        String n1 = String.valueOf(getIntent().getIntExtra(FIRST_NUMBER,0));
        String n2 = String.valueOf(getIntent().getIntExtra(SECOND_NUMBER,0));

        tv1.setText(n1);
        tv2.setText(n2);

        btn_add.setOnClickListener(this);
        btn_subtract.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_add:
                int result_add = number1 + number2;

                Intent intent = new Intent();
                intent.putExtra(EXTRA_SELECTED_VALUE, result_add);
                setResult(RESULT_CODE,intent);
                finish();
                break;
            case R.id.btn_subtract:
                int result_sub = number1 - number2;

                intent = new Intent();
                intent.putExtra(EXTRA_SELECTED_VALUE, result_sub);
                setResult(RESULT_CODE,intent);
                finish();
                break;
        }
    }
}
