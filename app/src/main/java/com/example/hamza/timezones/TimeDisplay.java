package com.example.hamza.timezones;

import android.util.Log;

/**
 * Created by hamza on 1/1/2017.
 */

public class TimeDisplay {


    private String mClock;
    private String mDate;
    private String mRegion;


    public TimeDisplay(String c,String d,String r)
    {
       mClock= c;
        mDate = d;
        mRegion = r;


    }

    public String getClockTime()
    {
        Log.d("CLock",mClock);

        return mClock;
    }

    public String getDate()
    {
        return mDate;
    }
    public String getTimeRegion()
    {
        return mRegion;
    }


}
