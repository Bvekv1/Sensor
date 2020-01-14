package com.bibek.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class GyroscopeActivity extends AppCompatActivity {
    SensorManager sensorManager;
    TextView  tvResult;
    Integer first, second, result,bibek;
    EditText etFirst, etSecond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);
        setTitle(" Gyro Sensor");

   tvResult = findViewById(R.id.tvResult);


        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        SensorEventListener listen = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if (event.values[1] < 0) {
                    first = Integer.parseInt(etFirst.getText().toString());
                    second = Integer.parseInt(etSecond.getText().toString());
                    result = first + second;
                    tvResult.setText(result);
                    //tvResult.setText("Left");

                } else if (event.values[1] > 0) {
                    first = Integer.parseInt(etFirst.getText().toString());
                second = Integer.parseInt(etSecond.getText().toString());
                    bibek = first - second;
                    tvResult.setText(bibek);
                    //tvResult.setText("Left");
                }

            };


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
