package com.example.pilleatnow;

import java.io.Serializable;

public class PillData implements Serializable {
    private int pill_char;
    private String pill_name;
    private int pill_dosage;

    public PillData(int pill_char, String pill_name, int pill_dosage) {
        setPill_char(pill_char);
        setPill_name(pill_name);
        setPill_dosage(pill_dosage);
    }

    //Getter & Setter
    public int getPill_char() { return pill_char; }

    public void setPill_char(int pill_char) {
        this.pill_char = pill_char;
    }

    public String getPill_name() { return pill_name; }

    public void setPill_name(String pill_name) {
        this.pill_name = pill_name;
    }

    public int getPill_dosage() {
        return pill_dosage;
    }

    public void setPill_dosage(int pill_dosage) {
        this.pill_dosage = pill_dosage;
    }
}
