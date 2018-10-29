package cs2340.donationtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cs2340.donationtracker.model.Database;
import cs2340.donationtracker.model.Location;

public class LocationDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_detail_screen);

        Bundle extra = getIntent().getExtras();
        final int position = extra.getInt("LOCATION_INDEX");
        Location location = Database.locations.get(position);
        final TextView locationNameText = (TextView) findViewById(R.id.locationNameText);
        final TextView locationTypeText = (TextView) findViewById(R.id.locationTypeText);
        final TextView locationLongitudeText = (TextView) findViewById(R.id.locationLongitudeText);
        final TextView locationLatitudeText = (TextView) findViewById(R.id.locationLatitudeText);
        final TextView locationAddressText = (TextView) findViewById(R.id.locationAddressText);
        final TextView locationPhoneNumberText = (TextView) findViewById(R.id.locationPhoneNumberText);
        final Button addDonationButton = (Button) findViewById(R.id.addDonationButton);
        final Button viewDonationsButton = (Button) findViewById(R.id.ViewDonationsButton);

        locationNameText.setText(location.getName());
        locationTypeText.setText(location.getType());
        locationLongitudeText.setText(Double.toString(location.getLongitude()));
        locationLatitudeText.setText(Double.toString(location.getLatitude()));
        locationAddressText.setText(location.getStreetAddress() + " " + location.getCity()
                + " " + location.getState() + " " + location.getZip());
        locationPhoneNumberText.setText(location.getPhone());



        addDonationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(LocationDetailActivity.this, AddDonationActivity.class);
                loginIntent.putExtra("LOCATION_INDEX", position);
                Log.i("buttontest", "button pressed");
                startActivity(loginIntent);
            }
        });

        viewDonationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(LocationDetailActivity.this, DonationListActivity.class);
                loginIntent.putExtra("LOCATION_INDEX", position);
                Log.i("buttontest", "button pressed");
                startActivity(loginIntent);
            }
        });
    }
}
