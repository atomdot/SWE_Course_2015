package com.example.sagar.bus_lnmiit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

import com.parse.ParseObject;
import com.parse.ParseQuery;

public class SingleItemView extends AppCompatActivity {

    TextView txtname;
    String bus_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_item_view);

        setContentView(R.layout.activity_single_item_view);

        // Retrieve data from MainActivity on item click event
        Intent i = getIntent();

        // Get the name
        bus_id = i.getStringExtra("bus_id");
        ParseQuery<ParseObject> query = ParseQuery.getQuery("libBusDet");

        // Locate the TextView in singleitemview.xml
        txtname = (TextView) findViewById(R.id.bus_id);

        // Load the text into the TextView
        txtname.setText(bus_id);

    }
}
