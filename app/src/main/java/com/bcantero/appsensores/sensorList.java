package com.bcantero.appsensores;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

public class sensorList extends AppCompatActivity {

    private TextView lblSensores;

    private SensorManager sensorManager;
    private List<Sensor> sensores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);

        lblSensores = (TextView) findViewById(R.id.lbl_sensorList);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        sensores = sensorManager.getSensorList(Sensor.TYPE_ALL);

        int i = 1;
        for(Iterator<Sensor> it = sensores.iterator(); it.hasNext(); i++){
            Sensor sensor = it.next();
            lblSensores.append(String.format("%d: %s, %d , %s\n", i, sensor.getName(), sensor.getType(), sensor.getVendor() ));
        }

    }
}