package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // xml에 있는 그림이 메모리에 올라오는 과정 = 인플레이트

        // pgb_loding 은 실행시에 메모리에 뜸.
        // 실행 전 컴파일시에 툴이 저 친구를 R에 등록을 해줌
        mProgressBar = findViewById(R.id.pgb_loding);

        download(); // 3ch = UI스레드

    } // onCreate 종료시에 그림 그려짐.

    private void download(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    // 다운로드 됨
                    mProgressBar.setVisibility(View.INVISIBLE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}