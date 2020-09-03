package com.example.pilleatnow;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "OnCreate");
        start= findViewById(R.id.start);
        start.setClickable(true);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "StartClicked");
                Intent intent = new Intent(MainActivity.this, MainPage.class);
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
            public void onClick(DialogInterface dialog, int which) { }
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
