package cs2340.donationtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cs2340.donationtracker.model.Database;
import cs2340.donationtracker.model.Location;
/**
 * Activity to input location information
 *
 * @author Eric Zhu
 * @version 1.0
 */
public class LocationDetailActivity extends AppCompatActivity {

    /**
     * onCreate method for location information buttons
     *
     * @param savedInstanceState Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_detail_screen);

        Bundle extra = getIntent().getExtras();
        final int position = extra.getInt("LOCATION_INDEX");
        System.out.println(Database.locations.size());
        Location location = Database.locations.get(position);
        final TextView locationNameText = findViewById(R.id.locationNameText);
        final TextView locationTypeText = findViewById(R.id.locationTypeText);
        final TextView locationLongitudeText = findViewById(R.id.locationLongitudeText);
        final TextView locationLatitudeText = findViewById(R.id.locationLatitudeText);
        final TextView locationAddressText = findViewById(R.id.locationAddressText);
        final TextView locationPhoneNumberText = findViewById(R.id.locationPhoneNumberText);
        final Button addDonationButton = findViewById(R.id.addDonationButton);
        final Button viewDonationsButton = findViewById(R.id.ViewDonationsButton);

        locationNameText.setText(location.getName());
        locationTypeText.setText(location.getType());
        locationLongitudeText.setText(Double.toString(location.getLongitude()));
        locationLatitudeText.setText(Double.toString(location.getLatitude()));
        locationAddressText.setText(location.getStreetAddress() + " " + location.getCity()
                + " " + location.getState() + " " + location.getZip());
        locationPhoneNumberText.setText(location.getPhone());

        addDonationButton.setOnClickListener(new View.OnClickListener() {
            /**
             * starts activity for a log in intent
             *
             * @param v View
             */
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(LocationDetailActivity.this, AddDonationActivity.class);
                loginIntent.putExtra("LOCATION_INDEX", position);
                startActivity(loginIntent);
            }
        });

        viewDonationsButton.setOnClickListener(new View.OnClickListener() {
            /**
             * starts activity for a log in intent
             *
             * @param v View
             */
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(LocationDetailActivity.this, DonationListActivity.class);
                loginIntent.putExtra("LOCATION_INDEX", position);
                startActivity(loginIntent);
            }
        });
    }
}
