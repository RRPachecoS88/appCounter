package com.example.appcounter;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private SensorManager sm;
    private Sensor s;
    private SensorEventListener evento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sm=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if(s==null){
            finish();
        }
        evento = new SensorEventListener(){
            @Override
            public void onSensorChanged(SensorEvent event){
                System.out.println("X= "+event.values[0]);
                System.out.println("Y= "+event.values[1]);
                System.out.println("Z= "+event.values[2]);

            }
            @Override
            public void onAccuracyChanged(Sensor sensor,int acurracy){

            }

        };
        sm.registerListener(evento,s,SensorManager.SENSOR_DELAY_NORMAL);
    }
}