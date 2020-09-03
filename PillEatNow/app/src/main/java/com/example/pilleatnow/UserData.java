package com.example.pilleatnow;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class UserData extends Application {
    int pills=3;
    PillData pill1=new PillData(0, R.drawable.pill1, "약1", 3, 20);
    PillData pill2=new PillData(1, R.drawable.pill2, "약2", 2, 10);
    PillData pill3=new PillData(2, R.drawable.pill3, "약3", 1, 3);

    List<PillData> pillData= new ArrayList<PillData>(){{
        add(pill1);
        add(pill2);
        add(pill3);
    }};

    List<PillData> morningP= new ArrayList<PillData>(){{
        add(pill1);
        add(pill2);
    }};
    List<PillData> lunchP= new ArrayList<PillData>(){{
        add(pill1);
    }};
    List<PillData> dinnerP= new ArrayList<PillData>(){{
        add(pill1);
        add(pill2);
        add(pill3);
    }};

    public void delPillData(int index) {
        Log.d("delPillData", "index: "+index);
        int id=pillData.get(index).getId();

        for(int i=0;i<morningP.size();i++)
            if(morningP.get(i).getId()==id)
                morningP.remove(i);

        for(int i=0;i<lunchP.size();i++)
            if(lunchP.get(i).getId()==id)
                lunchP.remove(i);

        for(int i=0;i<dinnerP.size();i++)
            if(dinnerP.get(i).getId()==id)
                dinnerP.remove(i);

        pillData.remove(index);
    }

    public void addPillData(int pill_char, String pill_name, int pill_dosage, int pill_stock) {
        PillData data=new PillData(pills, pill_char, pill_name, pill_dosage, pill_stock);
        pillData.add(data);
        if(data.getPill_dosage()>1) {
            if(data.getPill_dosage()>2) {
                lunchP.add(data);
            }
            morningP.add(data);
        }
        dinnerP.add(data);
        pills++;
    }

    public List<PillData> getPillData() {return pillData;}
}

