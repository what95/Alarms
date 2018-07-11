package com.example.magnusmain.alarms;

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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.magnusmain.alarms.R.layout.activity_main);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nyAlarmIntent();
            }
        });
        setUpRecycle();
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
}
