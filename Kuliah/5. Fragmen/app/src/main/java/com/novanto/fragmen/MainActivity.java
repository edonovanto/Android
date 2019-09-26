package com.novanto.fragmen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        final ViewPager viewPager1 = (ViewPager) findViewById(R.id.pager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ChatFragment(), "Chat");
        adapter.addFragment(new StatusFragment(), "Status");
        adapter.addFragment(new CallsFragment(), "Calls");
        viewPager1.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager1);

    }
}
