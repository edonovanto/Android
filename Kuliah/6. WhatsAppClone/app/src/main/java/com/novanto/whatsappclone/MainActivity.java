package com.novanto.whatsappclone;

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
        adapter.addFragment(new FragmentChat(), "Chat");
        adapter.addFragment(new FragmentStatus(), "Status");
        adapter.addFragment(new FragmentCalls(), "Calls");

        viewPager1.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager1);

    }
}
