package com.example.magnusmain.alarms.model;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.magnusmain.alarms.fragments.TimePicker;

import java.util.Calendar;

public class NyAlarm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.magnusmain.alarms.R.layout.activity_ny_alarm);
    }

    public void velgTid(View view) {
        DialogFragment newFragment  = new TimePicker();
        String tag = "ss";
        newFragment.show(getSupportFragmentManager(), tag);

    }


}
