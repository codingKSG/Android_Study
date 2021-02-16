package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private Button mbtnAdd, mbtnMinus;
    private TextView mtvNum;
    private Integer num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initSetting();
        initListener();

    } // onCreate 종료시에 그림 그려짐.

    private void init() {
        mbtnAdd = findViewById(R.id.btn_add);
        mbtnMinus = findViewById(R.id.btn_minus);
        mtvNum = findViewById(R.id.tv_num);
    }

    private void initSetting() {
        num = 1;
        mtvNum.setText(num.toString());

    }

    private void initListener(){
        mbtnAdd.setOnClickListener(v -> {
            Log.d(TAG,"initListenner mbtnAdd 클릭됨");
            num = num + 1;
            mtvNum.setText(num.toString());
        });

        mbtnMinus.setOnClickListener(v -> {
            Log.d(TAG, "initLisenner mbtnminus 클릭됨");
            num = num - 1;
            mtvNum.setText(num.toString());
        });

    }

}