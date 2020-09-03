package com.example.pilleatnow;

import java.io.Serializable;

public class PillData implements Serializable {
    private int pill_char;
    private String pill_name;
    private int pill_dosage;


    private int pill_stock;
    private boolean yesPressed=false;
    private boolean noPressed=false;
    private int id;

    public PillData(int id, int pill_char, String pill_name, int pill_dosage, int pill_stock) {
        setId(id);
        setPill_char(pill_char);
        setPill_name(pill_name);
        setPill_dosage(pill_dosage);
        setPill_stock(pill_stock);
    }

    //Getter & Setter
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public int getPill_stock() {
        return pill_stock;
    }
    public void setPill_stock(int pill_stock) {
        this.pill_stock = pill_stock;
    }
    public void addPill_stock(int addition) {
        pill_stock+=addition;
    }
    public void setYesPressedPressed() {
        yesPressed=!yesPressed;
    }
    public boolean getYesPressed() {
        return yesPressed;
    }
    public void setNoPressed() {
        noPressed=!noPressed;
    }
    public boolean getNoPressed() {
        return noPressed;
    }

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
