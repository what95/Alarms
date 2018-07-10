package com.example.magnusmain.alarms.model;

import java.util.ArrayList;

public class Alarmer {

    private Integer alarmTime;
    private Integer alarmMinutt;
    private String alarmNavn;
    private ArrayList<CharSequence> alarmDager;

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

    public void setAlarmNavn(String alarmNavn) {
        this.alarmNavn = alarmNavn;
    }

    public Integer getAlarmMinutt() {
        return alarmMinutt;
    }

    public void setAlarmMinutt(Integer alarmMinutt) {
        this.alarmMinutt = alarmMinutt;
    }

    public ArrayList<CharSequence> getAlarmDager() {
        return alarmDager;
    }

    public void setAlarmDager(ArrayList<CharSequence> alarmDager) {
        this.alarmDager = alarmDager;
    }

    public Integer getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Integer alarmTime) {
        this.alarmTime = alarmTime;
    }

    public static ArrayList<Alarmer> getAlarmListe() {
        return alarmListe;
    }

}

