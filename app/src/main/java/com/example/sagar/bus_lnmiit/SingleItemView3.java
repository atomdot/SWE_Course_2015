package com.example.sagar.bus_lnmiit;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;


public class SingleItemView3 extends AppCompatActivity {

    TextView txtname;
    TextView txt1;

    String bus_info_user;
    String[] detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_item_view3);


        Intent i = getIntent();

        bus_info_user = i.getStringExtra("bus_info");
        detail= bus_info_user.split(" ");

        txtname = (TextView) findViewById(R.id.bus_info_user);
        txt1 = (TextView) findViewById(R.id.time);

        txtname.setText(detail[0]);
        txt1.setText(detail[1]);
    }
}
