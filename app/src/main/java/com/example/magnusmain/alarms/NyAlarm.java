package com.example.magnusmain.alarms;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.example.magnusmain.alarms.fragments.TimePicker;
import com.example.magnusmain.alarms.model.Alarmer;

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
        TextView visTidSomErValgt = findViewById(R.id.tidValgVisning);
        try{
            String tempText = alarmTider.get(0) + " : " + (alarmTider.get(1) < 10 ? "0" : "") + alarmTider.get(1);
            visTidSomErValgt.setText(tempText);
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println();
        }

    }
    //Lag en ny alarm
    public void lagAlarm(View v){
        if(alarmTider.isEmpty() || ((EditText) findViewById(R.id.alarmNavn)).getText() == null || TimePicker.getTidValgtListe().isEmpty()){
            System.out.println("Noe returnerte en NULL");
            //Starting a new Intent
            Intent nyAlarm = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(nyAlarm);


        }
        else{
            new Alarmer(((EditText) findViewById(R.id.alarmNavn)).getText().toString(), TimePicker.getTidValgtListe(), alarmTider.get(0), alarmTider.get(1));
            //Starting a new Intent
            Intent nyAlarm = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(nyAlarm);
        }


    }

}
