package com.novanto.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTextViewResult;
    private EditText mTextViewNumber1;
    private EditText mTextViewNumber2;
    private Button btn_act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewNumber1 = findViewById(R.id.edit_text_number1);
        mTextViewNumber2 = findViewById(R.id.edit_text_number2);
        mTextViewResult = findViewById(R.id.tv_result);
        btn_act = findViewById(R.id.button);

        btn_act.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(mTextViewNumber1.getText().toString().equals("") || mTextViewNumber2.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "Please insert number", Toast.LENGTH_SHORT);
        }
        else {
            int number1 = Integer.parseInt(mTextViewNumber1.getText().toString());
            int number2 = Integer.parseInt(mTextViewNumber2.getText().toString());

            Intent intent = new Intent(MainActivity.this, activity2.class);
            intent.putExtra("number1", number1);
            intent.putExtra("number2", number2);
            startActivityForResult(intent,100);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100){
            if(resultCode == RESULT_OK){
                int result = data.getIntExtra("result",0);
                String result2 = String.valueOf(result);
                mTextViewResult.setText(result2);
            }
            else if(resultCode == RESULT_CANCELED){
                mTextViewResult.setText("Nothing Selected");
            }
        }
    }
}
