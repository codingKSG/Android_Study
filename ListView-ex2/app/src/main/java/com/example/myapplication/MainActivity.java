package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

// stack 생성
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private Context mContext = MainActivity.this;
    private ListView lvMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //전체 인플레이트

        lvMovie = findViewById(R.id.lv_movie);
        Log.d(TAG, "컨텍스트: " + MainActivity.this);
        Log.d(TAG, "컨텍스트: " + lvMovie.getContext());

        List<Movie> items = new ArrayList<>();

        for(int i = 0; i<20; i++) {
            Movie movie = new Movie(i, "제목"+i, "서브제목"+i);
            items.add(movie);
        }

        ItemAdapter adapter = new ItemAdapter(items);

        lvMovie.setAdapter(adapter);

    } // onCreate 종료시에 그림 그려짐.

}