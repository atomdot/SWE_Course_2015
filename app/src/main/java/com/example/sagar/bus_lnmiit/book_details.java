package com.example.sagar.bus_lnmiit;

import java.util.List;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class book_details extends AppCompatActivity {

    ListView listView3;
    List<ParseObject> ob;
    ArrayAdapter<String> adapter;
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        new RemoteDataTask().execute();
    }

    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(book_details.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Loading Buses");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            // Locate the class table named "Country" in Parse.com
            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(
                    "sagar");
            query.orderByAscending("createdAt");
            try {
                ob = query.find();
            } catch (ParseException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Locate the listview in listview_main.xml
            listView3 = (ListView) findViewById(R.id.listView3);
            // Pass the results into an ArrayAdapter
            adapter = new ArrayAdapter<String>(book_details.this,
                    R.layout.listview_item3);
            // Retrieve object "name" from Parse.com database
            for (ParseObject country : ob) {
                adapter.add((String) country.get("bus_info_user"));
            }
            // Binds the Adapter to the ListView
            listView3.setAdapter(adapter);
            // Close the progressdialog
            mProgressDialog.dismiss();
            // Capture button clicks on ListView items
            listView3.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // Send single item click data to SingleItemView Class
                    Intent i = new Intent(book_details.this,
                            SingleItemView3.class);
                    // Pass data "name" followed by the position
                    i.putExtra("bus_info_user", ob.get(position).getString("bus_info_user")
                            .toString() +" "+ob.get(position).getString("objectId")
                            .toString());
                    // Open SingleItemView.java Activity
                    startActivity(i);
                }
            });
        }
    }
}





