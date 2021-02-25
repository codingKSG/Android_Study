package com.cos.fireapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeActivity2";

    private Button btnLogout;
    private FirebaseAuth mAuth;
    private ImageView userImg;
    private TextView userName, userEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mAuth = FirebaseAuth.getInstance();

        btnLogout = findViewById(R.id.btn_logout);
        userImg = findViewById(R.id.user_img);
        userName = findViewById(R.id.user_name);
        userEmail = findViewById(R.id.user_email);

        btnLogout.setOnClickListener(v -> {
            mAuth.signOut();
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
        });

        FirebaseUser user = mAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();

            if (name.equals("")) {
                userName.setText("저장된 정보가 없습니다.");
            } else {
                userName.setText(name);
                Log.d(TAG, "onCreate: name: "+name);
            }

            if (email != null) {
                Log.d(TAG, "onCreate: email: "+email);
                userEmail.setText(email);
            } else {
                userEmail.setText("저장된 정보가 없습니다.");
            }

            if (photoUrl != null) {
                Glide.with(this).load(photoUrl).into(userImg);
            } else {
                userImg.setImageResource(R.drawable.ic_launcher_foreground);
            }

            // Check if user's email is verified
            boolean emailVerified = user.isEmailVerified();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            String uid = user.getUid();
        }


    }
}