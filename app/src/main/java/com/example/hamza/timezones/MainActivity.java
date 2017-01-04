package com.example.hamza.timezones;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;


public class MainActivity extends FragmentActivity implements TimeFragment.onSomeEventListener {

    FloatingActionButton addTimeZone;
    SimpleDateFormat clock = new SimpleDateFormat("hh:mm a");
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    ArrayList<TimeDisplay> timeList = new ArrayList<TimeDisplay>();


//Add time method takes clock,date,region as input and add into arraylist

    public void addTime(String c, String d, String t) {
        timeList.add(new TimeDisplay(c, d, t));
    }


    //Get time method gets the time of the timezone id received
    public void getTime(String id) {
        TimeZone tz = TimeZone.getTimeZone(id);
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
        String time = clock.format(cal.getTime());
        String regionDate = date.format(cal.getTime());

        addTime(time, regionDate, timeZoneName);

        final CustomArrayAdapter timeZoneArrayAdatpter = new CustomArrayAdapter(this, timeList);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(timeZoneArrayAdatpter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, final int position, long id) {
                AlertDialog.Builder dialogBox = new AlertDialog.Builder(MainActivity.this);
                dialogBox.setTitle("Delete?");
                dialogBox.setMessage("Are you sure you want to delete ");
                dialogBox.setNegativeButton("Cancel", null);
                dialogBox.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        timeList.remove(position);
                        timeZoneArrayAdatpter.notifyDataSetChanged();
                    }
                });
                dialogBox.show();
            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //FAB onclick launches fragment

        addTimeZone = (FloatingActionButton) findViewById(R.id.addtimezone);
        addTimeZone.setEnabled(true);
        addTimeZone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().addToBackStack("");
                TimeFragment frgment = new TimeFragment();
                fragmentTransaction.replace(R.id.frgmnt, frgment, "TimeFragment");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


    }

    //Interface To communicate with fragment and receive the timezone id

    @Override
    public void someEvent(String s) {

        getTime(s);

    }


}
