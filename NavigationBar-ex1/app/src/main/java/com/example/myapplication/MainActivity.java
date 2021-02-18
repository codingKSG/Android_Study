package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private Toolbar toolbarMain;
    private ImageView ivPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //전체 인플레이트

        toolbarMain = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbarMain);

        ivPerson = findViewById(R.id.iv_person);
        ivPerson.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PersonActivity.class);
            startActivity(intent);
        });


    } // onCreate 종료시에 그림 그려짐.

}