package com.novanto.mymovieandtv;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class DetailMovieActivity extends YouTubeBaseActivity implements View.OnClickListener {
    private String title,desc,runtime,revenue,genre,rating,trailer;
    private int img;
    private TextView tv_title, tv_desc, tv_revenue, tv_genre, tv_runtime, tv_rating;
    private ImageView imgView;
    private Button btn_pesan;
    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        tv_title = findViewById(R.id.txt_name);
        tv_desc = findViewById(R.id.txt_description);
        tv_genre = findViewById(R.id.txt_genre);
        tv_revenue = findViewById(R.id.txt_revenue);
        tv_runtime = findViewById(R.id.txt_runtime);
        tv_rating = findViewById(R.id.txt_rating);
        imgView = findViewById(R.id.img_photo);

        youTubePlayerView = findViewById(R.id.youtube_view);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.cueVideo(trailer);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
            }
        };

        youTubePlayerView.initialize("AIzaSyDnCu9YvIqYgL8F-yIF5W1UAUHgkq2L_tM",onInitializedListener);

        this.btn_pesan = findViewById(R.id.btn_pesan);
        btn_pesan.setOnClickListener(this);

        getItem();
        setItem();
    }

    void getItem(){
        Movie movie = getIntent().getParcelableExtra("item");

        title = movie.getName();
        desc = movie.getDesc();
        runtime = movie.getRuntime();
        revenue = movie.getRevenue();
        genre = movie.getGenre();
        img = movie.getPhoto();
        rating = movie.getRating();
        trailer = movie.getTrailer();
    }

    void setItem(){
        tv_title.setText(title);
        tv_desc.setText(desc);
        tv_genre.setText(genre);
        tv_runtime.setText(runtime);
        tv_revenue.setText(revenue);
        tv_rating.setText(rating);
        imgView.setImageResource(img);
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
