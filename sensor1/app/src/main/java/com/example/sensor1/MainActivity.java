package com.example.sensor1;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.SENSOR_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

/**
 * A simple {@link Fragment} subclass.
 */

public class PedometerFragment extends Fragment implements SensorEventListener{

    TextView mwalknum;
    //현재 걸음 수
    private int mSteps = 0;
    //리스너가 등록되고 난 후의 step count
    private int mCounterSteps = 0;


    private SensorManager sensorManager;
    private Sensor stepCountSensor;


    private View view;
    private String toast;


    public PedometerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_main, container, false);

        //센서 연결[걸음수 센서를 이용한 흔듬 감지]
        sensorManager = (SensorManager) getActivity().getSystemService(SENSOR_SERVICE);
        stepCountSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

        if (stepCountSensor == null) {
            Toast.makeText(getContext(),"No Step Detect Sensor", Toast.LENGTH_SHORT).show();
        }

        while(0<=mSteps) {
            if(mSteps<1500) {
                // 0걸음에서의 이미지 출력하는 것 추가
            }
            break;
            }

        while(1500<=mSteps) {
            if(mSteps<3000) {
                // 1500걸음에서의 이미지 출력하는 것 추가
            }
            break;
            }

        while(3000<=mSteps) {
            if(mSteps<5000) {
                // 3000걸음에서의 이미지 출력하는 것 추가
            }
            break;
        }

        while(5000<=mSteps) {
            if(mSteps<10000) {
                // 5000걸음에서의 이미지 출력하는 것 추가
            }
            break;
        }

        if(mSteps>=10000){
            //10000걸음에서의 이미지 출력하는 것 추가
        }
        TextView textView;
        textView = (TextView)findViewById(R.id.textView2);
//findView가 됐다 안됐다 한다.....
        Log.d(this.getClass().getName(), (String) textView.getText());
        textView.setText(mSteps+"걸음 걸었어");
//Toast 문제 해결하고 나서 각각 마다 Toast 넣을 수 있으면 좋겠당
        return view;
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_STEP_COUNTER) {

            if (mCounterSteps < 1) {
                // initial value
                mCounterSteps = (int) event.values[0];
            }
            mSteps = (int) event.values[0];



            Log.i("log: ", "New step detected by STEP_COUNTER sensor. Total step count: " + mSteps);
        }

    }


    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}