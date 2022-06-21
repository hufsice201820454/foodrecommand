package com.example.foodrocommender;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {

    private ImageButton im1, im2, im3;// 음식 사진 을 보여주는 이미지 버튼, 클릭시 음식이름 나옴
    private TextView fe1, fe2, fe3;//음식에 해당하는 간단한 글귀
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();//액션바 숨김

        im1 = findViewById(R.id.im1);
        im2 = findViewById(R.id.im2);
        im3 = findViewById(R.id.im3);
        im1.setClipToOutline(true);
        im2.setClipToOutline(true);
        im3.setClipToOutline(true);
        fe1 = findViewById(R.id.foodex1);
        fe2 = findViewById(R.id.foodex2);
        fe3 = findViewById(R.id.foodex3);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //hot : 0:맵지 않음 1:약간매움 2:매움 3:아주매움
        //price : 1:만원 이하, 2: 2만원 이하, 3: 3만원 이하, 4: 3만원 이상
        //time : 아점저야 순서로 배수 123 순으로 표기. 가령, 2310(아침2 점심3 저녁1 야식0)
        //kind : 0:한식, 1:양식, 2:중식, 3:일식, 4:기타

        //음식 객체 추가
        Food sandwitch = new Food(0, 1, 0, 0, 93330, 1, "샌드위치", "가성비 좋은 샌드위치어떠세요?", R.drawable.sandwich);
        Food doughnut = new Food(0, 1, 0, 0, 93300, 1, "도너츠", "도너츠먹어라", R.drawable.donut);
        Food burger = new Food(0, 1, 0, 0, 90331, 1, "햄버거", "다양한 맛 햄버거어떠세요?", R.drawable.hamburger);
        Food pizza = new Food(0, 2, 0, 0, 90132, 1, "피자", "피자는 피자헛이죠", R.drawable.pizza);
        Food chicken = new Food(0, 3, 0, 0, 90133, 1, "치킨", "바삭한 치킨어떠세요?", R.drawable.chicken);
        Food pancake = new Food(0, 2, 0, 0, 93200, 1, "팬케이크", "폭신한 팬케이크어떠세요?", R.drawable.pancake);
        Food waffle = new Food(0, 1, 0, 0, 93200, 1, "와플", "바삭한 와플먹어라", R.drawable.waffle);
        Food pilaf = new Food(1, 1, 0, 0, 91230, 1, "필라프", "볶음밥과는 다른매력의 필라프어떠세요?", R.drawable.pilaf);
        Food kebab = new Food(0, 2, 0, 0, 91320, 1, "케밥", "고기의 탑 케밥은 어떠세요?", R.drawable.kebob);
        Food risotto = new Food(0, 1, 0, 0, 90330, 1, "리조또", "부드러운 리조또어떠세요?", R.drawable.risotto);
        Food bongole = new Food(1, 1, 0, 0, 90330, 1, "봉골레", "해산물의 시원함 봉골레어떠세요?", R.drawable.bongolepasta);
        Food zzazang = new Food(0, 1, 0, 0, 90330, 2, "짜장면", "이사날에는 짜장면이죠", R.drawable.jajangmyeon);
        Food zzambbong = new Food(2, 1, 1, 0, 90330, 2, "짬뽕", "매콤한 짬뽕 어떠세요?", R.drawable.jjamppong);
        Food tangsuyook = new Food(0, 2, 0, 0, 90331, 2, "탕수육", "바삭한 탕수육 어떠세요?", R.drawable.tangsooyook);
        Food guobarou = new Food(0, 2, 0, 0, 90331, 2, "꿔바로우", "쫄깃한 꿔바로우 어떠세요?", R.drawable.guobaorou);
        Food kkanpung = new Food(1, 2, 1, 0, 90331, 2, "깐풍기", "깐풍기 어떠세요?", R.drawable.kkanpunggi);
        Food menbosya = new Food(0, 2, 0, 0, 90331, 2, "멘보샤", "바삭한 멘보샤 어떠세요?", R.drawable.shrimptoast);
        Food yuringi = new Food(0, 2, 0, 0, 90330, 2, "유린기", "바삭한 유린기어떠세요?", R.drawable.yuringi);
        Food mafatofu = new Food(1, 1, 0, 0, 91330, 2, "마파두부", "밥도둑 마파두부 어떠세요?", R.drawable.mapadubu);
        Food Japche = new Food(1, 2, 1, 0, 90330, 2, "고추 잡채", "급식으로 자주나오던 꽃빵과 함께", R.drawable.gochujapchae);
        Food gismyun = new Food(1, 1, 1, 0, 90330, 2, "기스면", "중국의 별미 기스면어떠세요?", R.drawable.giseumyeon);
        Food sushi = new Food(0, 2, 0, 0, 92220, 3, "초밥", "일본하면 초밥이죠", R.drawable.sushi);
        Food onigiri = new Food(0, 1, 0, 0, 93310, 3, "오니기리", "만화에서 자주나오던 오니기리 어떠세요?", R.drawable.onigiri);
        Food gatsudon = new Food(0, 1, 0, 0, 90330, 3, "가츠동", "덮밥시리즈 가츠동은어떠세요?", R.drawable.katsudong);
        Food gyudon = new Food(0, 1, 0, 0, 90330, 3, "규동", "규동 어떠세요?", R.drawable.gyudong);
        Food tendon = new Food(0,2,0,0,90330,3, "텐동", "바삭한 덮밥 텐동어떠세요?", R.drawable.tendon);
        Food oyakodon = new Food(0, 1, 0, 0, 90330, 3, "오야코동", "오야코동 어떠세요?", R.drawable.oyakodong);
        Food udon = new Food(0, 1, 1, 0, 90331, 3, "우동", "겨울철엔 뜨끈한 우동이죠", R.drawable.udong);
        Food soba = new Food(0, 1, 0, 0, 90330, 3, "소바", "여름엔 시원한 소바어떠세요?", R.drawable.soba);
        Food takoyaki = new Food(0, 1, 0, 0, 90221, 3, "타코야끼", "우리아이 간식인 타코야끼 어떠세요?", R.drawable.takoyaki);
        Food okonomiyaki = new Food(0, 2, 0, 0, 90122, 3, "오코노미야끼", "타코야끼와는 다른매력의 오코노미야끼어떠세요?", R.drawable.okonomiyaki);
        Food chamchimayo = new Food(0, 1, 0, 0, 90330, 0, "참치마요덮밥", "급식때 자주먹던 참치마요 어떠세요?", R.drawable.tunarice);
        Food chickmayo = new Food(0, 1, 0, 0, 90330, 0, "치킨마요덮밥", "급식때 자주먹던 치킨마요 어떠세요?", R.drawable.chickenrice);
        Food gogiguksu = new Food(0, 1, 1, 0, 91330, 0, "고기 국수", "든든한 고기국수 어떠세요?", R.drawable.meatguksu);
        Food dakkalguksu = new Food(0, 1, 1, 0, 91330, 0, "닭 칼국수", "시원한 닭칼국수 어떠세요?", R.drawable.chickenkalguksu);
        Food bazirakkalguksu = new Food(0, 1, 1, 0, 91330, 0, "바지락 칼국수", "시원한 바지락칼국수 어떠세요?", R.drawable.kalguksu);
        Food jangkalguksu = new Food(1, 1, 1, 0, 91330, 0, "장칼국수", "전통시장의 맛 장칼국수어떠세요?", R.drawable.jangkalguksu);
        Food milmyun = new Food(0, 1, 0, 0, 91320, 0, "밀면", "오늘은 밀면 어떠세요?", R.drawable.milmyeon);
        Food zzolmyun = new Food(0, 1, 0, 1, 91321, 0, "쫄면", "분식은 역시 쫄면이죠", R.drawable.jjolmyeon);
        Food nengmyun = new Food(0, 1, 0, 1, 90330, 0, "냉면", "여름엔 냉면이죠", R.drawable.naengmyeon);
        Food konggukusu = new Food(0, 1, 0, 1, 91220, 0, "콩국수", "여름의 별미 콩국수 어떠세요?", R.drawable.beannoodle);
        Food kkarebonara = new Food(0,1,0,0,90230,1,"까르보나라","부드러운 까르보나라 어떠세요?", R.drawable.creampasta);
        Food toumba = new Food(1, 1, 0, 0, 90230, 1,"투움바", "부드러움과 매움이 공존하는 투움바", R.drawable.toowoomba_pasta);
        Food tomatopasta = new Food(0,1,0,0,90230, 1,"토마토파스타", "무난한 토마토파스타 어떠세요?", R.drawable.tomato_pasta);
        Food ragupasta = new Food(1,1,0,0,90230,1,"라구파스타", "파스타의 변신 라구파스타 어떠세요?", R.drawable.ragupasta);
        Food taco = new Food(1,1,0,0,90230,1,"타코","멕시코의 여름별미 타코어떠세요?", R.drawable.taco);
        Food quasadia = new Food(0,1,0,0,90330,1,"퀘사디아","퀘사디아 어떠세요?", R.drawable.quesadilla);
        Food steak = new Food(0,3,0,0,90130,1,"스테이크","스테이크는 아웃백이죠", R.drawable.steak);
        Food bbaaeua = new Food(0,1,0,0,90230,1,"빠에야","오늘은 빠에야 어떠세요?", R.drawable.paella);
        Food poklip = new Food(0,3,0,0,90130,1,"폭립","오늘은 폭립어떠세요?", R.drawable.porkrib);
        Food bbabequeplatter = new Food(0,4,0,0,90131,1,"바비큐플레터","월급날엔 바비큐죠", R.drawable.barbecueplatter);
        Food beefstew = new Food(0,2,0,0,91331,1,"비프스튜","뜨끈한 비프스튜어떠세요?", R.drawable.beefstew);
        Food gambas = new Food(0,2,0,0,90231,1,"감바스","담백한 감바스 어떠세요?", R.drawable.gambas);
        Food hotdog = new Food(0,1,0,0,92312,1,"핫도그","휴게소의 그맛 핫도그 어떠세요?", R.drawable.hotdog);
        Food corndog = new Food(0,1,0,0,91302,1,"콘도그","휴게소의 그맛 콘도그 어떠세요?", R.drawable.corndog);
        Food brunch = new Food(0,1,0,0,93100,1,"브런치","서양의아침 브런치 어떠세요?", R.drawable.brunch);
        Food egginhell = new Food(0,2,0,0,91301,1,"에그인헬","에그인헬이 유행이라면서요?", R.drawable.egginhell);
        Food curry = new Food(0,1,0,0,92331,4,"카레","무난한 카레어떠세요?", R.drawable.curry);
        Food hunjeunae = new Food(0,2,0,0,90330,1,"훈제연어", "다이어트에 좋은 연어어떠세요?", R.drawable.roastsalmon);
        Food rapstar = new Food(0,4,0,0,90230,1,"랍스터", "월급날이시면 랍스터어떠세요?", R.drawable.lobster);
        Food daegae = new Food(0,4,0,0,90230,0,"대게", "월급날이시면 대게어떠세요?" , R.drawable.bigcrab);
        Food steakrice = new Food(0,2,0,0,90230,1,"스테이크동","부드러운 스테이크동어떠세요?", R.drawable.steakrice);
        Food ueulnamsam = new Food(0,2,0,0,90310,4,"월남쌈","가족과 함께먹는 월남쌈어떠세요?", R.drawable.wollamssam);
        Food ssalguksu = new Food(0,1,0,0,91330,4,"쌀국수","베트남 별미 쌀국수어떠세요?", R.drawable.ricenoodle);
        Food spicyschicken =  new Food(1,2,0,0,90233,0,"양념치킨","한국식 치킨 양념치킨어떠세요?", R.drawable.spicychicken);
        Food soychicken = new Food(0,2,0,0,90233,0,"간장치킨","한국식 치킨 간장치킨어떠세요?", R.drawable.soysaucechicken);
        Food padak = new Food(0,2,0,0,90233,0,"파닭","소스와 파를 쌈싸먹는 파닭은어떠세요?", R.drawable.pachicken);
        Food maccheese = new Food(0,1,0,0,91112,1,"맥앤치즈","부드러운 맥앤치즈 어떠세요?", R.drawable.macandcheese);
        Food toast = new Food(0,1,0,0,93300,1,"토스트","바삭한 토스트 어떠세요?", R.drawable.toast);
        Food roastturkey = new Food(0,4,0,0,90231,1,"칠면조구이","가족과 함께하는 칠면조 어떠세요?", R.drawable.turkeyroast);
        Food rajanaa = new Food(0,1,0,0,90331,1,"라자냐","다양한 맛이있는 라자냐어떠세요?", R.drawable.lasagna);
        Food lambgalbi = new Food(0,2,0,0,90130,1,"양갈비","요즘 양이 제철이래요", R.drawable.yanggalbi);
        Food sosage =  new Food(0,1,0,0,90331,1,"소세지","톡톡튀는 소세지어떠세요?", R.drawable.sausages);
        Food salmonsteak = new Food(0,2,0,0,90230,1,"연어스테이크","담백한 연어스테이크 어떠세요?", R.drawable.salmonsteak);
        Food hunjaeduck = new Food(0,2,0,0,90230,1,"훈제오리","쫄깃한 훈제오리 어떠세요?", R.drawable.roastduck);
        Food briskit = new Food(0,3,0,0,90131,1,"브리스킷","쭉쭉 찢어지는 브리스킷어떠세요?", R.drawable.brisket);
        Food britto = new Food(0,1,0,0,91230,1,"브리또","외대앞 브리또가 맛있데요 어떠세요?", R.drawable.burrito);
        Food jambalia = new Food(0,2,0,0,90330,1,"잠발라야","오늘은 잠발라야 어떠세요?", R.drawable.jambalaya);
        Food rabioli = new Food(0,2,0,0,90320,1,"라비올리","이탈리아식 만두 라비올리 어떠세요?", R.drawable.ravioli);
        Food ulmun = new Food(0,1,0,0,90330,2,"울면","슬플땐 울면어떠세요?", R.drawable.ulmyeon);
        Food rajogi = new Food(0,3,0,0,90330,2,"라조기","오늘은 라조기 어떠세요?", R.drawable.rajogi);
        Food lambggochi = new Food(0,2,0,0,90133,2,"양꼬치","우리아이 술안주 양꼬치 어떠세요?", R.drawable.yangggochi);
        Food maratang = new Food(3,1,0,0,90331,2,"마라탕","맛있으면 0칼로리 마라탕어떠세요?", R.drawable.malatang);
        Food maralongsha = new Food(2,1,0,0,90331,2,"마라롱샤","오늘은 마라롱샤 어떠세요?", R.drawable.maralongsha);
        Food gganshowshirimp = new Food(0,3,0,0,90331,2,"깐쇼새우","칠리소스와 함께 깐쇼새우어떠세요?", R.drawable.kkansho_shrimp);
        Food yangjangpi = new Food(0,3,0,0,90230,2,"양장피","중국집 필수메뉴 양장피 어떠세요?", R.drawable.yangjangpi);
        Food palbochae = new Food(0,3,0,0,90230,2,"팔보채","다양한 식감 팔보채는 어떠세요?", R.drawable.palbochae);
        Food dongpayuk = new Food(0,3,0,0,90130,2,"동파육","입안에서 녹아버리는 동파육 어떠세요?", R.drawable.dongpayuk);
        Food tantanmuen = new Food(2,1,0,0,90330,2,"탄탄면","짜장 짬뽕말고 탄탄면 어떠세요?", R.drawable.tantanmyeon);
        Food uhangdongo =  new Food(0,4,0,0,90230,2,"어향동고","오늘은 어향동고 어떠세요?", R.drawable.eohyangdonggo);
        Food uhangazi = new Food(0,3,0,0,90230,2,"어향가지","가지의 재발견 어향가지 어떠세요?", R.drawable.eohyanggaji);
        Food wooyukmeun = new Food(0,1,0,0,90320,2,"우육면","중국의 소고기요리 우육면어떠세요?", R.drawable.woyukmyeon);
        Food nanjawanse = new Food(0,3,0,0,90330,2,"난자완스","오늘은 난자완스 어떠세요?", R.drawable.nanjawanseu);
        Food huagua = new Food(2,2,0,0,90230,2,"훠궈","비싸지만 제값한다 훠궈어떠세요?", R.drawable.huoguo);
        Food nangzzambbong = new Food(1,1,0,1,90330,2,"냉짬뽕","매움과 시원함이 하나로", R.drawable.icejjamppong);
        Food dimsum = new Food(0,1,0,0,90321,2,"딤섬","중국하면 만두죠", R.drawable.dimsum);
        Food shaolongbao = new Food(0,1,0,0,90321,2,"샤오롱바오","중국식 만두 샤오롱바오 어떠세요?", R.drawable.xiaolongbao);
        Food pattai = new Food(0,1,0,0,90330,2,"팟타이","태국에 대표음식 팟타이 어떠세요?", R.drawable.padthai);
        Food ddomanggong = new Food(2,1,0,0,90330,4,"똠양꿍","얼큰한 똠양꿍 어떠세요?", R.drawable.tomyumgoong);
        Food majangmeun = new Food(0,1,0,0,90330,2,"마장면","정통중식 마장면 어떠세요?", R.drawable.majangmyeon);
        Food banmi = new Food(0,1,0,0,93310,2,"반미","베트남식 샌드위치 반미 어떠세요?", R.drawable.banhmi);
        Food nasigolang = new Food(1,1,0,0,90330,2,"나시고랭","색다른 볶음밥 나시고랭 어떠세요?", R.drawable.nasigoreng);
        Food kyungjanguksa = new Food(0,1,0,0,91230,2,"경장육사","오늘 경장육사 어떠세요?", R.drawable.kyungjangyooksa);
        Food beijingduck = new Food(0,4,0,0,90130,2,"베이징덕","베이징의 전통 베이징덕 어떠세요?", R.drawable.beijingduck);
        Food tepanyaki = new Food(0,2,0,0,90131,3,"테판야키", "철판요리가 땡길땐 테판야키 어떠세요?", R.drawable.teppanyaki);
        Food tenpura = new Food(0,2,0,0,90330,3,"텐푸라","다양한 튀김요리 텐푸라 어떠세요?", R.drawable.tenpura);
        Food porkcurtlet = new Food(0,1,0,0,90330,3,"돈까스","바삭한 돈까스 어떠세요?", R.drawable.porkcutlet);
        Food gukache = new Food(0,3,0,0,90230,3,"규카츠","바삭한 소고기 규카츠 어떠세요?", R.drawable.gyukatsu);
        Food shabe = new Food(0,2,0,2,90330,3,"샤브샤브","뜨끈한 샤브샤브 어떠세요?", R.drawable.shabushabu);
        Food odengtang = new Food(0,2,0,2,90331,3,"오뎅탕","뜨끈한 오뎅탕 어떠세요?", R.drawable.odengtang);
        Food shasimi = new Food(0,2,0,0,90230,3,"사시미", "돈 좀 쓰고싶을때 사시미 어떠세요?", R.drawable.sashimi);
        Food yakitori = new Food(0,2,0,0,90121,3,"야키토리","일본식 닭꼬치 야키토리 어떠세요?", R.drawable.yakitori);
        Food ramen = new Food(0,1,1,2,90231,3,"라멘","일본하면 라멘이죠", R.drawable.japaneseramen);
        Food omirice = new Food(0,1,0,0,90230,3,"오므라이스","오늘 오므라이스 어떠세요?", R.drawable.omeletrice);
        Food hambak = new Food(0,2,0,0,90330,3,"함박스테이크", "오늘 함박스테이크 어떠세요?", R.drawable.hamburgsteak);
        Food albap = new Food(0,2,0,0,90330,3,"알밥","톡톡튀는 알밥 어떠세요?", R.drawable.albap);
        Food nabe = new Food(0,3,0,0,90130,3,"전골나베", "뜨끈한 전골나베 어떠세요?", R.drawable.jeongolnabe);
        Food yakisoba = new Food(0,2,0,1,90231,3,"야키소바","볶음면이 먹고싶을땐 야키소바 어떠세요?", R.drawable.yakisoba);
        Food galbitang = new Food(0,2,0,2,91330,0,"갈비탕","오늘 갈비탕은 어떠세요?", R.drawable.galbitang);
        Food gamjatang = new Food(1,3,0,0,90330,0,"감자탕","든든하게 감자탕 어떠세요?", R.drawable.gamjatang);
        Food gomtang = new Food(0,2,0,0,91330,0,"곰탕","뜨끈한 곰탕 어떠세요?", R.drawable.gomtang);
        Food maeuntang = new Food(2,3,1,0,90230,0,"매운탕","얼큰한 매운탕 어떠세요?", R.drawable.maeuntang);
        Food samgyetang = new Food(0,2,0,1,90230,0,"삼계탕","몸보신이 필요할땐 삼계탕이죠", R.drawable.samgyetang);
        Food yunpotang = new Food(0,4,0,0,90330,0,"연포탕","맑은 국물이 땡길땐 연포탕이죠", R.drawable.yeonpotang);
        Food chuutang = new Food(1,1,0,1,90330,0,"추어탕","오늘 추어탕 어떠세요?", R.drawable.chueotang);
        Food dakgyejang = new Food(1,1,0,0,91330,0,"닭개장","얼큰한 닭개장 어떠세요?", R.drawable.dakgaejang);
        Food yukaejang = new Food(1,1,0,0,91330,0,"육개장","육개장은 역시 보배집이죠~", R.drawable.yukgaejang);
        Food manduguk = new Food(0,1,0,2,91330,0,"만두국","뜨끈한 만두국 어떠세요?", R.drawable.mandoguk);
        Food sunjihaejangguk = new Food(1,1,0,2,91330,0,"선지해장국","뜨끈한 선지해장국 어떠세요?", R.drawable.seonjihaejangguk);
        Food pinggukbab = new Food(0,1,0,0,91330,0,"돼지국밥","든든함의 대표 돼지국밥 어떠세요?", R.drawable.dwaejigukbap);
        Food cowgukbab = new Food(0,1,0,0,91330,0,"소머리국밥", "뜨끈한 소머리국밥 어떠세요?", R.drawable.someorigukbap);
        Food beankukbab = new Food(0,1,0,0,91330,0,"콩나물국밥","미친 가성비의 콩나물국밥 어떠세요?", R.drawable.kongnamulgukbap);
        Food gochujang = new Food(1,1,0,0,91330,0,"고추장찌개","얼큰하게 고추장찌개 어떠세요?", R.drawable.gochujangjjigae);
        Food kimchijjigae = new Food(1,1,0,0,91331,0,"김치찌개", "밥도둑중의 밥도둑 김치찌개 어떠세요?", R.drawable.kimchistew);
        Food jaguelie = new Food(1,1,0,0,90331,0,"짜글이","김치찌개와는 또 다른맛", R.drawable.jjageuli);
        Food dongtaejjigae = new Food(1,2,0,0,91330,0,"동태찌개","오늘 동태찌개 어떠세요?", R.drawable.dongtaejjigae);
        Food budaejjigae = new Food(1,2,0,0,90330,0,"부대찌개","매콤하게 부대찌게 어떠세요?", R.drawable.budaejjigae);
        Food sundubujjigae = new Food(1,1,0,0,90330,0,"순두부찌개","뜨끈한 순두부찌개 어떠세요?", R.drawable.sundubujjigae);
        Food gimbap = new Food(0,1,0,0,92330,0,"김밥","간단하게 먹기좋은 김밥 어떠세요?", R.drawable.kimbap);
        Food tteokbokki = new Food(2,0,0,0,90332,0,"떡볶이","분식에 대표 떡볶이 어떠세요?", R.drawable.tteokbokki);
        Food ramun = new Food(1,0,0,0,93332,0,"라면","언제먹어도 맛있는 라면 어떠세요?", R.drawable.ramen);
        Food roastfish = new Food(0,1,0,0,93330,0,"생선구이","오늘 생선구이 어떠세요?", R.drawable.roastfish);
        Food fishjorim = new Food(0,2,0,0,93330,0,"생선조림","오늘 생선조림 어떠세요?", R.drawable.fishjorim);
        Food pajun = new Food(0,1,1,0,90133,0,"파전","비오는날엔 파전이죠", R.drawable.pajun);
        Food kimchijun = new Food(1,1,1,0,90133,0,"김치전","부침개의 대표 김치전 어떠세요?", R.drawable.kimchijun);
        Food bulgogi = new Food(0,2,0,0,90330,0,"불고기","한식하면 불고기죠", R.drawable.bulgogi);
        Food nerbiani = new Food(0,1,0,0,91330,0,"너비아니","오늘 너비아니 어떠세요?", R.drawable.neobiani);
        Food cowgalbi = new Food(0,3,0,0,90230,0,"소갈비","소의 끝판왕 소갈비 어떠세요?", R.drawable.sogalbi);
        Food kimchojjim = new Food(1,2,0,0,90330,0,"김치찜","매일 먹어도 안질리는 김치찜 어떠세요?", R.drawable.kimchijjim);
        Food rawcow = new Food(0,3,0,0,90131,0,"육회","가격빼곤 모든게 완벽한 음식이죠", R.drawable.rawbeef);
        Food piggalbi = new Food(0,2,0,0,90230,0,"돼지갈비","특별한 날엔 돼지갈비 어떠세요?", R.drawable.dwaejigalbi);
        Food samkyupsal = new Food(0,2,0,0,90130,0,"삼겹살","매일 먹고싶은 맛의 삼겹살 어떠세요?", R.drawable.porkbelly);
        Food jeyuk = new Food(1,2,0,0,90330,0,"제육볶음","매콤하게 제육볶음 어떠세요?", R.drawable.jeyukbokkeum);
        Food duruchigi = new Food(0,1,0,0,90331,0,"두루치기","오늘 두루치기 어떠세요?", R.drawable.duruchigi);
        Food bosam = new Food(0,4,0,0,90333,0,"보쌈","김장하면 떠오르는 보쌈 어떠세요?", R.drawable.bossam);
        Food suyuk = new Food(0,4,0,0,90333,0,"수육","비싸지만 맛있는 수육 어떠세요?", R.drawable.suyuk);
        Food jokbal = new Food(0,4,0,0,90333,0,"족발","돼지는 발조차 맛있습니다", R.drawable.jokbal);
        Food dakgalbi = new Food(0,2,0,0,90230,0,"닭갈비","닭갈비하면 춘천이죠", R.drawable.dakgalbi);
        Food waterdakgalbi = new Food(1,2,0,0,90230,0,"물닭갈비","오늘 물닭갈비 어떠세요?", R.drawable.muldakgalbi);
        Food dakdoritang = new Food(1,2,0,0,90231,0,"닭도리탕","매콤한 닭도리탕 어떠세요?", R.drawable.dakdoritang);
        Food dakgangjung = new Food(0,1,0,0,90323,0,"닭강정","치킨과는 다른맛 닭강정 어떠세요?", R.drawable.dakgangjeong);
        Food dakbal = new Food(0,2,0,0,90133,0,"닭발","매콤한 닭발 어떠세요?", R.drawable.chickenfoot);
        Food jjimdak = new Food(0,3,0,0,90131,0,"찜닭","밥도둑 찜닭 어떠세요?", R.drawable.jjimdak);
        Food bibimbab = new Food(1,1,0,0,92320,0,"비빔밥","입맛 없을때 최고인 비빔밥 어떠세요?", R.drawable.bibimbap);
        Food kimchibokembab = new Food(1,1,0,0,91330,0,"김치볶은밥","언제먹어도 맛있는 김치볶음밥 어떠세요?", R.drawable.kimchirice);
        Food chinabokembab = new Food(0,1,0,0,90330,2,"중국식볶음밥","짜장에 밥은 언제나 성공이죠", R.drawable.jajang_rice);
        Food babburger = new Food(0,1,0,0,93321,0,"밥버거","간단하게 먹고싶을때 밥버거 어떠세요?", R.drawable.riceburger);
        Food sujebi = new Food(0,2,0,2,90330,0,"수제비","쫄깃쫄깃한 수제비 어떠세요?", R.drawable.sujebi);
        Food yachegopchang = new Food(0,3,0,0,90133,0,"야채곱창","오늘 야채곱창은 어떠세요?", R.drawable.yachaegopchang);
        Food cowgopchang = new Food(0,3,0,0,90133,0,"소곱창","돼지와는 또 다른맛 소곱창 어떠세요?", R.drawable.sogopchang);
        Food daechang = new Food(0,3,0,0,90133,0,"대창","오늘 대창은 어떠세요?", R.drawable.daechang);
        Food makchang = new Food(0,2,0,0,90133,0,"막창","오늘 막창은 어떠세요?", R.drawable.makchang);
        Food pigkkupdaegi = new Food(0,2,0,0,90133,0,"돼지껍데기","쫄깃한 식감의 돼지껍데기 어떠세요?", R.drawable.dwaejikkeopdegi);
        Food rawfish = new Food(0,3,0,0,90231,3,"회","쫄깃쫄깃한 회 어떠세요?", R.drawable.rawfish);
        Food janguh = new Food(0,4,0,0,90230,0,"장어구이","몸보신하면 장어구이죠", R.drawable.broiled_eels);
        Food agujjim = new Food(0,4,0,0,90230,0,"아구찜","오늘 아구찜 어떠세요?", R.drawable.agujjim);
        Food hamuljjim = new Food(0,3,0,0,90230,0,"해물찜","해물의 종합세트 해물찜 어떠세요?", R.drawable.haemuljjim);
        Food mulheul = new Food(0,2,0,1,90330,0,"물회","시원한 물회 어떠세요?", R.drawable.mulhoe);
        Food jjukkumi = new Food(1,2,0,0,90330,0,"쭈꾸미","낙지와는 또 다른 쭈꾸미 어떠세요?", R.drawable.jjuccumi);
        Food gopdoritang = new Food(1,3,0,0,90131,0,"곱도리탕","얼큰한 곱도리탕 어떠세요?", R.drawable.gopdoritang);
        Food nakgopsae = new Food(2,3,0,0,90133,0, "낙곱새","낙지 곱창 새우가 한번에!", R.drawable.nakgopsae);
        Food ohsambulgogi = new Food(0,2,0,0,90230,0,"오삼불고기","오징어와 삼겹살이 한번에!", R.drawable.osambulgogi);
        Food tandurichicken = new Food(0,2,0,0,90231,1, "탄두리치킨","치킨의 또다른 변신 탄두리치킨 어떠세요?", R.drawable.tandoori_chicken);
        Food kodari = new Food(0,3,0,0,90230,0,"코다리","오늘 코다리 어떠세요?", R.drawable.kodari);
        Food soygejang = new Food(0,3,0,0,90230,0,"간장게장","밥도둑 간장게장 어떠세요?", R.drawable.soysaucecrab);
        Food spicygejang = new Food(1,3,0,0,90230,0,"양념게장","매콤한 양념게장 어떠세요?", R.drawable.spicycrab);
        Food gopchangjungol = new Food(0,3,0,0,90133,0,"곱창전골","뜨끈한 곱창전골 어떠세요?", R.drawable.gopchangjeongol);
        Food dakddongzip = new Food(0,2,0,0,90123,0,"닭똥집","이름과 무관하게 먹어보면 대박입니다", R.drawable.ddongzip);
        Food golbangei = new Food(1,1,0,0,90123,0,"골벵이무침","오늘 골벵이무침 어떠세요?", R.drawable.golbaengimuchim);
        Food bbuehajangkuk = new Food(1,1,0,2,91230,0,"뼈해장국","든든하게 뼈해장국 어떠세요?", R.drawable.ppyeohaejangguk);
        Food bibimnangmyeon = new Food(2,1,0,1,90230,0,"비빔냉면","매콤한 비빔냉면 어떠세요?", R.drawable.bibimnaengmyeon);
        Food makguksu = new Food(1,1,0,0,90330,0,"막국수","시원하게 막국수 어떠세요?", R.drawable.makguksu);
        Food potatoongsimi = new Food(0,1,0,2,90330,0,"감자옹심이","따듯한 감자옹심이 어때세요?", R.drawable.gamjaonshimi);
        Food honghaptang = new Food(0,2,0,2,90232,0,"홍합탕","오늘 홍합탕 어떠세요?", R.drawable.honghaptang);
        Food buljokbal = new Food(3,4,0,0,90233,0,"불족발","족발이 느끼하면 불족발어떠세요?", R.drawable.buljokbal);

        Food[] foodtable = {sandwitch, doughnut, burger, pizza, chicken, pancake, waffle, pilaf, kebab, risotto, zzazang, zzambbong, tangsuyook, guobarou, kkanpung, menbosya, yuringi, mafatofu, Japche, gismyun,
                sushi, onigiri, gatsudon, gyudon, tendon, oyakodon, udon, soba, takoyaki, okonomiyaki, chamchimayo, chickmayo, gogiguksu, dakkalguksu, bazirakkalguksu, jangkalguksu, milmyun, zzolmyun,
                nengmyun, konggukusu, bongole, kkarebonara, toumba, tomatopasta, ragupasta, taco, quasadia, steak, bbaaeua,poklip,bbabequeplatter, beefstew, gambas, steakrice, hotdog,corndog, brunch, egginhell, curry, hunjeunae,
                rapstar, daegae,ueulnamsam, ssalguksu,spicyschicken, soychicken, padak, maccheese,toast, roastturkey,rajanaa,lambgalbi, sosage, salmonsteak,
                hunjaeduck,briskit,britto,jambalia, rabioli, ulmun, rajogi, lambggochi,maratang, maralongsha,gganshowshirimp, yangjangpi, palbochae,
                dongpayuk, tantanmuen, uhangdongo,uhangazi, wooyukmeun, nanjawanse, huagua, nangzzambbong, dimsum, shaolongbao, pattai, ddomanggong, majangmeun,banmi,
                nasigolang, kyungjanguksa, beijingduck,tepanyaki,tenpura,porkcurtlet,gukache,shabe,odengtang, shasimi, yakitori, ramen, omirice, hambak,albap ,nabe,yakisoba,
                galbitang,gamjatang,gomtang,maeuntang,samgyetang,yunpotang,chuutang,dakgyejang,yukaejang,manduguk,sunjihaejangguk,pinggukbab,cowgukbab,beankukbab,gochujang,kimchijjigae,jaguelie,dongtaejjigae,budaejjigae,sundubujjigae,gimbap,tteokbokki,ramun,roastfish,fishjorim,
                pajun, kimchijun, bulgogi, nerbiani, cowgalbi, kimchojjim, rawcow, piggalbi, ssalguksu, jeyuk, samkyupsal,
                duruchigi, bosam, suyuk, jokbal, dakbal, dakgalbi, waterdakgalbi, dakdoritang, dakgangjung,
                jjimdak,bibimbab,kimchibokembab,chinabokembab,babburger,sujebi,yachegopchang,cowgopchang,daechang,makchang,pigkkupdaegi,rawfish,janguh,agujjim,
                hamuljjim,mulheul,jjukkumi,gopdoritang,nakgopsae, ohsambulgogi,tandurichicken,kodari, soygejang,spicygejang,gopchangjungol,dakddongzip,golbangei,bbuehajangkuk,bibimnangmyeon,makguksu,potatoongsimi, honghaptang,buljokbal};

        List<Food> temptable = new ArrayList<>();
        List<Food> randomtable = new ArrayList<>();
        List<Food> recommandtable = new ArrayList<>();
        List<Food> deltable = new ArrayList<>();

        Intent intent = getIntent();//이전 액티비티에서 정보 가져오기
        int toospicy = intent.getIntExtra("toospicy",0);
        int littlespicy = intent.getIntExtra("littlespicy",0);
        int nospicy = intent.getIntExtra("nospicy",0);
        int k = intent.getIntExtra("k",0);
        int y = intent.getIntExtra("y",0);
        int ch = intent.getIntExtra("c",0);
        int j = intent.getIntExtra("j",0);
        int e = intent.getIntExtra("e",0);
        int price = intent.getIntExtra("price",0);

        int w_hot_1 = 0; // 맵지 않음
        int w_hot_2 = 0; // 약간 매움
        int w_hot_3 = 0; // 매움
        int w_price = price; // 1: 만원이하, 2: 2만원 이하, 3: 3만원 이하, 99:상관없음
        int w_time = 0; // 0: 아침 1: 점심 2: 저녁 3: 야식
        int w_kind_k = k ; //한식
        int w_kind_w = y; //양식
        int w_kind_c = ch;//중식
        int w_kind_j = j;//일식
        int w_kind_e = e;//기타

        if(toospicy==1) w_hot_3 = 1;
        if(littlespicy==1) w_hot_2 = 1;
        if(nospicy==1) w_hot_1 = 1;

        LocalTime now = LocalTime.now();

        int hour = now.getHour();

        if((hour>=5)&(hour<11)){//시스템 시간에따라 아침,점심,저녁,야식 분리
            w_time = 0;
        }else if((hour>=11)&(hour<16)){
            w_time = 1;
        }else if((hour>=16)&(hour<21)){
            w_time = 2;
        }else {
            w_time = 3;
        }

        for(int i = 0; i < foodtable.length; i++) {//맵기, 가격, 음식 종류 선택에 해당하는 음식을 템프테이블에 추가

            if(w_hot_1 == 1 & foodtable[i].getHot() == 0){
                if(foodtable[i].getPrice() <= w_price){
                    if(w_kind_k ==1 & foodtable[i].getKind() == 0){
                        temptable.add(foodtable[i]);
                    }
                    if(w_kind_w ==1 & foodtable[i].getKind() == 1){
                        temptable.add(foodtable[i]);
                    }
                    if(w_kind_c ==1 & foodtable[i].getKind() == 2){
                        temptable.add(foodtable[i]);
                    }
                    if(w_kind_j ==1 & foodtable[i].getKind() == 3){
                        temptable.add(foodtable[i]);
                    }
                    if(w_kind_e ==1 & foodtable[i].getKind() == 4){
                        temptable.add(foodtable[i]);
                    }
                }
            }
            if(w_hot_2 == 1 & foodtable[i].getHot() == 1){
                if(foodtable[i].getPrice() <= w_price){
                    if(w_kind_k ==1 & foodtable[i].getKind() == 0){
                        temptable.add(foodtable[i]);
                    }
                    if(w_kind_w ==1 & foodtable[i].getKind() == 1){
                        temptable.add(foodtable[i]);
                    }
                    if(w_kind_c ==1 & foodtable[i].getKind() == 2){
                        temptable.add(foodtable[i]);
                    }
                    if(w_kind_j ==1 & foodtable[i].getKind() == 3){
                        temptable.add(foodtable[i]);
                    }
                    if(w_kind_e ==1 & foodtable[i].getKind() == 4){
                        temptable.add(foodtable[i]);
                    }
                }
            }
            if(w_hot_3 == 1 & foodtable[i].getHot() == 2){
                if(foodtable[i].getPrice() <= w_price){
                    if(w_kind_k ==1 & foodtable[i].getKind() == 0){
                        temptable.add(foodtable[i]);
                    }
                    if(w_kind_w ==1 & foodtable[i].getKind() == 1){
                        temptable.add(foodtable[i]);
                    }
                    if(w_kind_c ==1 & foodtable[i].getKind() == 2){
                        temptable.add(foodtable[i]);
                    }
                    if(w_kind_j ==1 & foodtable[i].getKind() == 3){
                        temptable.add(foodtable[i]);
                    }
                    if(w_kind_e ==1 & foodtable[i].getKind() == 4){
                        temptable.add(foodtable[i]);
                    }
                }
            }
        }

        for(Food value : temptable){//1차로 뽑은 음식들 시간으로 분류
            String morning = Integer.toString(value.getTime()).substring(1,2);
            String lunch = Integer.toString(value.getTime()).substring(2,3);
            String dinner = Integer.toString(value.getTime()).substring(3,4);
            String mmeal = Integer.toString(value.getTime()).substring(4,5);

            if(w_time == 0){
                for(int i = 0; i < Integer.parseInt(morning); i ++){
                    randomtable.add(value);
                }
            }
            if(w_time == 1){
                for(int i = 0; i < Integer.parseInt(lunch); i ++){
                    randomtable.add(value);
                }
            }
            if(w_time == 2){
                for(int i = 0; i < Integer.parseInt(dinner); i ++){
                    randomtable.add(value);
                }
            }
            if(w_time == 3){
                for(int i = 0; i < Integer.parseInt(mmeal); i ++){
                    randomtable.add(value);
                }
            }
        }
////////////////////////////////////////////////////////////////////////////////아래는 추천개수가 부족할때를 위한 알고리즘
        while(true){
            temptable = new ArrayList<>();
            for(int i = 0; i < foodtable.length; i++) {
                if(w_kind_k ==1 & foodtable[i].getKind() == 0){
                    temptable.add(foodtable[i]);
                }
                if(w_kind_w ==1 & foodtable[i].getKind() == 1){
                    temptable.add(foodtable[i]);
                }
                if(w_kind_c ==1 & foodtable[i].getKind() == 2){
                    temptable.add(foodtable[i]);
                }
                if(w_kind_j ==1 & foodtable[i].getKind() == 3){
                    temptable.add(foodtable[i]);
                }
                if(w_kind_e ==1 & foodtable[i].getKind() == 4){
                    temptable.add(foodtable[i]);
                }
            }
            if(randomtable.size()==0){//음식이 아무것도 뽑히지 않았을때
                int a = (int)(Math.random()*temptable.size());
                recommandtable.add(temptable.get(a));
                while(true){
                    int b = (int)(Math.random()*temptable.size());
                    int test = recommandtable.indexOf(temptable.get(b));

                    if(test == -1){
                        recommandtable.add(temptable.get(b));
                        break;
                    }
                }
                while(true){
                    int c = (int)(Math.random()*temptable.size());
                    int test = recommandtable.indexOf(temptable.get(c));
                    if(test == -1){
                        recommandtable.add(temptable.get(c));
                        break;
                    }
                }
                break;
            }

            deltable.add(randomtable.get(0));
            for(int i = randomtable.size()-1; i>=0; i--){
                if(deltable.contains(randomtable.get(i))==false){
                    deltable.add(randomtable.get(i));
                }
            }
            if(deltable.size()==1){///////////////////////////////추천개수가 1개인경우
                recommandtable.add(deltable.get(0));
                while(true){
                    int a = (int)(Math.random()*temptable.size());
                    int test = recommandtable.indexOf(temptable.get(a));

                    if(test == -1){
                        recommandtable.add(temptable.get(a));
                        break;
                    }
                }
                while(true){
                    int b = (int)(Math.random()*temptable.size());
                    int test = recommandtable.indexOf(temptable.get(b));

                    if(test == -1){
                        recommandtable.add(temptable.get(b));
                        break;
                    }
                }
                break;
            }else if(deltable.size()==2){/////////////////////////추천개수가 2개인경우
                recommandtable.add(deltable.get(0));
                recommandtable.add(deltable.get(1));
                while(true){
                    int a = (int)(Math.random()*temptable.size());
                    int test = recommandtable.indexOf(temptable.get(a));

                    if(test == -1){
                        recommandtable.add(temptable.get(a));
                        break;
                    }
                }
                break;
            }
            else{////////////////////////////////////정상인경우
                int a = (int)(Math.random()*randomtable.size());
                recommandtable.add(randomtable.get(a));
                while(true){
                    int b = (int)(Math.random()*randomtable.size());
                    int test = recommandtable.indexOf(randomtable.get(b));

                    if(test == -1){
                        recommandtable.add(randomtable.get(b));
                        break;
                    }
                }
                while(true) {
                    int c = (int) (Math.random() * randomtable.size());
                    int test = recommandtable.indexOf(randomtable.get(c));
                    if (test == -1) {
                        recommandtable.add(randomtable.get(c));
                        break;
                    }
                }
                break;
            }
        }

        ////////결과

        im1.setImageResource(recommandtable.get(0).getPicture());//알고리즘으로 나온 음식 3개 이미지와 간단한 설명 할당
        im2.setImageResource(recommandtable.get(1).getPicture());
        im3.setImageResource(recommandtable.get(2).getPicture());
        fe1.setText('"'+recommandtable.get(0).getExample()+'"');
        fe2.setText('"'+recommandtable.get(1).getExample()+'"');
        fe3.setText('"'+recommandtable.get(2).getExample()+'"');
        ///////////////////////////////////////////////////////////////////////////////////////////////

        im1.setOnClickListener(new View.OnClickListener() {//이미지 버튼 클릭시 토스트메시지로 음식이름 알려줌
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), recommandtable.get(0).getName(), Toast.LENGTH_SHORT).show();

            }
        });
        im2.setOnClickListener(new View.OnClickListener() {//이미지 버튼 클릭시 토스트메시지로 음식이름 알려줌
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), recommandtable.get(1).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        im3.setOnClickListener(new View.OnClickListener() {//이미지 버튼 클릭시 토스트메시지로 음식이름 알려줌
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), recommandtable.get(2).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

class Food{//음식 클래스

    public int hot;

    public int price;

    public int weather;

    public int temperature;

    public int time;

    public int kind;

    public String name;

    public String example;

    public int picture;

    public Food(int hot, int price, int weather, int temperature, int time, int kind, String name, String example, int picture){//음식 생성자
        this.hot = hot;
        this.price = price;
        this.weather = weather;
        this.temperature = temperature;
        this.time = time;
        this.kind = kind;
        this.name = name;
        this.example = example;
        this.picture = picture;
    }
    public int getHot(){
        return hot;
    }
    public int getPrice(){
        return price;
    }
    public int getWeather(){
        return weather;
    }
    public int getTemperature(){
        return temperature;
    }
    public int getTime(){
        return time;
    }
    public int getKind(){
        return kind;
    }
    public String getName(){
        return name;
    }
    public String getExample(){
        return example;
    }
    public int getPicture(){
        return picture;
    }
}
