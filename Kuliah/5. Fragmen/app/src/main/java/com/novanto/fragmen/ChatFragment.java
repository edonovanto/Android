package com.novanto.fragmen;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ChatFragment extends Fragment implements View.OnClickListener {
    View view1;
    Button btnFragment;


    public ChatFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view1 = inflater.inflate(R.layout.fragment_chat, container,false);
        btnFragment = view1.findViewById(R.id.btnFragment);

        btnFragment.setOnClickListener(this);

        return view1;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnFragment:
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                startActivity(intent);
                break;
        }
    }
}
