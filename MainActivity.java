package com.example.foodrocommender;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();//액션바 생성
        actionBar.hide();// 액션바 숨기기

        Handler handler = new Handler();

        ImageView whatfood = (ImageView)findViewById(R.id.whatfood);
        Glide.with(this).load(R.raw.whatfood).into(whatfood);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, StartActivity.class);
                startActivity(intent); // startActivity로 화면전환
                finish();
            }
        }, 5600);

    }
}
