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

public class PillPage extends AppCompatActivity {
    private ImageView menu_main, menu_calendar, menu_pill, menu_setting;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private String[] myDataset={"약1", "약2", "약3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_pill);
        Log.d("PillPage", "OnCreate");

//        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
//        recyclerView.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        mAdapter = new MyAdapter(myDataset);
//        recyclerView.setAdapter(mAdapter);

        menu_main=findViewById(R.id.menu_main);
        menu_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("PillPage", "Menu_MainClicked");
                Intent intent = new Intent(PillPage.this, MainPage.class);
                startActivity(intent);
            }
        });

        menu_calendar=findViewById(R.id.menu_calendar);
        menu_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("PillPage", "Menu_CalendarClicked");
                Intent intent = new Intent(PillPage.this, CalendarPage.class);
                startActivity(intent);
            }
        });
        menu_pill=findViewById(R.id.menu_pill);
        menu_pill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("PillPage", "Menu_PillClicked");
                Intent intent = new Intent(PillPage.this, PillPage.class);
                startActivity(intent);
            }
        });
        menu_setting=findViewById(R.id.menu_setting);
        menu_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("PillPage", "Menu_SettingClicked");
                Intent intent = new Intent(PillPage.this, SettingPage.class);
                startActivity(intent);
            }
        });

    }

    public void addPill() {
        
    }
}
