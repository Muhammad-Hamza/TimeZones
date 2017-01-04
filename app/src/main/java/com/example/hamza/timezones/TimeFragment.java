package com.example.hamza.timezones;

import android.app.Activity;
import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import java.util.GregorianCalendar;
import android.net.Uri;
import java.util.Calendar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;


public class TimeFragment extends Fragment  {

    private long miliSeconds;
    private Date resultDate;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm a");


    public interface onSomeEventListener {

        public void someEvent(String s);
    }
onSomeEventListener someEventListener;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);



        try {
            someEventListener = (onSomeEventListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement onSomeEventListener");
        }
    }

AutoCompleteTextView countries;
    Button addButton;
    String[] allCountries = TimeZone.getAvailableIDs();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_time, container, false);

        //Fetching IDS
        countries = (AutoCompleteTextView) view.findViewById(R.id.countryauto);
        addButton = (Button) view.findViewById(R.id.addbutton);


        countries.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.select_dialog_item,allCountries));



        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


              final String selectedregion = countries.getText().toString();

               someEventListener.someEvent(selectedregion);
                getActivity().onBackPressed();

            }
        });





        return view;
    }


}