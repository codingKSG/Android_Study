package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private BottomNavigationView bottomNavigationView;
    private Fragment selectedFagment = new PersonFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //전체 인플레이트

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFagment).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.bottom_person:
                    selectedFagment = new PersonFragment();
                    break;
                case R.id.bottom_talk:
                    selectedFagment = new TalkFragment();
                    break;
                case R.id.bottom_tag:
                    selectedFagment = new TagFragment();
                    break;
                case R.id.bottom_menu:
                    selectedFagment = new MenuFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFagment).commit();

            return true;
        });

    } // onCreate 종료시에 그림 그려짐.

}