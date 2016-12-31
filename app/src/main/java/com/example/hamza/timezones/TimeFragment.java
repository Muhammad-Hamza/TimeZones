package com.example.hamza.timezones;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;


public class TimeFragment extends Fragment {

AutoCompleteTextView countries;
    Button addButton;
    String[] allCountries = {"Pakistan","Germany","England","Indonesia","Australia","India","China","United Arab Emirates"
    ,"Russia","Iran"};
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
            }
        });





        return view;
    }

}