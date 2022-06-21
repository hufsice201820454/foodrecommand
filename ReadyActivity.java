package com.example.foodrocommender;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.time.LocalTime;

public class ReadyActivity extends AppCompatActivity {

    TextView txtime;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ready);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Intent intent = getIntent();//스타트 액티비티에서 넘겨준 정보를 받아오는 인텐트

        int toospicy = intent.getIntExtra("toospicy",0);
        int littlespicy = intent.getIntExtra("littlespicy",0);
        int nospicy = intent.getIntExtra("nospicy",0);
        int k = intent.getIntExtra("k",0);
        int y = intent.getIntExtra("y",0);
        int ch = intent.getIntExtra("c",0);
        int j = intent.getIntExtra("j",0);
        int e = intent.getIntExtra("e",0);
        int price = intent.getIntExtra("price",0);

        ImageView eating = (ImageView)findViewById(R.id.eatinggif);

        txtime = findViewById(R.id.txtime);
///////////////////////////////////////////////////////////////////////////////
        LocalTime now = LocalTime.now();

        int hour = now.getHour();

        if((hour>=5)&(hour<11)){
            Glide.with(this).load(R.raw.eatingmorning).into(eating);
            txtime.setText("아침");
        }else if((hour>=11)&(hour<16)){
            Glide.with(this).load(R.raw.eatinglunch).into(eating);
            txtime.setText("점심");
        }else if((hour>=16)&(hour<21)){
            Glide.with(this).load(R.raw.eatingdinner).into(eating);
            txtime.setText("저녁");
        }else {
            Glide.with(this).load(R.raw.eatingnight).into(eating);
            txtime.setText("야식");
        }// 시간을받아와서 지금시간이 아침,점심,저녁 중 어느때인지 알려줌 - 5~11(아침),11~16(점심),16~21(저녁),나머지 야식

////////////////////////////////////////////////////////////////////////////////////////

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ReadyActivity.this, ResultActivity.class);//리설트 액티비티로 정보를 넘겨주고 불러옴.
                intent.putExtra("toospicy",toospicy);//매움
                intent.putExtra("littlespicy",littlespicy);//약간매움
                intent.putExtra("nospicy",nospicy);//안매움
                intent.putExtra("k",k);//한식유무
                intent.putExtra("y",y);//양식유무
                intent.putExtra("c",ch);//중식유무
                intent.putExtra("j",j);//일식유무
                intent.putExtra("e",e);//기타유무
                intent.putExtra("price",price);//1:만원이하,2:이만원이하,3:3만원이하,99:상관없음
                startActivity(intent);
                finish();//대기 화면 이므로 액티비티가 넘어갈때 이 액티비티를 종료하여 뒤로가기를 눌렀을때 스타트 액티비티로 넘어가게 함.
            }
        }, 2250);//2.25초 후 런함수 실행
    }
}

