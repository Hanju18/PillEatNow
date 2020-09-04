package com.example.pilleatnow;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Executors;

public class CalendarPage extends AppCompatActivity {
    private ImageView menu_main, menu_calendar, menu_pill, menu_setting;
    private TextView pillX;
    private final OneDayDecorator oneDayDecorator=new OneDayDecorator();
    private SelectedDecorator selectedDecorator;
    MaterialCalendarView materialCalendarView;
    UserData userData=(UserData)getApplication();
    List<CalendarDay> result = new ArrayList<>();
    List<Integer> index=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_calendar);
        Log.d("CalendarPage", "OnCreate");
        userData=(UserData)getApplication();
        materialCalendarView=findViewById(R.id.calendarView);
        materialCalendarView.state().edit()
                .setFirstDayOfWeek(Calendar.SUNDAY)
                .setMinimumDate(CalendarDay.from(2017, 0, 1))
                .setMaximumDate(CalendarDay.from(2030, 11, 31))
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();
        materialCalendarView.addDecorators(
                new SundayDecorator(),
                new SaturdayDecorator(),
                oneDayDecorator);
        List<PillData> pill=userData.pillData;
        Calendar calendar=Calendar.getInstance();
        int addition=0;
        for(int i=0;i<pill.size();i++) {
            int stock=pill.get(i).getPill_stock();
            int dosage=pill.get(i).getPill_dosage();
            addition=stock/dosage;
            calendar.add(Calendar.DATE, addition);
            Log.d("Calendar", String.valueOf(addition));
            CalendarDay day=CalendarDay.from(calendar);
            result.add(day);
            index.add(i);
        }

        new ApiSimulator(result).executeOnExecutor(Executors.newSingleThreadExecutor());
        pillX=findViewById(R.id.pillX);
        List<CalendarDay> todays=new ArrayList<>();
        Calendar c= Calendar.getInstance();
        todays.add(CalendarDay.from(c));
        selectedDecorator=new SelectedDecorator(Color.RED, todays,CalendarPage.this);
        materialCalendarView.clearSelection();
        materialCalendarView.addDecorator(selectedDecorator);
        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                materialCalendarView.removeDecorator(selectedDecorator);
                pillX.setText("");
                List<PillData> pills=userData.pillData;
                for(int i=0;i<result.size();i++) {
                    if(result.get(i).equals(date)) {
                        pillX.setText(pills.get(i).getPill_name()+"가 떨어지는 날입니다.\n필요하다면 추가로 구매해주세요.");
                    }
                }
                materialCalendarView.clearSelection();
                List<CalendarDay> dates=new ArrayList<>();
                dates.add(date);
                selectedDecorator=new SelectedDecorator(Color.RED, dates,CalendarPage.this);
                materialCalendarView.addDecorator(selectedDecorator);
            }
        });




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

    private class ApiSimulator extends AsyncTask<Void, Void, List<CalendarDay>> {

        List<CalendarDay> Time_Result;

        ApiSimulator(List<CalendarDay> Time_Result){
            this.Time_Result = Time_Result;
        }

        @Override
        protected List<CalendarDay> doInBackground(@NonNull Void... voids) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Time_Result;
        }

        @Override
        protected void onPostExecute(@NonNull List<CalendarDay> calendarDays) {
            super.onPostExecute(calendarDays);

            if (isFinishing()) {
                return;
            }

            materialCalendarView.addDecorator(new EventDecorator(Color.RED, calendarDays,CalendarPage.this));
        }
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
