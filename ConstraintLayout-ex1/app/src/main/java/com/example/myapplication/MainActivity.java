package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

// 메인 스레드 실행 => onCreate() => UI 스레드 실행 (무한 루프 - 이벤트 리스너 체크)
// => 메인 스레드 종료, 이벤트 스레드 실행 [배열] 확인
// => 이벤트 리스너 ( OS가 관리 ) []
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";

    private TextView tvTitle;

    // 매니페스트에서 설정된 자바 파일이 실행될 때 가장 먼저 실행되는 함수 onCreate()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main); // 그림 그리는 함수 (무엇을 ? activity_main.xml)

    } // onCreate 종료시에 그림 그려짐.

}