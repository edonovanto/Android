package com.android.sqlite;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetAdd extends BottomSheetDialogFragment {
    private Contact contact;
    private int mode;

    public BottomSheetAdd(Contact contact, int mode) {
        this.contact = contact;
        this.mode = mode;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.bottom_sheet_add, container, false);

        final EditText etName = view.findViewById(R.id.etName);
        final EditText etPhone = view.findViewById(R.id.etPhone);
        final EditText etAddress = view.findViewById(R.id.etAddress);
        Button btnSave = view.findViewById(R.id.btnSave);
        Button btnCancel = view.findViewById(R.id.btnCancel);

        if (mode == 1) { //UPDATE
            etName.setText(contact.getName());
            etPhone.setText(contact.getPhone());
            etAddress.setText(contact.getAddress());
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etName.getText().toString();
                String phone = etPhone.getText().toString();
                String address = etAddress.getText().toString();

                DBHelper dbHelper = new DBHelper(view.getContext());
                if (mode == 0) {
                    dbHelper.insert(dbHelper.getWritableDatabase(), name, phone, address);
                } else {
                    dbHelper.update(contact.getId(), name, phone, address);
                }
                Toast.makeText(getActivity(), "Berhasil", Toast.LENGTH_SHORT).show();

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        return view;
    }
}