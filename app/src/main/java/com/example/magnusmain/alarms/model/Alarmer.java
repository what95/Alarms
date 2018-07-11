package com.example.magnusmain.alarms.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Alarmer implements Serializable {

    private final Integer alarmTime;
    private final Integer alarmMinutt;
    private final String alarmNavn;
    private final ArrayList<CharSequence> alarmDager;

    private static ArrayList<Alarmer> alarmListe = new ArrayList<>();

    //her lager vi alarm objekter
    public Alarmer(String alarmNavn, ArrayList<CharSequence> alarmDager, int alarmTime, int alarmMinutt) {
        System.out.println("Lager en Alarm objekt");
        this.alarmNavn = alarmNavn;
        this.alarmDager = alarmDager;
        this.alarmTime = alarmTime;
        this.alarmMinutt = alarmMinutt;
        alarmListe.add(this);
        System.out.println("Det er: " + alarmListe.size() + " alarmer i listen");
    }

    public String getAlarmNavn() {
        return alarmNavn;
    }

    public Integer getAlarmMinutt() {
        return alarmMinutt;
    }

    public ArrayList<CharSequence> getAlarmDager() {
        return alarmDager;
    }

    public Integer getAlarmTime() {
        return alarmTime;
    }

    public static ArrayList<Alarmer> getAlarmListe() {
        return alarmListe;
    }

}

