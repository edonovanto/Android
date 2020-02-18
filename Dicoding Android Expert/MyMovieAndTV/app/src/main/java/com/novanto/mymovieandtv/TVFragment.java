package com.novanto.mymovieandtv;


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
        TypedArray photo = getResources().obtainTypedArray(R.array.tv_photo);

        ArrayList<Movie> arrayList = new ArrayList<>();
        for (int i =0; i<name.length;i++){
            Movie movie = new Movie();
            movie.setName(name[i]);
            movie.setPhoto(photo.getResourceId(i,-1));
            arrayList.add(movie);
        }
        return arrayList;
    }

    private void showRecyclerGrid(){
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 2));
        TVAdapter gridHeroAdapter = new TVAdapter(list);
        recyclerView.setAdapter(gridHeroAdapter);
    }
}
