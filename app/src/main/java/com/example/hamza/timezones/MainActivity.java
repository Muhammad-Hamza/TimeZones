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
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import static com.example.hamza.timezones.R.string.timezone;

public class MainActivity extends FragmentActivity implements TimeFragment.onSomeEventListener {

    FloatingActionButton addTimeZone ;
    private long miliSeconds;
    private Date resultdate;
    SimpleDateFormat sdf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



       // ListView listView = (ListView) findViewById(R.id.list);
      //  listView.setAdapter();



        addTimeZone = (FloatingActionButton) findViewById(R.id.addtimezone);


        addTimeZone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().addToBackStack("");
                TimeFragment frgment = new TimeFragment();
                fragmentTransaction.add(R.id.frgmnt,frgment,"TimeFragment");
                fragmentTransaction.commit();






            }
        });


    }

    @Override
    public void someEvent(Date t,String n){

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frgmnt);

       TextView time = (TextView) findViewById(R.id.tzname);
        time.setText(n);
        TextView zoneName = (TextView) findViewById(R.id.tz);
        zoneName.setText(""+sdf.format(t));




    }
    private void  greenWichTime()
    {
       Calendar current = Calendar.getInstance();
        miliSeconds = current.getTimeInMillis();

        TimeZone tzCurrent = current.getTimeZone();
        int offset = tzCurrent.getRawOffset();
        if (tzCurrent.inDaylightTime(new Date())) {
            offset = offset + tzCurrent.getDSTSavings();

        }

        miliSeconds = miliSeconds - offset;

        resultdate = new Date(miliSeconds);
        System.out.println(sdf.format(resultdate));
    }




public void Arraylist(String time,String zone)
{
    ArrayList<TimeDisplay> timezones = new ArrayList<TimeDisplay>();

            timezones.add(new TimeDisplay("time","zone"));







}






}
