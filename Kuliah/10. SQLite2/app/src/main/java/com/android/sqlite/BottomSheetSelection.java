package com.android.sqlite;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetSelection extends BottomSheetDialogFragment {
    private Contact contact;

    public BottomSheetSelection(Contact contact) {
        this.contact = contact;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.bottom_sheet_selection, container, false);
        Button btnUpdate = view.findViewById(R.id.btnUbah);
        Button btnDelete = view.findViewById(R.id.btnHapus);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                BottomSheetAdd bottomSheetAdd = new BottomSheetAdd(contact, 1);
                bottomSheetAdd.show(fragmentManager, "TAG");

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
                DBHelper dbHelper = new DBHelper(view.getContext());
                dbHelper.delete(contact.getId());
                Toast.makeText(getActivity(), "SUCCESS", Toast.LENGTH_SHORT).show();
//                MainActivity ma = new MainActivity();
//                ma.adapter.notifyDataSetChanged();
            }
        });

        return view;
    }
}