package com.example.pilleatnow;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.List;

public class PillPage extends AppCompatActivity {
    private ImageView menu_main, menu_calendar, menu_pill, menu_setting;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ImageView add_pill;
    int pill_charX, pill_dosageX, pill_stockX;
    String pill_nameX;
    RadioGroup rgPill;
    RadioButton rbPill1, rbPill2, rbPill3;
    EditText etPillName, etPillDosage, etPillStock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_pill);
        Log.d("PillPage", "OnCreate");
        UserData userData = (UserData) getApplication();

        recyclerView = (RecyclerView) findViewById(R.id.pill_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter=new PillAdapter(userData, this);
        recyclerView.setAdapter(mAdapter);

        //약 추가
        add_pill=findViewById(R.id.add_pill);
        add_pill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LinearLayout dialog_layout =(LinearLayout) View.inflate(PillPage.this, R.layout.page_addpill, null);
                new AlertDialog.Builder(PillPage.this)
                        .setView(dialog_layout)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                rgPill=(RadioGroup) dialog_layout.findViewById(R.id.rgPill);
                                rbPill1=(RadioButton) dialog_layout.findViewById(R.id.rbPill1);
                                rbPill2=(RadioButton) dialog_layout.findViewById(R.id.rbPill2);
                                rbPill3=(RadioButton) dialog_layout.findViewById(R.id.rbPill3);
                                etPillName=(EditText) dialog_layout.findViewById(R.id.etPillName);
                                etPillDosage=(EditText) dialog_layout.findViewById(R.id.etPillDosage);
                                etPillStock=(EditText) dialog_layout.findViewById(R.id.etPillStock);

                                if(rbPill1.isChecked()) pill_charX=R.drawable.pill1;
                                else if(rbPill2.isChecked()) pill_charX=R.drawable.pill2;
                                else pill_charX=R.drawable.pill3;

                                if(rgPill.getCheckedRadioButtonId()==-1) {
                                    Toast.makeText(getApplicationContext(), "약 모양을 선택하세요.", Toast.LENGTH_SHORT).show();

                                }
                                else if(etPillName.getText().toString().equals("")){
                                    Toast.makeText(getApplicationContext(), "약 이름을 입력하세요.", Toast.LENGTH_SHORT).show();
                                }
                                else if(etPillStock.getText().toString().equals("")){
                                    Toast.makeText(getApplicationContext(), "약 재고를 입력하세요.", Toast.LENGTH_SHORT).show();
                                }
                                else {

                                    Log.d("PillPage addPill", "Pos");
                                    pill_nameX=etPillName.getText().toString();
                                    pill_stockX=Integer.parseInt(etPillStock.getText().toString());
                                    if(!etPillDosage.getText().toString().equals(""))
                                        pill_dosageX=Integer.parseInt(etPillDosage.getText().toString());
                                    else pill_dosageX=3;
                                    Toast.makeText(getApplicationContext(),
                                            "약 "+pill_nameX+"가 추가되었습니다.",
                                            Toast.LENGTH_SHORT).show();
                                    addPill(pill_charX, pill_nameX, pill_dosageX, pill_stockX);
                                    dialog.dismiss();
                                    Intent intent = getIntent();
                                    finish();
                                    startActivity(intent);
                                }


                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.d("PillPage addPill", "Neg");
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });



        menu_main=findViewById(R.id.menu_main);
        menu_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("PillPage", "Menu_MainClicked");
                Intent intent = new Intent(PillPage.this, MainPage.class);
                startActivity(intent);
            }
        });
        menu_calendar=findViewById(R.id.menu_calendar);
        menu_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("PillPage", "Menu_CalendarClicked");
                Intent intent = new Intent(PillPage.this, CalendarPage.class);
                startActivity(intent);
            }
        });
        menu_pill=findViewById(R.id.menu_pill);
        menu_pill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("PillPage", "Menu_PillClicked");
                Intent intent = new Intent(PillPage.this, PillPage.class);
                startActivity(intent);
            }
        });
        menu_setting=findViewById(R.id.menu_setting);
        menu_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("PillPage", "Menu_SettingClicked");
                Intent intent = new Intent(PillPage.this, SettingPage.class);
                startActivity(intent);
            }
        });
    }


    public void addPill(int pill_char, String pill_name, int pill_dosage, int pill_stock) {
        Log.d("PillPage addPill", "Char: "+pill_char+"\tName: "+pill_name+"\tDosage: "+pill_dosage);
        UserData userData = (UserData) getApplication();
        userData.addPillData(pill_char, pill_name, pill_dosage, pill_stock);
    }

    public void delPill(int index) {
        UserData userData = (UserData) getApplication();
        userData.delPillData(index);
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
