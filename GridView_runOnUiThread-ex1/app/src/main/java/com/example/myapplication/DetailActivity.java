package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private TextView tvDetaileTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvDetaileTitle = findViewById(R.id.tv_detail_title);
        Intent mainIntent = getIntent();
        String title = mainIntent.getStringExtra("title");
        tvDetaileTitle.setText(title);
    }
}