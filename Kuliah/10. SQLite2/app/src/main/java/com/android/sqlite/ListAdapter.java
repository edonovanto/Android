package com.android.sqlite;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListVH> {
    private ArrayList<Contact> list;

    public ListAdapter(ArrayList<Contact> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ListAdapter.ListVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item, viewGroup, false);
        return new ListVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListAdapter.ListVH listVH, int i) {
        final Contact contact = list.get(i);

        listVH.tvName.setText(contact.getName());
        listVH.tvPhone.setText(contact.getPhone());
        listVH.tvAddress.setText(contact.getAddress());

        listVH.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = listVH.itemView.getContext();
                FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
                BottomSheetSelection bottomSheetSelection = new BottomSheetSelection(contact);
                bottomSheetSelection.show(fragmentManager, "TAG");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ListVH extends RecyclerView.ViewHolder{
        private TextView tvName, tvPhone, tvAddress;

        public ListVH(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvPhone = itemView.findViewById(R.id.tv_phone);
            tvAddress = itemView.findViewById(R.id.tv_address);
        }
    }
}
