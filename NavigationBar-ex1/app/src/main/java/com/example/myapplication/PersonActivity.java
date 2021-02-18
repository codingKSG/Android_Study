package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class PersonActivity extends AppCompatActivity {

    private static final String TAG = "PersonActivity2";
    private Toolbar toolbarPerson;
    private ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        toolbarPerson = findViewById(R.id.toolbar_person);
        setSupportActionBar(toolbarPerson);

        ivBack = findViewById(R.id.iv_back);
        ivBack.setOnClickListener(v -> {
            // Intent intent = new Intent(PersonActivity.this, MainActivity.class);
            // startActivity(intent);
            finish();
        });

    }
}