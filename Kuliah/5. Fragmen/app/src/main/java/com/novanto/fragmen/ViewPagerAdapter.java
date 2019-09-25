package com.novanto.fragmen;

import android.icu.text.CaseMap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    //jumlah fragmen yang ada
    private final List<Fragment> fragmentList1 = new ArrayList<>();
    //nama di tab
    private final List<String> fragmentListTitle = new ArrayList<>();


    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    //
    public Fragment getItem(int position) {
        return fragmentList1.get(position);
    }

    @Override
    public int getCount() {
        return fragmentListTitle.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentListTitle.get(position);
    }

    public void addFragment(Fragment fragment1, String title1){
        fragmentList1.add(fragment1);
        fragmentListTitle.add(title1);
    }
}
