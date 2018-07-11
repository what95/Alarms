package com.example.magnusmain.alarms;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import com.example.magnusmain.alarms.adapter.NotatRecycleAdapter;
import com.example.magnusmain.alarms.model.Alarmer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private static boolean sBool = true;
static Context obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.magnusmain.alarms.R.layout.activity_main);
        obj = this;
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    lagreStuff();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                nyAlarmIntent();
            }
        });
        setUpRecycle();
        while (sBool){
            try {
                leseLagret();
            } catch (IOException e) {
                e.printStackTrace();
            }
            sBool = false;
        }
        try {
            lagreStuff();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }

    }

    private void setUpRecycle(){
        RecyclerView mRecyclerView = findViewById(R.id.recycleViewet);
        NotatRecycleAdapter adapter = new NotatRecycleAdapter(this);
        mRecyclerView.setAdapter(adapter);
        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(this);
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLinearLayoutManagerVertical);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.example.magnusmain.alarms.R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == com.example.magnusmain.alarms.R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void nyAlarmIntent(){
        //Starting a new Intent
        Intent nyAlarm = new Intent(getApplicationContext(), NyAlarm.class);
        startActivity(nyAlarm);
    }

    public static void lagreStuff() throws IOException {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(
                    new FileOutputStream(obj.getFilesDir() +"/alarmer.ser")
            );
            System.out.println("Lagret myarray");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert out != null;
        out.writeObject(Alarmer.getAlarmListe());
        try {
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.close();
    }

    private void leseLagret() throws IOException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(getFilesDir() +"/alarmer.ser"));
        try {
            ArrayList<Alarmer> tempArray = (ArrayList) in.readObject();
            for(Alarmer alarm: tempArray){
                Alarmer.getAlarmListe().add(alarm);
            }
            System.out.println("Henter lagret");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        in.close();
    }
}
