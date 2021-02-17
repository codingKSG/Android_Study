package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //전체 인플레이트



        // Select the ImageViews to display the images on
        iv1 = findViewById(R.id.iv_1);

//        // Display a jpg iamge from the project resource
//        Picasso.get().load(R.drawable.post4).into(iv1);

//        // Display a png image from the specified file
//        Picasso.get().load("/storage/emulated/0/Pictures/android_test.jpg").into(iv1);

//        // Display a jpg image from the given url
//        Picasso.get().load("https://picsum.photos/200/300").into(iv1);

    } // onCreate 종료시에 그림 그려짐.

}