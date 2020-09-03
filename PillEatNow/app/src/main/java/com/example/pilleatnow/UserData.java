package com.example.pilleatnow;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class UserData extends Application {
    int pills=3;
    PillData pill1=new PillData(R.drawable.pill1, "약1", 3);
    PillData pill2=new PillData(R.drawable.pill2, "약2", 2);
    PillData pill3=new PillData(R.drawable.pill3, "약3", 1);
    List<PillData> pillData= new ArrayList<PillData>(){{
        add(pill1);
        add(pill2);
        add(pill3);
    }};

    List<PillData> morningP= new ArrayList<PillData>(){{
        add(new PillData(R.drawable.pill1, "약1", 3));
        add(new PillData(R.drawable.pill2, "약2", 2));
    }};
    List<PillData> lunchP= new ArrayList<PillData>(){{
        add(new PillData(R.drawable.pill1, "약1", 3));
    }};
    List<PillData> dinnerP= new ArrayList<PillData>(){{
        add(new PillData(R.drawable.pill1, "약1", 3));
        add(new PillData(R.drawable.pill2, "약2", 2));
        add(new PillData(R.drawable.pill3, "약3", 1));
    }};

    public void delPillData(int index) {
        int id=pillData.get(index).getId();

        for(int i=0;i<morningP.size();i++)
            if(morningP.get(i).getId()==id)
                morningP.remove(i);

        for(int i=0;i<lunchP.size();i++)
            if(morningP.get(i).getId()==id)
                lunchP.remove(i);

        for(int i=0;i<dinnerP.size();i++)
            if(morningP.get(i).getId()==id)
                dinnerP.remove(i);

        pillData.remove(index);
    }

    public void addPillData(PillData data) {
        pillData.add(data);
        if(data.getPill_dosage()>1) {
            if(data.getPill_dosage()>2) {
                lunchP.add(data);
            }
            morningP.add(data);
        }
        dinnerP.add(data);
    }

    public List<PillData> getPillData() {return pillData;}
}

