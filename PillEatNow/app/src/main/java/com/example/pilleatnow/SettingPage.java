package com.example.pilleatnow;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class SettingPage extends AppCompatActivity {
    private ImageView menu_main, menu_calendar, menu_pill, menu_setting;
    private ArrayList<HashMap<String, String>> Data=new ArrayList<>();
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_setting);
        Log.d("SettingPage", "OnCreate");
        listview=(ListView)findViewById(R.id.listview);
        UserData userData = (UserData) getApplication();

        //설정 메뉴

        HashMap<String, String> InputData1= new HashMap<>();
        InputData1.put("title", "계정 설정");
        InputData1.put("text", "계정을 관리합니다.");
        Data.add(InputData1);

        HashMap<String, String> InputData2= new HashMap<>();
        InputData2.put("title", "푸시 알림 설정");
        InputData2.put("text", "알림 시간, 방법 등을 설정합니다.");
        Data.add(InputData2);

        HashMap<String, String> InputData3= new HashMap<>();
        InputData3.put("title", "테마 설정");
        InputData3.put("text", "테마를 설정합니다.");
        Data.add(InputData3);




        //^설정 추가^
        SimpleAdapter simpleAdapter=new SimpleAdapter(this, Data
                , android.R.layout.simple_list_item_2
                , new String[] {"title", "text"}
                , new int[]{android.R.id.text1, android.R.id.text2});
        listview.setAdapter(simpleAdapter);

        menu_main=findViewById(R.id.menu_main);
        menu_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("SettingPage", "Menu_MainClicked");
                Intent intent = new Intent(SettingPage.this, MainPage.class);
                startActivity(intent);
            }
        });

        menu_calendar=findViewById(R.id.menu_calendar);
        menu_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("SettingPage", "Menu_CalendarClicked");
                Intent intent = new Intent(SettingPage.this, CalendarPage.class);
                startActivity(intent);
            }
        });
        menu_pill=findViewById(R.id.menu_pill);
        menu_pill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("SettingPage", "Menu_PillClicked");
                Intent intent = new Intent(SettingPage.this, PillPage.class);
                startActivity(intent);
            }
        });
        menu_setting=findViewById(R.id.menu_setting);
        menu_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("SettingPage", "Menu_SettingClicked");
                Intent intent = new Intent(SettingPage.this, SettingPage.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert= new AlertDialog.Builder(this);
        alert.setMessage("정말로 종료하시겠습니까?");
        alert.setPositiveButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alert.setNegativeButton("종료", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        alert.setTitle("PillEatNow 종료");
        AlertDialog alert1=alert.create();
        alert1.show();
    }
}
