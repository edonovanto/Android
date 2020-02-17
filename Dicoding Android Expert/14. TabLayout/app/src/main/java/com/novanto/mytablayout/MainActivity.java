package com.novanto.mytablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SectionPagerAdapter sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager(), this);
        ViewPager viewPager = findViewById(R.id.view_pager);

        viewPager.setAdapter(sectionPagerAdapter);

        TabLayout tableLayout = findViewById(R.id.tabs);
        tableLayout.setupWithViewPager(viewPager);

        getSupportActionBar().setElevation(0);

    }
}
