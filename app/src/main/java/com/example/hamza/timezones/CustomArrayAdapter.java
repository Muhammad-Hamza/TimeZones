package com.example.hamza.timezones;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by hamza on 1/3/2017.
 */

public class CustomArrayAdapter extends ArrayAdapter<TimeDisplay> {



    public CustomArrayAdapter(Activity context, ArrayList<TimeDisplay> TimeDisplay) {
        super(context, 0, TimeDisplay);
    }

@Override
public View getView(int position, View convertView, ViewGroup parent)

          {
              View listItemView = convertView;
              if(listItemView == null){


                  listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_layout,parent,false);
              }

              TimeDisplay currentPosition = getItem(position);
              Calendar current = Calendar.getInstance();
              TimeZone tzCurrent = current.getTimeZone().getDefault();
              String currentName = tzCurrent.getDisplayName() ;


              TextView clockText = (TextView) listItemView.findViewById(R.id.clock);
              TextView date = (TextView) listItemView.findViewById(R.id.date);
              TextView region = (TextView) listItemView.findViewById(R.id.name);
              if (currentName == currentPosition.getTimeRegion())
              {
                  clockText.setTextColor((Color.parseColor("#B33A3A")));
                  date.setTextColor((Color.parseColor("#B33A3A")));
                  region.setTextColor((Color.parseColor("#B33A3A")));
              }
              clockText.setText(currentPosition.getClockTime());
              date.setText(currentPosition.getDate());
              region.setText(currentPosition.getTimeRegion());

              return listItemView;
            }

}
