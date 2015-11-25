package com.example.sagar.bus_lnmiit;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

public class SingleItemView extends AppCompatActivity {

    TextView txtname;
    TextView txt1;
    TextView txt2;
    TextView txt3;


    String bus_id;
    String bus_driver;
    String bus_from;
    String bus_to;


    String[] details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_item_view);

        setContentView(R.layout.activity_single_item_view);

        // Retrieve data from MainActivity on item click event
        Intent i = getIntent();

        // Get the name
        bus_id = i.getStringExtra("bus_id");
        details = bus_id.split(" ");

        // Locate the TextView in singleitemview.xml
        txtname = (TextView) findViewById(R.id.bus_id);
        txt1 = (TextView) findViewById(R.id.bus_driver);
        txt2 = (TextView) findViewById(R.id.route_from);
        txt3 = (TextView) findViewById(R.id.route_to);

        // Load the text into the TextView
        txtname.setText(details[0]);
        txt1.setText(details[1]);
        txt2.setText(details[2]);
        txt3.setText(details[3]);

    }
}
