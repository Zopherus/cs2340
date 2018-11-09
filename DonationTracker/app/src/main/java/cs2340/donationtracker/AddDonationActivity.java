package cs2340.donationtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import cs2340.donationtracker.model.Database;
import cs2340.donationtracker.model.Donation;

public class AddDonationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_donation_screen);

        Bundle extra = getIntent().getExtras();
        final int position = extra.getInt("LOCATION_INDEX");

        final TextView nameTextView = (TextView) findViewById(R.id.ItemNameEditText);
        final TextView valueTextView = (TextView) findViewById(R.id.ItemValueEditText);
        final TextView typeTextView = findViewById(R.id.ItemTypeEditText);
        final Button addDonationButton = (Button) findViewById(R.id.AddDonationToLocationButton);

        addDonationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Donation donation = new Donation(Double.parseDouble(valueTextView.getText().toString()),
                        Database.locations.get(position), LocalDateTime.now().toString(), nameTextView.getText().toString(),
                        typeTextView.getText().toString());
                Database.locations.get(position).donationArrayList.add(donation);

                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
                mDatabase.child("Locations").child(Integer.toString(position)).child("donations").child(donation.getName()).child("date").setValue(donation.getDate());
                mDatabase.child("Locations").child(Integer.toString(position)).child("donations").child(donation.getName()).child("location").setValue(donation.getLocation().getName());
                mDatabase.child("Locations").child(Integer.toString(position)).child("donations").child(donation.getName()).child("value").setValue(donation.getValue());
                mDatabase.child("Locations").child(Integer.toString(position)).child("donations").child(donation.getName()).child("type").setValue(donation.getType());

            }
        });
    }
}