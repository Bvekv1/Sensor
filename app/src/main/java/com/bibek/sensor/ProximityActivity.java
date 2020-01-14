package com.bibek.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ProximityActivity extends AppCompatActivity {
    SensorManager sensorManager;
    TextView tvPro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity);

         tvPro = findViewById(R.id.tvPro);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        SensorEventListener listen = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if (event.values[0] <= 4){
                    tvPro.setText("Object is near");

                } else
                    {
                        tvPro.setText("Object is far");


                }

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {









            }
        };
        if (sensor != null){
            sensorManager.registerListener(listen,sensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        else{
            Toast.makeText(this,"No sensor", Toast.LENGTH_SHORT).show();
        }
    }
}
