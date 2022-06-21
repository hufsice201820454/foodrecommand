package com.example.foodrocommender;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class StartActivity extends AppCompatActivity {

    private int toospicy=0, littlespicy=0, nospicy=0,price;
    private int k=0, y=0, c=0, j=0, e=0;

    private Button btn_starttt;// ToggleButton으로 맵기, 음식종류, 가격 선택

    private ToggleButton tb_toospicy;
    private ToggleButton tb_littlepicy;
    private ToggleButton tb_nospicy;
    private ToggleButton tb_everyspicy;

    private ToggleButton tb_koreanfood;
    private ToggleButton tb_chinessfood;
    private ToggleButton tb_japanessfood;
    private ToggleButton tb_westernfood;
    private ToggleButton tb_etcfood;
    private ToggleButton tb_everyfood;

    private ToggleButton tb_01;
    private ToggleButton tb_12;
    private ToggleButton tb_23;
    private ToggleButton tb_123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        btn_starttt = findViewById(R.id.btn_starttt);

        tb_toospicy = findViewById(R.id.tb_toospicy);
        tb_littlepicy = findViewById(R.id.tb_littlespicy);
        tb_nospicy = findViewById(R.id.tb_nospicy);
        tb_everyspicy = findViewById(R.id.tb_everyspicy);

        tb_koreanfood = findViewById(R.id.tb_koreanfood);
        tb_chinessfood = findViewById(R.id.tb_chinessfood);
        tb_japanessfood = findViewById(R.id.tb_japanessfood);
        tb_westernfood = findViewById(R.id.tb_westernfood);
        tb_etcfood = findViewById(R.id.tb_etcfood);
        tb_everyfood = findViewById(R.id.tb_everyfood);

        tb_01 = findViewById(R.id.tb_01);
        tb_12 = findViewById(R.id.tb_12);
        tb_23 = findViewById(R.id.tb_23);
        tb_123 = findViewById(R.id.tb_123);

        btn_starttt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((tb_koreanfood.isChecked()==false)&(tb_chinessfood.isChecked()==false)&(tb_japanessfood.isChecked()==false)&(tb_westernfood.isChecked()==false)&(tb_etcfood.isChecked()==false)){
                    Toast.makeText(getApplicationContext(), "음식종류를 선택해주세요.", Toast.LENGTH_SHORT).show();
                    return;//음식종류 선택안하면 토스트 메세지 출력후 다시 선택하게함
                }
                if((tb_toospicy.isChecked()==false)&(tb_littlepicy.isChecked()==false)&(tb_nospicy.isChecked()==false)){
                    Toast.makeText(getApplicationContext(), "맵기를 선택해주세요.", Toast.LENGTH_SHORT).show();
                    return;// 맵기 선택안하면 선택하라는 토스트 메세지 출력후 다시 선택하게함
                }
                if((tb_01.isChecked()==false)&(tb_12.isChecked()==false)&(tb_23.isChecked()==false)&(tb_123.isChecked()==false)){
                    Toast.makeText(getApplicationContext(), "가격대를 선택해주세요.", Toast.LENGTH_SHORT).show();
                    return;//가격 선택안하면 토스트 메세지 출력후 다시 선택하게함
                }

                Intent intent = new Intent(StartActivity.this, ReadyActivity.class);
                intent.putExtra("toospicy",toospicy);//매움
                intent.putExtra("littlespicy",littlespicy);//약간매움
                intent.putExtra("nospicy",nospicy);//안매움
                intent.putExtra("k",k);//한식유무
                intent.putExtra("y",y);//양식유무
                intent.putExtra("c",c);//중식유무
                intent.putExtra("j",j);//일식유무
                intent.putExtra("e",e);//기타유무
                intent.putExtra("price",price);//1만원,2이만원,3삼만원,4삼만원이상,5상관없음
                startActivity(intent);//Intent로 맵기, 음식종류, 가격을 넘겨준다
            }
        });

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        tb_toospicy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    toospicy=1;
                }else{
                    toospicy=0;
                    tb_everyspicy.setChecked(false);
                }
            }
        });// 엄청매움
        tb_littlepicy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    littlespicy=1;
                }else{
                    littlespicy=0;
                    tb_everyspicy.setChecked(false);
                }
            }
        });// 살짝매움
        tb_nospicy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    nospicy=1;
                }else{
                    nospicy=0;
                    tb_everyspicy.setChecked(false);
                }
            }
        });//안매움
        tb_everyspicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tb_everyspicy.isChecked()==true){
                    tb_toospicy.setChecked(true);
                    tb_nospicy.setChecked(true);
                    tb_littlepicy.setChecked(true);
                    nospicy=1;
                    littlespicy=1;
                    toospicy=1;
                }else{
                    tb_toospicy.setChecked(false);
                    tb_nospicy.setChecked(false);
                    tb_littlepicy.setChecked(false);
                    nospicy=0;
                    littlespicy=0;
                    toospicy=0;
                }
            }
        });//모든맵기선택가능
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        tb_koreanfood.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    k=1;

                }else{
                    k=0;
                    tb_everyfood.setChecked(false);
                }
            }
        });//한식
        tb_chinessfood.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    c=1;
                }else{
                    c=0;
                    tb_everyfood.setChecked(false);
                }
            }
        });//중식
        tb_japanessfood.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    j=1;
                }else{
                    j=0;
                    tb_everyfood.setChecked(false);
                }
            }
        });//일식
        tb_westernfood.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    y=1;
                }else{
                    y=0;
                    tb_everyfood.setChecked(false);
                }
            }
        });//양식
        tb_etcfood.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    e=1;
                }else{
                    e=0;
                    tb_everyfood.setChecked(false);
                }
            }
        });//기타
        tb_everyfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tb_everyfood.isChecked()==true){
                    tb_koreanfood.setChecked(true);
                    tb_chinessfood.setChecked(true);
                    tb_japanessfood.setChecked(true);
                    tb_westernfood.setChecked(true);
                    tb_etcfood.setChecked(true);
                    k=1;
                    c=1;
                    j=1;
                    y=1;
                    e=1;
                }else{
                    tb_koreanfood.setChecked(false);
                    tb_chinessfood.setChecked(false);
                    tb_japanessfood.setChecked(false);
                    tb_westernfood.setChecked(false);
                    tb_etcfood.setChecked(false);
                    k=0;
                    c=0;
                    j=0;
                    y=0;
                    e=0;
                }
            }
        });//모든 음식종류 선택가능
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        tb_01.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    price =1;
                    tb_12.setChecked(false);
                    tb_23.setChecked(false);
                    tb_123.setChecked(false);
                }
            }
        });// 1만원이하
        tb_12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    price =2;
                    tb_01.setChecked(false);
                    tb_23.setChecked(false);
                    tb_123.setChecked(false);
                }
            }
        });// 2만원이하
        tb_23.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    price =3;
                    tb_01.setChecked(false);
                    tb_12.setChecked(false);
                    tb_123.setChecked(false);
                }
            }
        });// 3만원이하
        tb_123.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    price =99;
                    tb_01.setChecked(false);
                    tb_12.setChecked(false);
                    tb_23.setChecked(false);
                }
            }
        });// 상관없음





    }
}
