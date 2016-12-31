package com.example.hamza.timezones;

import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends FragmentActivity {

    FloatingActionButton addTimeZone ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addTimeZone = (FloatingActionButton) findViewById(R.id.addTimezone);

        addTimeZone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                TimeFragment frgment = new TimeFragment();
                fragmentTransaction.add(R.id.fragmentArea,frgment,"TimeFragment");
                fragmentTransaction.commit();
                addTimeZone.setVisibility(View.GONE);
                findViewById(R.id.addText).setVisibility(View.GONE);

            }
        });
    }
}
