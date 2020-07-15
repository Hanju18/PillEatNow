package com.example.pilleatnowapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Calendar;

public class MainActivity<materialCalendarView, MaterialCalendarView> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    MaterialCalendarView materialCalendarView = findViewById(R.id.calendarView);
    materialCalendarView.setSelectedDate(CalendarDay.today());



}
