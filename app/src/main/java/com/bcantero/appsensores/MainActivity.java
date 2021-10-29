package com.bcantero.appsensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SensorEventListener {

    private Button btn_sensorList;

    private Sensor accelerometerSensor1, lightSensor, gravitySensor, magneticSensor;
    private SensorManager sensorManager;

    private TextView lbl_acelerometroValue, lbl_lightSensorValue, lbl_gravitySensorValue, lbl_magneticSensorValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_sensorList = (Button) findViewById(R.id.btn_sensorList);
        btn_sensorList.setOnClickListener(this);

        lbl_acelerometroValue = (TextView) findViewById(R.id.lbl_acelerometroValue);
        lbl_lightSensorValue = (TextView) findViewById(R.id.lbl_lightSensorValue);
        lbl_gravitySensorValue = (TextView) findViewById(R.id.lbl_gravitySensorValue);
        lbl_magneticSensorValue = (TextView) findViewById(R.id.lbl_magneticSensorValue);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        accelerometerSensor1 = (Sensor) sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        lightSensor = (Sensor) sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        gravitySensor = (Sensor) sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        magneticSensor = (Sensor) sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        sensorManager.registerListener(this, accelerometerSensor1,SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, lightSensor,SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, gravitySensor,SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, magneticSensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onClick(View v) {
        if(btn_sensorList.isClickable()){
            Intent intent =  new Intent(this,sensorList.class);
            startActivity(intent);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        switch (sensorEvent.sensor.getType()){
            case Sensor.TYPE_ACCELEROMETER:
                lbl_acelerometroValue.setText(String.valueOf(sensorEvent.values[0]));
                break;
            case Sensor.TYPE_LIGHT:
                lbl_lightSensorValue.setText(String.valueOf(sensorEvent.values[0]));
                break;
            case Sensor.TYPE_GRAVITY:
                lbl_gravitySensorValue.setText(String.valueOf(sensorEvent.values[0]));
                break;
            case Sensor.TYPE_MAGNETIC_FIELD:
                lbl_magneticSensorValue.setText(String.valueOf(sensorEvent.values[0]));
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}