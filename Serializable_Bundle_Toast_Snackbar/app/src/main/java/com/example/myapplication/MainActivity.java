package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

// stack 생성
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private Context mContext = MainActivity.this;
    private FloatingActionButton fabRoute;
    private ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.main_layout);

        fabRoute = findViewById(R.id.fab_route);
        fabRoute.setOnClickListener(v -> {
            // 1. 현재 내 화면, 이동할 화면
            // 2. 현재 내 화면, 내부앱의 이동할 화면
            //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01022227777"));
            // intent = 트럭(현재 매위치, 이동할 위치정보, 이동할 때 가져갈 박스)
            // 다른 앱으로 이동 = 트럭(상대방 앱의 키, 데이터)
            User user = new User();
            user.setId(1);
            user.setUsername("namja");
            user.setPassword("1234");


            // Bundle (택배 박스)

            /*
            Bundle bundle = new Bundle();
            bundle.putInt("id", user.getId());
            bundle.putString("username", user.getUsername());
            bundle.putString("password", user.getPassword());
             */

            // serializable
            /*
            클래스에 임플리먼트 시리얼라이즈 한뒤
            setting으로 값을 넣고 클래스를 넘기면 됨
             */


            // gson 으로 json변환 put Extra로 넘기고 gson으로 자바 오브젝트
            /*
            Gson gson = new Gson();
            String gsonData = gson.toJson(user);
             */



            Intent intent = new Intent(mContext, SubActivity.class);
            /*
            intent.putExtra("myUser", user);
            startActivity(intent);
             */

            startActivityForResult(intent, 300);
        });

    } // onCreate 종료시에 그림 그려짐.

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        
        Log.d(TAG, "onActivityResult: 실행됨");
        Log.d(TAG, "requestCode: "+ requestCode);
        Log.d(TAG, "resultCode: "+ resultCode);

        // Window 가 무엇인지? AlertDialog 사용!!
        
        if(requestCode == 300) { // SubActivity에서 돌아왔다
            if(resultCode == 1) { // 로직 성공
                //Toast.makeText(mContext, "인증 성공함 : " + data.getStringExtra("auth"), Toast.LENGTH_SHORT).show();
                Snackbar.make(mainLayout, "인증성공함", BaseTransientBottomBar.LENGTH_LONG).show();
            } else { // 로직 실패
                Toast.makeText(mContext, "인증 실패", Toast.LENGTH_SHORT).show();
                
            }
        }
    }
}