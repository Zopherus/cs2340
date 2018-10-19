package cs2340.donationtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import cs2340.donationtracker.model.Database;
import cs2340.donationtracker.model.Location;

public class LocationDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_detail_screen);

        Bundle extra = getIntent().getExtras();
        int position = extra.getInt("LOCATION_INDEX");
        Location location = Database.locations.get(position);
        final TextView locationNameText = (TextView) findViewById(R.id.locationNameText);
        final TextView locationTypeText = (TextView) findViewById(R.id.locationTypeText);
        final TextView locationLongitudeText = (TextView) findViewById(R.id.locationLongitudeText);
        final TextView locationLatitudeText = (TextView) findViewById(R.id.locationLatitudeText);
        final TextView locationAddressText = (TextView) findViewById(R.id.locationAddressText);
        final TextView locationPhoneNumberText = (TextView) findViewById(R.id.locationPhoneNumberText);

        locationNameText.setText(location.getName());
        locationTypeText.setText(location.getType());
        locationLongitudeText.setText(Double.toString(location.getLongitude()));
        locationLatitudeText.setText(Double.toString(location.getLatitude()));
        locationAddressText.setText(location.getStreetAddress() + " " + location.getCity()
                + " " + location.getState() + " " + location.getZip());
        locationPhoneNumberText.setText(location.getPhone());


    }
}
