package com.bibek.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class AccelerometerSensor extends AppCompatActivity {
      TextView tvList;
    SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelermeter_sensor);
        tvList = findViewById(R.id.tvList);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        SensorEventListener listen = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float[] values = event.values;
                String xAxis = "X:" +values[0];
                String yAxis = "y:" +values[1];
                String zAxis = "z:" +values[2];
                tvList.setText(xAxis+""+ yAxis+ ""+ zAxis);

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
