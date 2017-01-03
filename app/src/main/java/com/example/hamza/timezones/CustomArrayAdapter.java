package com.example.hamza.timezones;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

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


                  listItemView = LayoutInflater.from(getContext()).inflate(R.layout.gridview_layout,parent,false);
              }

              TimeDisplay currentPosition = getItem(position);

              TextView clockText = (TextView) listItemView.findViewById(R.id.clock);
              clockText.setText(currentPosition.getClockTime());

              TextView date = (TextView) listItemView.findViewById(R.id.date);
              date.setText(currentPosition.getDate());

              TextView region = (TextView) listItemView.findViewById(R.id.name);
              region.setText(currentPosition.getTimeRegion());

              return listItemView;
            }

}
