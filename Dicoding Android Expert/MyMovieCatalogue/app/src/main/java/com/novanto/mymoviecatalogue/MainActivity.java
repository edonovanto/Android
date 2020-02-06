package com.novanto.mymoviecatalogue;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MovieAdapter movieAdapter;
    ListView listView;
    private String[] movieName;
    private String[] movieDesc;
    private String[] movieGenre;
    private String[] movieRating;
    private String[] movieRuntime;
    private String[] movieRevenue;
    private TypedArray movieImg;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lv_list);
        movieAdapter = new MovieAdapter(this);

        listView.setAdapter(movieAdapter);

        prepare();

        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, MoveWithDetailActivity.class);
                intent.putExtra("item",movies.get(i));

                startActivity(intent);
            }
        });
    }

    private void addItem() {
        movies = new ArrayList<>();

        for (int i=0; i< movieName.length-1; i++){
            Movie movie = new Movie();
            movie.setTitle(movieName[i]);
            movie.setDesc(movieDesc[i]);
            movie.setGenre(movieGenre[i]);
            movie.setRating(movieRating[i]);
            movie.setRevenue(movieRevenue[i]);
            movie.setRuntime(movieRuntime[i]);
            movie.setPhoto(movieImg.getResourceId(i,-1));
            movies.add(movie);
        }

        movieAdapter.setMovies(movies);
    }

    void prepare(){
        movieName = getResources().getStringArray(R.array.movie_title);
        movieDesc = getResources().getStringArray(R.array.movie_desc);
        movieImg = getResources().obtainTypedArray(R.array.movie_photo);
        movieGenre = getResources().getStringArray(R.array.movie_genres);
        movieRevenue = getResources().getStringArray(R.array.movie_revenue);
        movieRuntime = getResources().getStringArray(R.array.movie_runtime);
        movieRating = getResources().getStringArray(R.array.movie_rating);
    }
}
