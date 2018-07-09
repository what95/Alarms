package com.example.magnusmain.alarms;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.magnusmain.alarms.fragments.TimePicker;
import java.util.ArrayList;

public class NyAlarm extends AppCompatActivity {

    ArrayList<Integer> alarmTider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.magnusmain.alarms.R.layout.activity_ny_alarm);
    }



    public void velgTid(View view) {

        DialogFragment newFragment  = new TimePicker();
        String tag = "timePicker";
        newFragment.show(getSupportFragmentManager(), tag);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        tidValgt();
    }

    public void tidValgt(){
        alarmTider = TimePicker.getTidValgtListe();
        TextView visTidSomErValgt = (TextView)findViewById(R.id.tidValgVisning);
        try{
            String tempText = alarmTider.get(0) + " " + alarmTider.get(1);
            visTidSomErValgt.setText(tempText);
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println();
        }

    }

}
