package cs2340.donationtracker;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

        System.out.println("HELO");
        Bundle extra = getIntent().getExtras();
        final int location_index = extra.getInt("LOCATION_INDEX");
        final RadioButton nameRadio = findViewById(R.id.nameRadioButton);
        final RadioButton typeRadio = findViewById(R.id.ItemTypeRadioButton);
        final RadioGroup radioGroup = findViewById(R.id.RadioGroup);

        final ListView donationList = (ListView) findViewById(R.id.DonationItemListView);
        final EditText nameTextEdit = findViewById(R.id.DonationItemNameEditText);


        nameRadio.toggle();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                String name = nameTextEdit.getText().toString();
                nameTextEdit.setText(" ");
                nameTextEdit.setText(name);
            }
        });


        if (location_index == -1) {
            final ArrayList<String> donationNames = new ArrayList<String>();
            for (Location location : Database.locations) {
                for (Donation donation : location.donationArrayList)
                    donationNames.add(donation.getName());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, donationNames);
            adapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
            donationList.setAdapter(adapter);

            final DonationListActivity activity = this;
            nameTextEdit.addTextChangedListener(new TextWatcher() {

                @Override
                public void afterTextChanged(Editable s) {}

                @Override
                public void beforeTextChanged(CharSequence s, int start,
                                              int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start,
                                          int before, int count) {
                    String str = nameTextEdit.getText().toString();
                    if (radioGroup.getCheckedRadioButtonId() == R.id.nameRadioButton) {
                        ArrayList<String> display = new ArrayList<>();
                        for (Location location : Database.locations) {
                            for (Donation donation : location.donationArrayList)
                                if (donation.getName().toLowerCase().contains(str))
                                    display.add(donation.getName());
                        }

                        if (display.size() == 0)
                            display.add("No items with that name.");
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity,
                                android.R.layout.simple_list_item_1, display);
                        adapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
                        donationList.setAdapter(adapter);
                    } else {
                        ArrayList<String> display = new ArrayList<>();
                        for (Location location : Database.locations) {
                            for (Donation donation : location.donationArrayList)
                                if (donation.getType().toLowerCase().contains(str))
                                    display.add(donation.getName());
                        }

                        if (display.size() == 0)
                            display.add("No items with that type.");
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity,
                                android.R.layout.simple_list_item_1, display);
                        adapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
                        donationList.setAdapter(adapter);
                    }
                }
            });

            return;
        }
        Location location = Database.locations.get(location_index);
        final ArrayList<Donation> donations = location.donationArrayList;

        donationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent loginIntent = new Intent(DonationListActivity.this, DonationDetailActivity.class);
                loginIntent.putExtra("LOCATION_INDEX", location_index);
                loginIntent.putExtra("DONATION_INDEX", position);
                Log.i("buttontest", "button pressed");
                startActivity(loginIntent);
            }
        });

        ArrayList<String> donationNames = new ArrayList<String>();
        for (Donation donation : donations) {
            donationNames.add(donation.getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, donationNames);
        adapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
        donationList.setAdapter(adapter);

        final DonationListActivity activity = this;
        nameTextEdit.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                String str = nameTextEdit.getText().toString();
                if (radioGroup.getCheckedRadioButtonId() == R.id.nameRadioButton) {
                    ArrayList<String> display = new ArrayList<>();
                    for (Donation donation : donations) {
                        if (donation.getName().toLowerCase().contains(str.toLowerCase()))
                            display.add(donation.getName());
                    }

                    if (display.size() == 0)
                        display.add("No items with that name.");
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity,
                            android.R.layout.simple_list_item_1, display);
                    adapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
                    donationList.setAdapter(adapter);
                } else {
                    ArrayList<String> display = new ArrayList<>();
                    for (Donation donation : donations) {
                        if (donation.getType().toLowerCase().contains(str.toLowerCase()))
                            display.add(donation.getName());
                    }

                    if (display.size() == 0)
                        display.add("No items with that type.");
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity,
                            android.R.layout.simple_list_item_1, display);
                    adapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
                    donationList.setAdapter(adapter);
                }
            }
        });
    }
}
