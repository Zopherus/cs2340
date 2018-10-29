package cs2340.donationtracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import cs2340.donationtracker.model.Database;
import cs2340.donationtracker.model.Location;

public class ApplicationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.application_screen);


        final Button logoutButton = (Button) findViewById(R.id.logoutButton);
        final Spinner locationSpinner = (Spinner) findViewById(R.id.locationSpinner);
        locationSpinner.setPrompt("Locations");
        final ArrayList<String> locationNames = new ArrayList<String>();
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        final ApplicationActivity activity = this;
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
                    Location location = singleSnapshot.getValue(Location.class);
                    Database.locations.add(location);
                    locationNames.add(location.getName());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity,
                        android.R.layout.simple_spinner_item, locationNames);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                locationSpinner.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("canceled", "onCancelled", databaseError.toException());
            }
        });

        locationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            boolean first = true;
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!first) {
                    Intent loginIntent = new Intent(ApplicationActivity.this, LocationDetailActivity.class);
                    loginIntent.putExtra("LOCATION_INDEX", position);
                    Log.i("buttontest", "button pressed");
                    startActivity(loginIntent);
                }
                first = false;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(ApplicationActivity.this,MainActivity.class);
                Log.i("buttontest", "button pressed");
                startActivity(loginIntent);
            }
        });
    }
}
