package com.example.hamza.timezones;


import android.content.Context;


import java.util.TimeZone;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;


public class TimeFragment extends Fragment {


    AutoCompleteTextView countries;
    Button addButton;
    String[] allCountries = TimeZone.getAvailableIDs();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_time, container, false);

        //Fetching IDS
        countries = (AutoCompleteTextView) view.findViewById(R.id.countryauto);
        addButton = (Button) view.findViewById(R.id.addbutton);


        countries.setTextColor(Color.BLACK);
        countries.setAdapter(new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.select_dialog_item, allCountries));


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


    public interface onSomeEventListener {

        public void someEvent(String s);
    }


}