package com.novanto.mymovieandtv;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TVFragment extends Fragment {

    private RecyclerView recyclerView;

    private ArrayList<Movie> list = new ArrayList<>();


    public TVFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_movie_film);
        recyclerView.setHasFixedSize(true);

        list.addAll(getList());
        showRecyclerGrid();
    }

    private ArrayList<Movie> getList(){
        String[] name = getResources().getStringArray(R.array.tv_title);
        String[] desc = getResources().getStringArray(R.array.tv_desc);
        String[] genre = getResources().getStringArray(R.array.tv_genres);
        String[] rating = getResources().getStringArray(R.array.tv_rating);
        String[] revenue = getResources().getStringArray(R.array.tv_revenue);
        String[] runTime = getResources().getStringArray(R.array.tv_runtime);
        String[] trailer = getResources().getStringArray(R.array.tv_trailer);
        TypedArray photo = getResources().obtainTypedArray(R.array.tv_photo);

        ArrayList<Movie> arrayList = new ArrayList<>();
        for (int i =0; i<name.length-1;i++){
            Movie movie = new Movie();
            movie.setName(name[i]);
            movie.setDesc(desc[i]);
            movie.setGenre(genre[i]);
            movie.setRating(rating[i]);
            movie.setRevenue(revenue[i]);
            movie.setRuntime(runTime[i]);
            movie.setTrailer(trailer[i]);
            movie.setPhoto(photo.getResourceId(i,-1));
            arrayList.add(movie);
        }
        return arrayList;
    }

    private void showRecyclerGrid(){
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 2));
        TVAdapter gridHeroAdapter = new TVAdapter(list);
        recyclerView.setAdapter(gridHeroAdapter);

        gridHeroAdapter.setOnItemClickCallback(new TVAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Movie movie) {
                Intent intent = new Intent(getContext(), DetailMovieActivity.class);
                intent.putExtra("item",movie);

                startActivity(intent);
            }
        });
    }
}
