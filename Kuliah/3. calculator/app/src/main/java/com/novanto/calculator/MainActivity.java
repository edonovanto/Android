package com.novanto.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText bil1,bil2;
    Button btnTambah, btnKurang, btnKali, btnBagi, btnHapus;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bil1 = findViewById(R.id.bil1);
        bil2 = findViewById(R.id.bil2);

        btnTambah = findViewById(R.id.btnTambah);
        btnKurang = findViewById(R.id.btnKurang);
        btnKali = findViewById(R.id.btnKali);
        btnBagi = findViewById(R.id.btnBagi);
        btnHapus = findViewById(R.id.btnHapus);

        tvHasil = findViewById(R.id.tvHasil);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bil1.getText().toString().isEmpty()){
                    bil1.setError("Kolom Harus Diisi");
                }
                else if (bil2.getText().toString().isEmpty()){
                    bil2.setError("Kolom Harus Diisi");
                }
                else {
                    Integer hasil = Integer.parseInt(bil1.getText().toString()) + Integer.parseInt(bil2.getText().toString());
                    tvHasil.setText(String.valueOf(hasil));
                    Intent pindah = new Intent(MainActivity.this, HasilActivity.class);
                    pindah.putExtra("Hasil",String.valueOf(hasil));
                    startActivity(pindah);
                }
            }
        });

        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer hasil = Integer.parseInt(bil1.getText().toString()) - Integer.parseInt(bil2.getText().toString());
                tvHasil.setText(String.valueOf(hasil));
            }
        });

        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer hasil = Integer.parseInt(bil1.getText().toString()) * Integer.parseInt(bil2.getText().toString());
                tvHasil.setText(String.valueOf(hasil));
            }
        });

        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer hasil = Integer.parseInt(bil1.getText().toString()) / Integer.parseInt(bil2.getText().toString());
                tvHasil.setText(String.valueOf(hasil));
            }
        });


        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvHasil.setText(" ");
            }
        });
        //bisa menghapus element menggunakan visibility gone dari file.java


    }
}