package com.example.hamza.timezones;

import android.app.Activity;
import android.graphics.Color;
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
    SimpleDateFormat clock = new SimpleDateFormat("hh:mm a");
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    ArrayList<TimeDisplay> timeList = new ArrayList<TimeDisplay>();







//ArrayList Method using to get the time,date,and region with respect to every id and add it to the list

    public void arrayList(String c,String d,String n)
    {

        timeList.add(new TimeDisplay(c,d,n));

        ;

    }



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
       // greenWichTime();

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
        String currentName = tzCurrent.getDisplayName() ;

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

        String time = clock.format(cal.getTime());
        String currentDate = date.format(cal.getTime());

        arrayList(time,currentDate,currentName);

    }

public void getTime(String id)
{
    Calendar current = Calendar.getInstance();
    TimeZone tzCurrent = current.getTimeZone();
    String currentName = tzCurrent.getDisplayName() ;


    TimeZone tz = TimeZone.getTimeZone(id);
    String timeZoneName = tz.getDisplayName();


    if(timeZoneName == currentName)
    {
        greenWichTime();

    }
    else {
        Log.d("working","fine");

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
    }
    //


}






}
