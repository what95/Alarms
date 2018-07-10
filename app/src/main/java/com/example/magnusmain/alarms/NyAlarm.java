package com.example.magnusmain.alarms;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.example.magnusmain.alarms.fragments.TimePicker;
import com.example.magnusmain.alarms.model.Alarmer;

import java.util.ArrayList;

public class NyAlarm extends AppCompatActivity {

    ArrayList<Integer> alarmTider;

    //Temp storage for alarm objekter som skal endres
    public static ArrayList<Alarmer> getAlarmTider = new ArrayList<>();
    public static ArrayList<Alarmer> getGetAlarmTider() {
        return getAlarmTider;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.magnusmain.alarms.R.layout.activity_ny_alarm);
        tomVisTid();
    }

    private void tomVisTid() {
        alarmTider = TimePicker.getTidValgtListe();
        alarmTider.clear();
        System.out.println("Tømmer alarmTider listen");
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
        if(alarmTider.isEmpty() || ((EditText) findViewById(R.id.alarmNavn)).getText().toString().equals("") || TimePicker.getTidValgtListe().isEmpty()){
            System.out.println("Noe returnerte en NULL");
            //Starting a new Intent
            Intent nyAlarm = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(nyAlarm);


        }
        else{
            ArrayList<String> alarmDager = new ArrayList<>();

            ConstraintLayout radioGroup = findViewById(R.id.dagersomervalgt);
            int count = radioGroup.getChildCount();
            System.out.println(count);
            ArrayList<CheckBox> listOfRadioButtons = new ArrayList<>();
            for (int i=0;i<count;i++) {
                View o = radioGroup.getChildAt(i);
                if (o instanceof CheckBox) {
                    if (((CheckBox) o).isChecked()) {
                        listOfRadioButtons.add((CheckBox) o);
                    }
                }
            }
            System.out.println("you have "+listOfRadioButtons.size()+" radio buttons");

            for(CheckBox e : listOfRadioButtons){
                alarmDager.add((String) e.getHint());
                System.out.println((String) e.getHint());
            }

            new Alarmer(((EditText) findViewById(R.id.alarmNavn)).getText().toString(), alarmDager, alarmTider.get(0), alarmTider.get(1));
            //Starting a new Intent
            Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(mainActivity);
        }


    }

}
