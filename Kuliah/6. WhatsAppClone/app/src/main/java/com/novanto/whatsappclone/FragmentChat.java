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

public class FragmentChat extends Fragment implements View.OnClickListener {
    View view;
    RecyclerView RVChat;
    RVAdapter adapter;
    private ArrayList<ChatModel> chatModels;

    public FragmentChat(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view =inflater.inflate(R.layout.fragment_chat,container,false);
        RVChat =view.findViewById(R.id.RVChat);
        RVChat.setLayoutManager(new LinearLayoutManager(getActivity()));

        chatModels = new ArrayList<>();
        chatModels.add(new ChatModel("Mama","17.35","Kamu sudah makan?"));
        chatModels.add(new ChatModel("Papa","20.35","Mau ditransfer berapa?"));
        chatModels.add(new ChatModel("Love","17.00","Kita putus!"));
        chatModels.add(new ChatModel("Kakak","7.40","Lagi ngapain?"));
        chatModels.add(new ChatModel("Adek","10.00","Bagi duit dong"));
        chatModels.add(new ChatModel("Gramedia","13.13","Hallo Edo Novanto! Kami ada promo lho"));
        chatModels.add(new ChatModel("Pak Rifqi","14.22","Saya di lab techno mas"));
        chatModels.add(new ChatModel("Pak Irkham","17.00","Oke"));
        chatModels.add(new ChatModel("Gembel","00.00","Hallo"));

        adapter = new RVAdapter(getActivity(), chatModels);
        RVChat.setAdapter(adapter);

        return view;
    }

    @Override
    public void onClick(View view) {

    }
}
