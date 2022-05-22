package com.example.helloworld;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class ReadyActivity extends AppCompatActivity {

    TextView tx1, tx2, tx3, txtime, txcount;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ready);

        Intent intent = getIntent();

        tx1 = findViewById(R.id.tx1);
        tx2 = findViewById(R.id.tx2);
        tx3 = findViewById(R.id.tx3);
        txtime = findViewById(R.id.txtime);
        txcount = findViewById(R.id.txcount);
///////////////////////////////////////////////////////////////////////////////
        LocalTime now = LocalTime.now();

        int hour = now.getHour();

        if((hour>=5)&(hour<11)){
            txtime.setText("지금은 아침시간");
        }else if((hour>=11)&(hour<16)){
            txtime.setText("지금은 점심시간");
        }else if((hour>=16)&(hour<21)){
            txtime.setText("지금은 저녁시간");
        }else {
            txtime.setText("야식타임");
        }

////////////////////////////////////////////////////////////////////////////////////////
        int spicy = intent.getIntExtra("spicy",1);
        int food = intent.getIntExtra("food",1);
        int price = intent.getIntExtra("price",1);
////////////////////////////////////////////////////////////////////////
        if(spicy==1){
            tx1.setText("매운");
        }
        if(spicy==2){
            tx1.setText("안매운");
        }
        if(spicy==3){
            tx1.setText("맵기 상관없는");
        }
///////////////////////////////////////////////////////
        if(food==1){
            tx2.setText("한식");
        }
        if(food==2){
            tx2.setText("중식");
        }
        if(food==3){
            tx2.setText("일식");
        }
        if(food==4){
            tx2.setText("양식");
        }
        if(food==5){
            tx2.setText("기타음식");
        }
        if(food==6){
            tx2.setText("아무음식");
        }
/////////////////////////////////////////////////
        if(price==1){
            tx3.setText("0~1만원대");
        }
        if(price==2){
            tx3.setText("1~2만원대");
        }
        if(price==3){
            tx3.setText("2~3만원대");
        }
        if(price==4){
            tx3.setText("3만원 이상");
        }
        if(price==5){
            tx3.setText("가격대 상관없는");
        }


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                txcount.setText("2");

            }
        }, 1000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                txcount.setText("1");

            }
        }, 1800);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ReadyActivity.this, ResultActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2300);




    }
}