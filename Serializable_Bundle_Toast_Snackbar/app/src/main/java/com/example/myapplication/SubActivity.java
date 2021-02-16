package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SubActivity extends AppCompatActivity {

    private static final String TAG = "SubActivity2";
    private FloatingActionButton fabPop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();

        /*
        Bundle bundle = intent.getBundleExtra("myBundle");
        Log.d(TAG, "Bundle-id:" + bundle.getInt("id"));
        Log.d(TAG, "Bundle-username:" + bundle.getString("username"));
        Log.d(TAG, "Bundle-password:" + bundle.getString("password"));

        User user = (User) intent.getSerializableExtra("mySerializable");
        Log.d(TAG, "Serializable : " + user);

        String gsonData = intent.getStringExtra("myGson");
        Log.d(TAG, "myGson:"+ gsonData);
        */

        fabPop = findViewById(R.id.fab_pop);
        fabPop.setOnClickListener(v -> {
            // 인증이 성공함
            Intent newIntent = new Intent();
            newIntent.putExtra("auth", "ok");
            setResult(1, newIntent);
            finish(); // pop
        });
    }
}