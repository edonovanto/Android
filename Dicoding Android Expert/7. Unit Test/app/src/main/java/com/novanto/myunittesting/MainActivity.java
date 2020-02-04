package com.novanto.myunittesting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MainViewModel mainViewModel;
    private EditText edt_length, edt_width, edt_heigth;
    private Button btn_save, btnCalculateVolume, btnCalculateSurfaceArea, btnCalculateCircumference;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = new MainViewModel(new CubiodModel());

        edt_length = findViewById(R.id.edt_length);
        edt_width = findViewById(R.id.edt_width);
        edt_heigth = findViewById(R.id.edt_height);
        this.btn_save = findViewById(R.id.btn_save);
        btnCalculateVolume = findViewById(R.id.btn_calculate_volume);
        btnCalculateCircumference = findViewById(R.id.btn_calculate_circumference);
        btnCalculateSurfaceArea = findViewById(R.id.btn_calculate_surface_area);
        this.tv_result = findViewById(R.id.tv_result);

        this.btn_save.setOnClickListener(this);
        btnCalculateSurfaceArea.setOnClickListener(this);
        btnCalculateCircumference.setOnClickListener(this);
        btnCalculateVolume.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        String length = edt_length.getText().toString().trim();
        String width = edt_width.getText().toString().trim();
        String height = edt_heigth.getText().toString().trim();

        if (TextUtils.isEmpty(length)) {
            edt_length.setError("Field ini tidak boleh kosong");
        } else if (TextUtils.isEmpty(width)) {
            edt_width.setError("Field ini tidak boleh kosong");
        } else if (TextUtils.isEmpty(height)) {
            edt_heigth.setError("Field ini tidak boleh kosong");
        } else {
            double l = Double.parseDouble(length);
            double w = Double.parseDouble(width);
            double h = Double.parseDouble(height);

            if (view.getId() == R.id.btn_save){
                mainViewModel.save(w,h,l);
                visible();
                btn_save.setText("Tersimpan");
            } else if (view.getId() == R.id.btn_calculate_circumference){
                tv_result.setText(String.valueOf(mainViewModel.getCircumference()));
                gone();
            } else if (view.getId() == R.id.btn_calculate_surface_area){
                tv_result.setText(String.valueOf(mainViewModel.getSurface()));
                gone();
            } else if (view.getId() == R.id.btn_calculate_volume){
                tv_result.setText(String.valueOf(mainViewModel.getVolume()));
                gone();
            }
        }
    }

    public void visible() {
        btnCalculateCircumference.setVisibility(View.VISIBLE);
        btnCalculateSurfaceArea.setVisibility(View.VISIBLE);
        btnCalculateVolume.setVisibility(View.VISIBLE);
        btn_save.setVisibility(View.GONE);
    }

    public void gone() {
        btnCalculateVolume.setVisibility(View.GONE);
        btnCalculateCircumference.setVisibility(View.GONE);
        btnCalculateSurfaceArea.setVisibility(View.GONE);
        btn_save.setVisibility(View.VISIBLE);
    }
}
