package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
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
        setContentView(R.layout.activity_main);

        lvMovie = findViewById(R.id.lv_movie);
        
        // 어댑터 => 내장 어댑터
        // 어댑터 직접 만들어야 되는 경우 (커스텀 리스트 만들 때)
        List<String> mid = new ArrayList<>();
        mid.add("가쉽걸");
        mid.add("덱스터");
        mid.add("왕자의 게임");
        mid.add("브레이킹 배드");
        mid.add("배터콜 사울");

        // 어댑터는 화면 사이즈와 리스트 하나의 아이템 사이즈를 알아야하고 그 다음에 데이터 컬랙션을 알아야한다.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, mid);

        lvMovie.setAdapter(adapter);

        mid.add("어벤져스");
    } // onCreate 종료시에 그림 그려짐.

}