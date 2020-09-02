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

public class CalendarPage extends AppCompatActivity {
    private ImageView menu_main, menu_calendar, menu_pill, menu_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_calendar);
        Log.d("CalendarPage", "OnCreate");

        menu_main=findViewById(R.id.menu_main);
        menu_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CalendarPage", "Menu_MainClicked");
                Intent intent = new Intent(CalendarPage.this, MainPage.class);
                startActivity(intent);
            }
        });

        menu_calendar=findViewById(R.id.menu_calendar);
        menu_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CalendarPage", "Menu_CalendarClicked");
                Intent intent = new Intent(CalendarPage.this, CalendarPage.class);
                startActivity(intent);
            }
        });
        menu_pill=findViewById(R.id.menu_pill);
        menu_pill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CalendarPage", "Menu_PillClicked");
                Intent intent = new Intent(CalendarPage.this, PillPage.class);
                startActivity(intent);
            }
        });
        menu_setting=findViewById(R.id.menu_setting);
        menu_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CalendarPage", "Menu_SettingClicked");
                Intent intent = new Intent(CalendarPage.this, SettingPage.class);
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
