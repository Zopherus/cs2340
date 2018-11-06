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
import java.util.List;

import cs2340.donationtracker.model.Database;
import cs2340.donationtracker.model.Donation;
import cs2340.donationtracker.model.Location;

public class ApplicationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.application_screen);


        final Button logoutButton = (Button) findViewById(R.id.logoutButton);
        final Button allDonationsButton = findViewById(R.id.AllDonationsButton);
        final Button mapButton = findViewById(R.id.MapButton);
        final ListView locationListView = (ListView) findViewById(R.id.LocationListView);
        final EditText locationSearchEditText = (EditText) findViewById(R.id.LocationSearchEditText);

        final ArrayList<String> locationNames = new ArrayList<String>();
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("Locations");
        final ApplicationActivity activity = this;
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
                    Location location = singleSnapshot.getValue(Location.class);
                    Database.locations.add(location);
                    locationNames.add(location.getName());
                    Object[] names = location.donations.keySet().toArray();
                    for (int i = 0; i < names.length; i++) {
                        String name = names[i].toString();
                        HashMap<String, Object> map = (HashMap<String, Object>) location.donations.get(name);
                        Donation donation = new Donation(Double.parseDouble(map.get("value").toString()),
                                Database.locationLookup(map.get("location").toString()), map.get("date").toString(), name);
                        location.donationArrayList.add(donation);
                    }
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity,
                        android.R.layout.simple_list_item_1, locationNames);
                adapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
                locationListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("canceled", "onCancelled", databaseError.toException());
            }
        });

        locationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent loginIntent = new Intent(ApplicationActivity.this, LocationDetailActivity.class);
                loginIntent.putExtra("LOCATION_INDEX", position);
                Log.i("buttontest", "button pressed");
                startActivity(loginIntent);
            }
        });


        locationSearchEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

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
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity,
                        android.R.layout.simple_list_item_1, display);
                adapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
                locationListView.setAdapter(adapter);
            }
        });
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(ApplicationActivity.this, MainActivity.class);
                Log.i("buttontest", "button pressed");
                startActivity(loginIntent);
            }
        });
        allDonationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(ApplicationActivity.this,DonationListActivity.class);
                loginIntent.putExtra("LOCATION_INDEX", -1);
                Log.i("buttontest", "button pressed");
                startActivity(loginIntent);
            }
        });

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(ApplicationActivity.this,MapActivity.class);
                Log.i("buttontest", "button pressed");
                startActivity(loginIntent);
            }
        });
    }
}