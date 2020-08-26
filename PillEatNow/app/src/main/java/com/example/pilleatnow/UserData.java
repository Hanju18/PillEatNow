package com.example.pilleatnow;

import java.io.Serializable;

public class UserData implements Serializable {
    private int pill_char;
    private String pill_name;
    private String pill_dosage;

    public int getPill_char() {
        return pill_char;
    }

    public void setPill_char(int pill_char) {
        this.pill_char = pill_char;
    }

    public String getPill_name() {
        return pill_name;
    }

    public void setPill_name(String pill_name) {
        this.pill_name = pill_name;
    }

    public String getPill_dosage() {
        return pill_dosage;
    }

    public void setPill_dosage(String pill_dosage) {
        this.pill_dosage = pill_dosage;
    }
}
