package com.example.myapplication;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

// stack 생성
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private GridView gvMovie;
    private List<Movie> movies;
    private MovieAdapter adapter;

    // 1번째 실행
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //전체 인플레이트

        init();
        adapter = new MovieAdapter(movies);
        gvMovie.setAdapter(adapter);

    } // onCreate 종료시에 그림 그려짐.

    
    // 2번째 실행
    @Override
    protected void onStart() {
        super.onStart();
    }

    // 3번째 실행
    @Override
    protected void onResume() {
        super.onResume();
    } //액티비티에 그림 그려짐

    private void init() {
        gvMovie = findViewById(R.id.gv_movie);
        movies = new ArrayList<>();
        download();
    }

    private void download() {

        // 스레드로 돌아야함. 2초 걸림
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                movies.add(new Movie(1, "제목", R.drawable.mov01));
                movies.add(new Movie(2, "제목", R.drawable.mov02));
                movies.add(new Movie(3, "제목", R.drawable.mov03));
                movies.add(new Movie(4, "제목", R.drawable.mov04));
                movies.add(new Movie(5, "제목", R.drawable.mov05));
                movies.add(new Movie(6, "제목", R.drawable.mov06));
                movies.add(new Movie(7, "제목", R.drawable.mov07));
                movies.add(new Movie(8, "제목", R.drawable.mov08));
                movies.add(new Movie(9, "제목", R.drawable.mov09));
                movies.add(new Movie(10, "제목", R.drawable.mov10));
                movies.add(new Movie(11, "제목", R.drawable.mov11));
                movies.add(new Movie(12, "제목", R.drawable.mov12));

                // main 스레드 = ui스레드가 adapter.notifyDataSetChanged();를 실행시키게 하면됨/
                runOnUiThread(new Runnable() { // ui 스레드한테 이벤트 전달을 목적으로 가짐
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        }).start();
    }
}