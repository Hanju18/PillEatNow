package com.example.sensor1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private SensorManager sensorManager;
    private Sensor stepCountSensor;
    TextView tvStepCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvStepCount = (TextView)findViewById(R.id.tvStepCount);
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        stepCountSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(stepCountSensor ==null){
            toast.makeText(this,"NO Step Detect Sensor", Toast.LENGTH_SHORT).show();
        }
    }
    @Override// 실행시
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, stepCountSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override// 백그라운드 종료
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);

    }

    @Override//값 받아오기
    public void onAccuracyChanged(Sensor sensor, int accuracy){

    }
}