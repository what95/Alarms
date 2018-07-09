package com.example.magnusmain.alarms.fragments;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import com.example.magnusmain.alarms.NyAlarm;
import java.util.ArrayList;
import java.util.Calendar;


public class TimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    public static ArrayList<Integer> tidValgtListe = new ArrayList<Integer>();

    public TimePicker() {
        // Required empty public constructor
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker

        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
        tidValgtListe.clear();
        tidValgtListe.add(hourOfDay);
        tidValgtListe.add(minute);

    }

    //getter for tidValgtListe
    public static ArrayList<Integer> getTidValgtListe() {
        return tidValgtListe;
    }
}
