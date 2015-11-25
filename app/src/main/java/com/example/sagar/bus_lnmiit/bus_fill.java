package com.example.sagar.bus_lnmiit;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;

public class bus_fill extends AppCompatActivity {

    EditText admin_bus_title,admin_driver,admin_route_from,admin_route_to;
    TimePicker timePicker;
    Button btn_submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_fill);

        admin_bus_title= (EditText)findViewById(R.id.admin_book_titletext);
        admin_driver = (EditText)findViewById(R.id.admin_book_authortext);
        admin_route_from = (EditText)findViewById(R.id.admin_book_pubtext);
        admin_route_to = (EditText)findViewById(R.id.admin_book_resbytext);
        timePicker=(TimePicker)findViewById(R.id.timePicker);
        btn_submit=(Button)findViewById(R.id.add_book_btn);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            public void onClick(View e) {

                ParseObject addBook = new ParseObject("libBusDet");
                addBook.put("bus_id", admin_bus_title.getText().toString());
                addBook.put("bus_driver", admin_driver.getText().toString());
                addBook.put("bus_route_from", admin_route_from.getText().toString());
                addBook.put("bus_route_to", admin_route_to.getText().toString());
               // addBook.put("time_hour",timePicker.getHour());
               // addBook.put("time_minute",timePicker.getMinute());
                addBook.saveInBackground();
                Context context = getApplicationContext();
                CharSequence text = "Data has been entered successfully";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                Intent intent = new Intent(bus_fill.this, admin.class);
                startActivity(intent);
            }
        });

    }
}
