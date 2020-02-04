package com.novanto.mytestingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvText;
    private ArrayList<String> names;
    private ImageView imgPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvText = findViewById(R.id.tv_text);
        Button btn = findViewById(R.id.btn_set_value);
        imgPreview = findViewById(R.id.img_preview);
        //imgPreview.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.fronalpstock_big));
        Glide.with(this).load(R.drawable.fronalpstock_big).into(imgPreview);

        names = new ArrayList<>();
        names.add("edo");
        names.add("novanto");

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_set_value){
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0;i <= names.size()-1; i++){
                stringBuilder.append(names.get(i)).append("\n");
            }
            tvText.setText(stringBuilder);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
