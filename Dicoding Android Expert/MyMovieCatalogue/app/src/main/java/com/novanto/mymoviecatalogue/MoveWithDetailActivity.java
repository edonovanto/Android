package com.novanto.mymoviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MoveWithDetailActivity extends AppCompatActivity implements View.OnClickListener {
    private String title,desc,runtime,revenue,genre,rating;
    private int img;
    private TextView tv_title, tv_desc, tv_revenue, tv_genre, tv_runtime, tv_rating;
    private ImageView imgView;
    private Button btn_pesan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_detail);

        tv_title = findViewById(R.id.txt_name);
        tv_desc = findViewById(R.id.txt_description);
        tv_genre = findViewById(R.id.txt_genre);
        tv_revenue = findViewById(R.id.txt_revenue);
        tv_runtime = findViewById(R.id.txt_runtime);
        tv_rating = findViewById(R.id.txt_rating);
        imgView = findViewById(R.id.img_photo);
        this.btn_pesan = findViewById(R.id.btn_pesan);
        this.btn_pesan.setOnClickListener(this);

        getItem();

        setItem();

    }

    private void setItem() {
        tv_title.setText(title);
        tv_desc.setText(desc);
        tv_genre.setText(genre);
        tv_runtime.setText(runtime);
        tv_revenue.setText(revenue);
        tv_rating.setText(rating);
        imgView.setImageResource(img);
    }

    void getItem(){
//        Intent intent = getIntent();
        Movie movie = getIntent().getParcelableExtra("item");

        title = movie.getTitle();
        desc = movie.getDesc();
        runtime = movie.getRuntime();
        revenue = movie.getRevenue();
        genre = movie.getGenre();
        img = movie.getPhoto();
        rating = movie.getRating();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_pesan){
            Context context = getApplicationContext();
            CharSequence text = title + " berhasil dipesan!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}
