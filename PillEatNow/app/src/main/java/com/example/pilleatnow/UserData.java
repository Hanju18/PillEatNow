package com.example.pilleatnow;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class UserData extends Application {
    List<PillData> pillData= new ArrayList<>();
    boolean added=false;
    public void delPillData(int index) {pillData.remove(index);}
    public void addPillData(PillData data) {pillData.add(data);}
    public List<PillData> getPillData() {return pillData;}
}

