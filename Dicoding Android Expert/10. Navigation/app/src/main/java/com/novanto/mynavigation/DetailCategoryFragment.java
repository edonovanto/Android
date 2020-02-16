package com.novanto.mynavigation;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailCategoryFragment extends Fragment {
    private String dataName;
    private Long dataDesc;
    private Button btnHome;


    public DetailCategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvCategoryName = view.findViewById(R.id.tv_category_name);
        TextView tvCategoryDesc = view.findViewById(R.id.tv_category_description);
        btnHome = view.findViewById(R.id.btn_profile);

        btnHome.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_detailCategoryFragment_to_homeFragment)
        );

        //Dengan Bundle
//        dataName = getArguments().getString(CategoryFragment.EXTRA_NAME);
//        dataDesc = getArguments().getLong(CategoryFragment.EXTRA_STOCK);

        //Dengan SafeArgs
        dataName = DetailCategoryFragmentArgs.fromBundle(getArguments()).getName();
        dataDesc = DetailCategoryFragmentArgs.fromBundle(getArguments()).getStock();

        tvCategoryName.setText(dataName);
        tvCategoryDesc.setText(String.valueOf(dataDesc));
    }
}
