package cs2340.donationtracker;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

import java.util.ArrayList;

import cs2340.donationtracker.model.Database;
import cs2340.donationtracker.model.Donation;
import cs2340.donationtracker.model.Location;

public class DonationListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donation_list_screen);

        Bundle extra = getIntent().getExtras();
        final int position = extra.getInt("LOCATION_INDEX");
        Location location = Database.locations.get(position);
        ArrayList<Donation> donations = location.donations;

        final TextView donationList = (TextView) findViewById(R.id.DonationListTextView);
        String text = "";
        for (Donation donation : donations) {
            text += donation.toString() + "\n";
        }
        donationList.setText(text);
    }

}
