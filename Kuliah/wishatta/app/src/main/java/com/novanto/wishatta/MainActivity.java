package com.novanto.wishatta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CheckBox MyDesa,MyKota,MyPopular,MySolo,MyKelompok,MyBerpasangan,MyFasilitas,MyAkomodasi;
    private Button buttonApply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDesa = findViewById(R.id.desa);
        MyKota = findViewById(R.id.kota);
        MyPopular = findViewById(R.id.popular);
        MySolo = findViewById(R.id.solo);
        MyKelompok = findViewById(R.id.kelompok);
        MyBerpasangan = findViewById(R.id.berpasangan);
        MyFasilitas = findViewById(R.id.fasilitas);
        MyAkomodasi = findViewById(R.id.akomodasi);


        Button btnMoveWithDataActivity = findViewById(R.id.buttonApply);
        btnMoveWithDataActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (MyDesa.isChecked() && MyPopular.isChecked() && MyBerpasangan.isChecked()){
            if (MyKota.isChecked()){
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity3.class);
                startActivity(moveIntent);
            }
            else {
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity1.class);
                startActivity(moveIntent);
            }
        }
        else if (MyKota.isChecked() && MySolo.isChecked() && MyFasilitas.isChecked() ){
            if (MyDesa.isChecked() || MyPopular.isChecked() || MyKelompok.isChecked() || MyBerpasangan.isChecked() || MyAkomodasi.isChecked()){
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity3.class);
                startActivity(moveIntent);
            }
            else {
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity2.class);
                startActivity(moveIntent);
            }
        }
        else {
            Intent moveIntent = new Intent(MainActivity.this, MoveActivity3.class);
            startActivity(moveIntent);
        }
    }
}
