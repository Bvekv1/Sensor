package com.bibek.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
     Button btnList, btnAcc, btnProximity, btnGyroscope;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnList = findViewById(R.id.btnList);
        btnAcc = findViewById(R.id.btnAcc);
        btnProximity = findViewById(R.id.btnProximity);
        btnGyroscope = findViewById(R.id.btnGyroscope);


        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SensorActivity.class);
                startActivity(intent);

            }
        });
        btnAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AccelerometerSensor.class);
                startActivity(intent);

            }
        });
        btnGyroscope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GyroscopeActivity.class);
                startActivity(intent);

            }
        });
        btnProximity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProximityActivity.class);
                startActivity(intent);

            }
        });
    }
}
