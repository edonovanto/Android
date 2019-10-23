package com.novanto.scholarplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.Objects;

public class DetailBeasiswa extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_beasiswa);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Detail Beasiswa");

        ImageView imageView = findViewById(R.id.img_item_photo);
        TextView tvJudul = findViewById(R.id.tv_name);
        TextView tvDetail = findViewById(R.id.tv_detail);
        TextView tvSyarat = findViewById(R.id.tv_syarat);
        Button btnDaftar = findViewById(R.id.btnDaftar);


        String judul = getIntent().getStringExtra("Judul");
        String detail = getIntent().getStringExtra("Detail");
        String syarat = getIntent().getStringExtra("Syarat");

        Glide.with(this)
                .load(getIntent().getIntExtra("Photo",0))
                .apply(new RequestOptions().override(100,100))
                .into(imageView);


        tvJudul.setText(judul);
        tvDetail.setText(detail);
        tvSyarat.setText(syarat);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailBeasiswa.this, "Kamu telah terdaftar", Toast.LENGTH_SHORT).show();
            }
        });


        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    }






}
