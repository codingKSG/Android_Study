package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager vpContainer;
    private TabLayout tabs;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TabLayout은 menu.xml이 없다.
        vpContainer = findViewById(R.id.vp_container);
        tabs = findViewById(R.id.tabs);

        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), 1);
        myFragmentPagerAdapter.addFragment(new Frag1());
        myFragmentPagerAdapter.addFragment(new Frag2());
        myFragmentPagerAdapter.addFragment(new Frag3());

        vpContainer.setAdapter(myFragmentPagerAdapter);

        // tab이랑 연결되어야 함.
        tabs.setupWithViewPager(vpContainer);

        // tab에 아이템 그리기
        tabs.getTabAt(0).setIcon(R.drawable.ic_person);
        tabs.getTabAt(1).setIcon(R.drawable.ic_menu);
        tabs.getTabAt(2).setIcon(R.drawable.ic_settings);
    }
}