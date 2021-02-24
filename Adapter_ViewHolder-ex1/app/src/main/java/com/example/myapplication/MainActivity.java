package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private RecyclerView rvContainer;
    private MovieAdapter movieAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //전체 인플레이트

        init();
        List<Integer> movies = download();

        movieAdapter = new MovieAdapter(movies);
        rvContainer.setAdapter(movieAdapter);

    } // onCreate 종료시에 그림 그려짐.

    private void init() {
        rvContainer = findViewById(R.id.rv_container);
        GridLayoutManager gridLayoutManager =  new GridLayoutManager(MainActivity.this, 3);
        rvContainer.setLayoutManager(gridLayoutManager);
    }

    private List<Integer> download() {
        List<Integer> movies = new ArrayList<>();
        movies.add(R.drawable.mov01);
        movies.add(R.drawable.mov02);
        movies.add(R.drawable.mov03);
        movies.add(R.drawable.mov04);
        movies.add(R.drawable.mov05);
        movies.add(R.drawable.mov06);
        movies.add(R.drawable.mov07);
        movies.add(R.drawable.mov08);
        movies.add(R.drawable.mov09);
        movies.add(R.drawable.mov10);
        movies.add(R.drawable.mov11);
        movies.add(R.drawable.mov12);

        return movies;
    }
}