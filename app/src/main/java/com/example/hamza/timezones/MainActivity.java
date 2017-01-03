package com.example.hamza.timezones;

import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm a");


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
    public void someEvent(String s){

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frgmnt);
        getTime(s);
        greenWichTime();

/**
        int TimeZoneOffset = tz.getRawOffset()
                / (60 * 1000);
        int hrs = TimeZoneOffset / 60;
        int mins = TimeZoneOffset % 60;
       TextView time = (TextView) findViewById(R.id.tzname);
        time.setText(n);
       TextView zoneName = (TextView) findViewById(R.id.tz);
        zoneName.setText(t+" : GMT " + hrs + "."
                + mins);**/
     //   greenWichTime();



    }
   private void  greenWichTime()
    {
       Calendar current = Calendar.getInstance();
        miliSeconds = current.getTimeInMillis();

        TimeZone tzCurrent = current.getTimeZone();
        String CurrentTimeZoneName = tzCurrent.getID();
        Calendar calTZ = new GregorianCalendar(tzCurrent);
        calTZ.setTimeInMillis(new Date().getTime());
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, calTZ.get(Calendar.YEAR));
        cal.set(Calendar.MONTH, calTZ.get(Calendar.MONTH));
        cal.set(Calendar.DAY_OF_MONTH, calTZ.get(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, calTZ.get(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, calTZ.get(Calendar.MINUTE));
        cal.set(Calendar.SECOND, calTZ.get(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, calTZ.get(Calendar.MILLISECOND));

        String time = sdf.format(cal.getTime());
        TextView crrntTime = (TextView) findViewById(R.id.current);
        crrntTime.setText(CurrentTimeZoneName);
        Log.d("Time Test",time);
    }

public void getTime(String id)
{

    TimeZone tz = TimeZone.getTimeZone(id);
    if(tz == TimeZone.getDefault())
    {

    }
    String timeZoneName = tz.getDisplayName();
    Calendar calTZ = new GregorianCalendar(tz);
    calTZ.setTimeInMillis(new Date().getTime());
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.YEAR, calTZ.get(Calendar.YEAR));
    cal.set(Calendar.MONTH, calTZ.get(Calendar.MONTH));
    cal.set(Calendar.DAY_OF_MONTH, calTZ.get(Calendar.DAY_OF_MONTH));
    cal.set(Calendar.HOUR_OF_DAY, calTZ.get(Calendar.HOUR_OF_DAY));
    cal.set(Calendar.MINUTE, calTZ.get(Calendar.MINUTE));
    cal.set(Calendar.SECOND, calTZ.get(Calendar.SECOND));
    cal.set(Calendar.MILLISECOND, calTZ.get(Calendar.MILLISECOND));
    String time = sdf.format(cal.getTime());
    TextView tzname = (TextView) findViewById(R.id.tzname);
    tzname.setText(timeZoneName);
    TextView zoneName = (TextView) findViewById(R.id.tz);
    zoneName.setText(time);

    //


}







}
