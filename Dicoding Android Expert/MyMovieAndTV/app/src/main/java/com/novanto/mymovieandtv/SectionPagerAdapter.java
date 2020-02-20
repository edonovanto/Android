package com.novanto.mymovieandtv;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SectionPagerAdapter extends FragmentPagerAdapter {

    private Context context;

    SectionPagerAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.context = context;
    }

    private final int[] TAB_TITLES = new int[]{
            R.string.movie_tab_title,
            R.string.tv_tab_title
    };

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position){
            case 0:
                fragment = new MovieFragment();
                break;
            case 1:
                fragment= new TVFragment();
                break;
        }
        return fragment;
    }

    public CharSequence getPageTitle(int position){
        return context.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return TAB_TITLES.length;
    }
}
