package cs2340.donationtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import cs2340.donationtracker.model.Database;
import cs2340.donationtracker.model.Donation;
import cs2340.donationtracker.model.Location;

public class DonationDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donation_detail_screen);

        Bundle extra = getIntent().getExtras();
        final int location_index = extra.getInt("LOCATION_INDEX");
        final int donation_index = extra.getInt("DONATION_INDEX");

        final TextView nameTextView = (TextView) findViewById(R.id.DonationNameTextView);
        final TextView valueTextView = (TextView) findViewById(R.id.DonationValueTextView);
        final TextView dateTextView = (TextView) findViewById(R.id.DonationDateTextView);
        final TextView locationTextView = (TextView) findViewById(R.id.DonationLocationTextView);

        Location location = Database.locations.get(location_index);
        Donation donation = location.donationArrayList.get(donation_index);

        nameTextView.setText("Name: " + donation.getName());
        valueTextView.setText("Value: " + Double.toString(donation.getValue()));
        dateTextView.setText("Date: " + donation.getDate());
        locationTextView.setText("Location: " + location.getName());
    }
}
