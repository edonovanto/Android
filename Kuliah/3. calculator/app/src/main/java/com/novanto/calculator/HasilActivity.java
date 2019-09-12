package com.novanto.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HasilActivity extends AppCompatActivity {
    TextView tvHasil;
    Button btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        tvHasil = findViewById(R.id.tvHasil);
        btnBack = findViewById(R.id.btnBack);

        String hasil;
        hasil = getIntent().getStringExtra("Hasil");
        tvHasil.setText(hasil);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(HasilActivity.this,MainActivity.class);
                pindah.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(pindah);
            }
        });
    }
}