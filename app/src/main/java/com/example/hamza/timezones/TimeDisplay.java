package com.example.hamza.timezones;

/**
 * Created by hamza on 1/1/2017.
 */

public class TimeDisplay {


    private String mClock;
    private String mDate;
    private String mRegion;


    public TimeDisplay(String c,String d,String r)
    {
        c=mClock;
        r=mRegion;
        d=mDate;
    }

    public String getClockTime()
    {
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
