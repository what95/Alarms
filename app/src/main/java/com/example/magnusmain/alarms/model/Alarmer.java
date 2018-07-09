package com.example.magnusmain.alarms.model;

import java.util.ArrayList;

public class Alarmer {

    private Integer alarmTime;
    private Integer alarmMinutt;
    private String alarmNavn;
    private ArrayList<Integer> alarmDager;

    private static ArrayList<Alarmer> alarmListe = new ArrayList<>();

    //her lager vi alarm objekter
    public Alarmer(String alarmNavn, ArrayList<Integer> alarmDager, int alarmTime, int alarmMinutt) {
        System.out.println("Lager en Alarm objekt");
        this.alarmNavn = alarmNavn;
        this.alarmDager = alarmDager;
        this.alarmTime = alarmTime;
        this.alarmMinutt = alarmMinutt;
        alarmListe.add(this);
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

    public ArrayList<Integer> getAlarmDager() {
        return alarmDager;
    }

    public void setAlarmDager(ArrayList<Integer> alarmDager) {
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

