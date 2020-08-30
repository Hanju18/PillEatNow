package com.example.pilleatnow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class SettingPage extends AppCompatActivity {
    private ImageView menu_main, menu_calendar, menu_pill, menu_setting;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private String[] myDataset={"약1", "약2", "약3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_setting);
        Log.d("SettingPage", "OnCreate");

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

    public void addPill() {
        
    }
}
