package com.novanto.fragmen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CallsFragment extends Fragment {
    View view2;
    RecyclerView RVCall;
    RVAdapter adapter;
    private ArrayList<CallModel> callModels;

    public CallsFragment(){

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view2 = inflater.inflate(R.layout.fragment_call,container,false);
        RVCall = view2.findViewById(R.id.RVCalls);
        RVCall.setLayoutManager(new LinearLayoutManager(getActivity()));

        callModels = new ArrayList<>();
        callModels.add(new CallModel(1,"Alpha","05:20"));
        callModels.add(new CallModel(2,"Beta","05:20"));
        callModels.add(new CallModel(3,"Charlie","05:20"));
        callModels.add(new CallModel(4,"Delta","05:20"));
        callModels.add(new CallModel(5,"Eko","05:20"));
        callModels.add(new CallModel(6,"Farenheit","05:20"));

        adapter = new RVAdapter(getActivity(), callModels);
        RVCall.setAdapter(adapter);

        return view2;
    }
}
