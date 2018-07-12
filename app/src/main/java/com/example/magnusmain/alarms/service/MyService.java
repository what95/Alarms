package com.example.magnusmain.alarms.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {
    public int counter=0;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //TODO do something useful
        System.out.println("onStartCommand Kjøres");
        startTimer();
        return Service.START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    Timer timer = new Timer();
    private TimerTask timerTask;
    public void startTimer() {
        //set a new Timer
        Timer timer = new Timer();

        //initialize the TimerTask's job
        initializeTimerTask();
        //schedule the timer, to wake up every 1 second
        timer.schedule(timerTask, 1000, 1000); //
    }

    /**
     * it sets the timer to print the counter every x seconds
     */
    public void initializeTimerTask() {
        timerTask = new TimerTask() {
            public void run() {
                System.out.println("in timer ++++  "+ (counter++));
                if(counter>10){
                    System.out.println("Stopper timer");
                    timer.cancel();
                    timerTask.cancel();
                }
            }

        };

    }
}
