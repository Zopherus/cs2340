package cs2340.donationtracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;


import cs2340.donationtracker.model.Database;
import cs2340.donationtracker.model.Donation;
import cs2340.donationtracker.model.Location;
/**
 * @author      Eric
 * @version     1.0
 * @since       1.2
 */
public class ApplicationActivity extends Activity {

    /**
     * method for what happens when the application screen is open
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.application_screen);

        System.out.println("HELLO");

        final Button logoutButton = (Button) findViewById(R.id.logoutButton);
        final Button allDonationsButton = findViewById(R.id.AllDonationsButton);
        final Button mapButton = findViewById(R.id.MapButton);
        final ListView locationListView = (ListView) findViewById(R.id.LocationListView);
        final EditText locationSearchEditText = (EditText) findViewById(R.id.LocationSearchEditText);

        final ArrayList<String> locationNames = new ArrayList<>();
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("Locations");
        final ApplicationActivity activity = this;
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            /**
             * what happens when some data is changed on the application screen
             * @param dataSnapshot
             */
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
                    Location location = singleSnapshot.getValue(Location.class);
                    Database.locations.add(location);
                    locationNames.add(location.getName());
                    Object[] names = location.donations.keySet().toArray();
                    for (Object o : names) {
                        String name = o.toString();
                        HashMap<String, Object> map = (HashMap<String, Object>) location.donations.get(name);
                        Donation donation = new Donation(Double.parseDouble(map.get("value").toString()),
                                Database.locationLookup(map.get("location").toString()),
                                map.get("date").toString(), name, map.get("type").toString());
                        location.donationArrayList.add(donation);
                    }
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(activity,
                        android.R.layout.simple_list_item_1, locationNames);
                adapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
                locationListView.setAdapter(adapter);
            }

            /**
             * what happens when there is an error
             * @param databaseError
             */
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("canceled", "onCancelled", databaseError.toException());
            }
        });

        locationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * what happens when an item is clicked on
             * @param parent
             * @param view
             * @param position
             * @param id
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent loginIntent = new Intent(ApplicationActivity.this, LocationDetailActivity.class);
                loginIntent.putExtra("LOCATION_INDEX", position);
                Log.i("button test", "button pressed");
                startActivity(loginIntent);
            }
        });


        locationSearchEditText.addTextChangedListener(new TextWatcher() {

            /**
             * happens after the text is edited
             * @param s
             */
            @Override
            public void afterTextChanged(Editable s) {}

            /**
             * happens before the text is edited
             * @param s
             * @param start
             * @param count
             * @param after
             */
            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            /**
             * happens when the text changes
             * @param s
             * @param start
             * @param before
             * @param count
             */
            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                String str = locationSearchEditText.getText().toString();
                ArrayList<String> display = new ArrayList<>();
                for (String name : locationNames)
                {
                    if (name.toLowerCase().contains(str.toLowerCase()))
                        display.add(name);
                }

                if (display.size() == 0)
                    display.add("No locations with that name.");
                ArrayAdapter<String> adapter = new ArrayAdapter<>(activity,
                        android.R.layout.simple_list_item_1, display);
                adapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
                locationListView.setAdapter(adapter);
            }
        });
        logoutButton.setOnClickListener(new View.OnClickListener() {
            /**
             * what happens when the log out button is clicked
             * @param v
             */
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(ApplicationActivity.this, MainActivity.class);
                Log.i("button test", "button pressed");
                startActivity(loginIntent);
            }
        });
        allDonationsButton.setOnClickListener(new View.OnClickListener() {
            /**
             * when the all donations button is clicked
             * @param v
             */
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(ApplicationActivity.this,DonationListActivity.class);
                loginIntent.putExtra("LOCATION_INDEX", -1);
                Log.i("button test", "button pressed");
                startActivity(loginIntent);
            }
        });

        mapButton.setOnClickListener(new View.OnClickListener() {
            /**
             * happens when the map button is clicked
             * @param v
             */
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(ApplicationActivity.this,MapActivity.class);
                Log.i("button test", "button pressed");
                startActivity(loginIntent);
            }
        });
    }
}