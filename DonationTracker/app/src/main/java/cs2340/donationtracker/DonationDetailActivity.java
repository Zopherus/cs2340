package cs2340.donationtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import cs2340.donationtracker.model.Database;
import cs2340.donationtracker.model.Donation;
import cs2340.donationtracker.model.Location;
/**
 * Activity for when Create is pressed to make a donation
 *
 * @author Eric Zhu
 * @version 1.0
 */
public class DonationDetailActivity extends AppCompatActivity {


    /**
     * Connects creation to database, sets fields
     *
     * @param savedInstanceState, a Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donation_detail_screen);

        Bundle extra = getIntent().getExtras();
        final int location_index = extra.getInt("LOCATION_INDEX");
        final int donation_index = extra.getInt("DONATION_INDEX");

        final TextView nameTextView = findViewById(R.id.DonationNameTextView);
        final TextView valueTextView = findViewById(R.id.DonationValueTextView);
        final TextView dateTextView = findViewById(R.id.DonationDateTextView);
        final TextView locationTextView = findViewById(R.id.DonationLocationTextView);

        Location location = Database.locations.get(location_index);
        Donation donation = location.donationArrayList.get(donation_index);

        nameTextView.setText("Name: " + donation.getName());
        valueTextView.setText("Value: " + Double.toString(donation.getValue()));
        dateTextView.setText("Date: " + donation.getDate());
        locationTextView.setText("Location: " + location.getName());
    }
}
