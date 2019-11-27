package com.komsi.sqlite;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<ContactModel> contact;
    private Activity activity;


    public ListAdapter(Activity activity, List<ContactModel> contact) {
        this.activity = activity;
        this.contact = contact;
    }

    @Override
    public int getCount(int i) {
        return contact.size(i);
    }

    @Override
    public Object getItem(int i) {
        return contact.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (layoutInflater == null) {
            layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (view == null)
            view = layoutInflater.inflate(R.layout.list_row, null);
            TextView textid, textName, textNumber, textAddress;
            textid = view.findViewById(R.id.textId);
            textName = view.findViewById(R.id.textName);
            textNumber = view.findViewById(R.id.textNumber);
            textAddress = view.findViewById(R.id.textAddress);

            ContactModel data = contact.get(i);
            textid.setText(Integer.toString(data.getId()));
            textName.setText(data.getName());
            textNumber.setText(data.getPhone());
            textAddress.setText(data.getAddress());
            return view;
        }
    }
