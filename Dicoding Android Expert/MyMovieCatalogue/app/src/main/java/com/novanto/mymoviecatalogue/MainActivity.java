package com.novanto.mymoviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MovieAdapter movieAdapter;
    ListView listView;
    private String[] movieName;
    private String[] movieDesc;
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
    }

    private void addItem() {
        movies = new ArrayList<>();

        for (int i=0; i< movieName.length ; i++){
            Movie movie = new Movie();
            movie.setTitle(movieName[i]);
            movie.setDesc(movieDesc[i]);
            movie.setPhoto(movieImg.getResourceId(i,-1));
            movies.add(movie);
        }

        movieAdapter.setMovies(movies);
    }

    void prepare(){
        movieName = getResources().getStringArray(R.array.movie_title);
        movieDesc = getResources().getStringArray(R.array.movie_desc);
        movieImg = getResources().obtainTypedArray(R.array.movie_photo);
    }
}
