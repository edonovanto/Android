package com.novanto.whatsappclone;

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

public class FragmentCalls extends Fragment {
    View view;
    RecyclerView RVCall;
    RVAdapterCall adapter;
    private ArrayList<CallModel> callModels;


    public FragmentCalls(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view =inflater.inflate(R.layout.fragment_calls,container,false);
        RVCall =view.findViewById(R.id.RVCalls);
        RVCall.setLayoutManager(new LinearLayoutManager(getActivity()));

        callModels = new ArrayList<>();
        callModels.add(new CallModel("Mama","17.35"));
        callModels.add(new CallModel("Papa","20.35"));
        callModels.add(new CallModel("Love","17.00"));
        callModels.add(new CallModel("Kakak","7.40"));
        callModels.add(new CallModel("Adek","10.00"));
        callModels.add(new CallModel("Gramedia","13.13"));
        callModels.add(new CallModel("Pak Rifqi","14.22"));
        callModels.add(new CallModel("Pak Irkham","17.00"));
        callModels.add(new CallModel("Gembel","00.00"));

        adapter = new RVAdapterCall(getActivity(), callModels);
        RVCall.setAdapter(adapter);

        return view;
    }
}
