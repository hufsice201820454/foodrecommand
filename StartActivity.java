package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class StartActivity extends AppCompatActivity {

    private int spicy,food,price;

    private Button btn_starttt;

    private ToggleButton tb_spicy;
    private ToggleButton tb_anispicy;
    private ToggleButton tb_nospicy;

    private ToggleButton tb_koreanfood;
    private ToggleButton tb_chinessfood;
    private ToggleButton tb_japanessfood;
    private ToggleButton tb_westernfood;
    private ToggleButton tb_etcfood;
    private ToggleButton tb_anifood;

    private ToggleButton tb_01;
    private ToggleButton tb_12;
    private ToggleButton tb_23;
    private ToggleButton tb_34;
    private ToggleButton tb_123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        btn_starttt = findViewById(R.id.btn_starttt);

        tb_spicy = findViewById(R.id.tb_spicy);
        tb_anispicy = findViewById(R.id.tb_anispicy);
        tb_nospicy = findViewById(R.id.tb_nospicy);

        tb_koreanfood = findViewById(R.id.tb_koreanfood);
        tb_chinessfood = findViewById(R.id.tb_chinessfood);
        tb_japanessfood = findViewById(R.id.tb_japanessfood);
        tb_westernfood = findViewById(R.id.tb_westernfood);
        tb_etcfood = findViewById(R.id.tb_etcfood);
        tb_anifood = findViewById(R.id.tb_anifood);

        tb_01 = findViewById(R.id.tb_01);
        tb_12 = findViewById(R.id.tb_12);
        tb_23 = findViewById(R.id.tb_23);
        tb_34 = findViewById(R.id.tb_34);
        tb_123 = findViewById(R.id.tb_123);

        btn_starttt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((tb_koreanfood.isChecked()==false)&(tb_chinessfood.isChecked()==false)&(tb_japanessfood.isChecked()==false)&(tb_westernfood.isChecked()==false)&(tb_etcfood.isChecked()==false)&(tb_anifood.isChecked()==false)){
                    Toast.makeText(getApplicationContext(), "음식종류를 선택해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if((tb_spicy.isChecked()==false)&(tb_anispicy.isChecked()==false)&(tb_nospicy.isChecked()==false)){
                    Toast.makeText(getApplicationContext(), "맵기를 선택해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if((tb_01.isChecked()==false)&(tb_12.isChecked()==false)&(tb_23.isChecked()==false)&(tb_34.isChecked()==false)&(tb_123.isChecked()==false)){
                    Toast.makeText(getApplicationContext(), "가격대를 선택해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(StartActivity.this, ReadyActivity.class);
                intent.putExtra("spicy",spicy);//1매움,2맵지않음,3상관없음
                intent.putExtra("food",food);//1한식,2중식,3일식,4양식,5기타,6아무거나
                intent.putExtra("price",price);//1만원,2이만원,3삼만원,4삼만원이상,5상관없음
                startActivity(intent);
            }
        });

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        tb_spicy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    spicy=1;
                    tb_anispicy.setChecked(false);
                    tb_nospicy.setChecked(false);
                }
            }
        });
        tb_anispicy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    spicy=3;
                    tb_spicy.setChecked(false);
                    tb_nospicy.setChecked(false);
                }
            }
        });
        tb_nospicy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    spicy=2;
                    tb_anispicy.setChecked(false);
                    tb_spicy.setChecked(false);
                }
            }
        });
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        tb_koreanfood.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    food=1;
                    tb_chinessfood.setChecked(false);
                    tb_japanessfood.setChecked(false);
                    tb_westernfood.setChecked(false);
                    tb_etcfood.setChecked(false);
                    tb_anifood.setChecked(false);
                }
            }
        });
        tb_chinessfood.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    food=2;
                    tb_koreanfood.setChecked(false);
                    tb_japanessfood.setChecked(false);
                    tb_westernfood.setChecked(false);
                    tb_etcfood.setChecked(false);
                    tb_anifood.setChecked(false);
                }
            }
        });
        tb_japanessfood.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    food=3;
                    tb_koreanfood.setChecked(false);
                    tb_chinessfood.setChecked(false);
                    tb_westernfood.setChecked(false);
                    tb_etcfood.setChecked(false);
                    tb_anifood.setChecked(false);
                }
            }
        });
        tb_westernfood.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    food=4;
                    tb_koreanfood.setChecked(false);
                    tb_chinessfood.setChecked(false);
                    tb_japanessfood.setChecked(false);
                    tb_etcfood.setChecked(false);
                    tb_anifood.setChecked(false);
                }
            }
        });
        tb_etcfood.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    food=5;
                    tb_koreanfood.setChecked(false);
                    tb_chinessfood.setChecked(false);
                    tb_japanessfood.setChecked(false);
                    tb_westernfood.setChecked(false);
                    tb_anifood.setChecked(false);
                }
            }
        });
        tb_anifood.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    food=6;
                    tb_koreanfood.setChecked(false);
                    tb_chinessfood.setChecked(false);
                    tb_japanessfood.setChecked(false);
                    tb_westernfood.setChecked(false);
                    tb_etcfood.setChecked(false);
                }
            }
        });
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        tb_01.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    price =1;
                    tb_12.setChecked(false);
                    tb_23.setChecked(false);
                    tb_34.setChecked(false);
                    tb_123.setChecked(false);
                }
            }
        });
        tb_12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    price =2;
                    tb_01.setChecked(false);
                    tb_23.setChecked(false);
                    tb_34.setChecked(false);
                    tb_123.setChecked(false);
                }
            }
        });
        tb_23.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    price =3;
                    tb_01.setChecked(false);
                    tb_12.setChecked(false);
                    tb_34.setChecked(false);
                    tb_123.setChecked(false);
                }
            }
        });
        tb_34.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    price =4;
                    tb_01.setChecked(false);
                    tb_12.setChecked(false);
                    tb_23.setChecked(false);
                    tb_123.setChecked(false);
                }
            }
        });
        tb_123.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    price =5;
                    tb_01.setChecked(false);
                    tb_12.setChecked(false);
                    tb_23.setChecked(false);
                    tb_34.setChecked(false);
                }
            }
        });





    }
}