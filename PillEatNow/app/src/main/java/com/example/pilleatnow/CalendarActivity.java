package com.example.pilleatnow;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

public class CalendarActivity<materialCalendarView> extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_calendar);

        MaterialCalendarView materialCalendarView;

        materialCalendarView = findViewById(R.id.calendarView);

        //////주말 색상 추가 ////
        materialCalendarView.addDecorators(
                new SundayDecorator(),
                new SaturdayDecorator()
        );

//        ///클릭한 날짜 표시하기/////
//        materialCalendarView.addDecorators(
//                new MySelectorDecorator(this)
//        );

        //오늘 날짜 표시하기
        OneDayDecorator oneDayDecorator = new OneDayDecorator();

        materialCalendarView.addDecorators(
                oneDayDecorator
        );
    }




}
