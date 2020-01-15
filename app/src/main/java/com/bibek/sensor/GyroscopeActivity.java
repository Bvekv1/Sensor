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
    TextView tvResult;
    float first, second, result;
    EditText etFirst, etSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);
        setTitle(" Gyro Sensor");

        tvResult = findViewById(R.id.tvResult);
        etFirst = findViewById(R.id.etFirst);
        etSecond = findViewById(R.id.etSecond);
//
//        first = Float.parseFloat(etFirst.getText().toString());
//        second = Float.parseFloat(etSecond.getText().toString());

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        SensorEventListener listen = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {


                if (event.values[1] < 0) {

                    result = Float.parseFloat(etFirst.getText().toString()) + Float.parseFloat(etSecond.getText().toString());
                    tvResult.setText(Float.toString(result));
                } else if (event.values[1] > 0) {
                    result = Float.parseFloat(etFirst.getText().toString()) - Float.parseFloat(etSecond.getText().toString());
                    tvResult.setText(Float.toString(result));
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
        };
        if (sensor != null) {
            sensorManager.registerListener(listen, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            Toast.makeText(this, "No sensor", Toast.LENGTH_SHORT).show();
        }
    }
}
