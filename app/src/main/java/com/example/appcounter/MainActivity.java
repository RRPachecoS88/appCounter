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
                //System.out.println("X= "+event.values[0]);
               // System.out.println("Y= "+event.values[1]);
               // System.out.println("Z= "+event.values[2]);
                float A=event.values[0];
                float B=event.values[1];
                float C=event.values[2];
                if((A>-1.24  && A<2.59) && (B>3.11 && B<9.75)&&(C>1 && C<8.55)){
                    System.out.println("Esta de pie");
                }else if((A>-3.57  && A<1) && (B>0.31 && B<9.75)&&(C>-2.6 && C<9.85)){
                    System.out.println("Esta con brazos extendidos");
                }else if((A>-9.67  && A<8.95) && (B>-5.68 && B<0.79)&&(C>-0.79 && C<9.57)){
                    System.out.println("Esta con brazo flexionados ");
                }else{

                }
                /*while((A>-1.24  && A<2.59) && (B>3.11 && B<9.75)&&(C>1 && C<8.55)){
                    System.out.println("Esta de pie");
                }
                while((A>-3.57  && A<1) && (B>0.31 && B<9.75)&&(C>-2.6 && C<9.85)){
                    System.out.println("Esta con brazos extendidos");
                }
                while((A>-9.67  && A<8.95) && (B>-5.68 && B<0.79)&&(C>-0.79 && C<9.57)){
                    System.out.println("Esta con brazo flexionados ");
                }*/


            }
            @Override
            public void onAccuracyChanged(Sensor sensor,int acurracy){

            }

        };
        sm.registerListener(evento,s,SensorManager.SENSOR_DELAY_NORMAL);
    }
}