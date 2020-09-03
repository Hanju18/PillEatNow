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

import java.util.List;

public class MainPage extends AppCompatActivity {
    private ImageView menu_main, menu_calendar, menu_pill, menu_setting;
    private RecyclerView recyclerView1, recyclerView2, recyclerView3;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager1, layoutManager2, layoutManager3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_main);
        Log.d("MainPage", "OnCreate");

        UserData userData = (UserData) getApplication();

        recyclerView1 = (RecyclerView) findViewById(R.id.my_recycler_view1);
        recyclerView1.setHasFixedSize(true);
        layoutManager1 = new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setAdapter(new MyAdapter(userData,1));
        recyclerView2 = (RecyclerView) findViewById(R.id.my_recycler_view2);
        recyclerView2.setHasFixedSize(true);
        layoutManager2 = new LinearLayoutManager(this);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setAdapter(new MyAdapter(userData,2));
        recyclerView3 = (RecyclerView) findViewById(R.id.my_recycler_view3);
        recyclerView3.setHasFixedSize(true);
        layoutManager3 = new LinearLayoutManager(this);
        recyclerView3.setLayoutManager(layoutManager3);
        recyclerView3.setAdapter(new MyAdapter(userData,3));



        menu_main=findViewById(R.id.menu_main);
        menu_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainPage", "Menu_MainClicked");
                Intent intent = new Intent(MainPage.this, MainPage.class);
                startActivity(intent);
            }
        });
        menu_calendar=findViewById(R.id.menu_calendar);
        menu_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainPage", "Menu_CalendarClicked");
                Intent intent = new Intent(MainPage.this, CalendarPage.class);
                startActivity(intent);
            }
        });
        menu_pill=findViewById(R.id.menu_pill);
        menu_pill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainPage", "Menu_PillClicked");
                Intent intent = new Intent(MainPage.this, PillPage.class);
                startActivity(intent);
            }
        });
        menu_setting=findViewById(R.id.menu_setting);
        menu_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainPage", "Menu_SettingClicked");
                Intent intent = new Intent(MainPage.this, SettingPage.class);
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
