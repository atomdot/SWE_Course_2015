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



public class SingleItemView2 extends AppCompatActivity {

    TextView txtname;
    TextView txt1;
    TextView txt2;
    TextView txt3;
    Button book;
    String bus_info;
    String[] detail;
    int avail;
    int booked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_item_view2);

        Intent i = getIntent();

        bus_info = i.getStringExtra("bus_info");
        detail= bus_info.split(" ");

        txtname = (TextView) findViewById(R.id.bus_info);
        txt1 = (TextView) findViewById(R.id.time);
        txt2 = (TextView) findViewById(R.id.seats);
        txt3 = (TextView) findViewById(R.id.booked);

        txtname.setText(detail[0]);
        txt1.setText(detail[1]);
        txt2.setText(detail[2]);
        txt3.setText(detail[3]);

        book=(Button)findViewById(R.id.user_book);

        book.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            public void onClick(View e) {
                avail=Integer.valueOf(detail[2]);
                booked=Integer.valueOf(detail[3]);

                ParseObject addBook = new ParseObject("sagar");
                addBook.put("bus_info_user", detail[0]);

                ParseObject refresh = new ParseObject("libBusDet");
                refresh.put("seats", avail);
                refresh.put("seats_booked", booked );

                // addBook.put("time_hour",timePicker.getHour());
                // addBook.put("time_minute",timePicker.getMinute());
                addBook.saveInBackground();
                Context context = getApplicationContext();
                CharSequence text = "You have booked the app. Check in the Booking part";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                Intent intent = new Intent(SingleItemView2.this, user.class);
                startActivity(intent);
            }
        });
    }
}
