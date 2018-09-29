package cs2340.donationtracker;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import cs2340.donationtracker.model.Account;
import cs2340.donationtracker.model.AccountType;
import cs2340.donationtracker.model.Database;

public class RegisterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_screen);

        final Button registerButton = (Button) findViewById(R.id.registerButton);
        final Button cancelButton = (Button) findViewById(R.id.cancelButton);

        final String name = ((EditText) findViewById((R.id.name_input))).getText().toString();
        final String username = ((EditText) findViewById(R.id.username_input)).getText().toString();
        final String password = ((EditText) findViewById(R.id.password_input)).getText().toString();
        final Spinner accountType = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, AccountType.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        accountType.setAdapter(adapter);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Account newAccount = new Account(name, username, password, (AccountType) accountType.getSelectedItem());
                Database.accounts.add(newAccount);
                Intent applicationIntent = new Intent(RegisterActivity.this, ApplicationActivity.class);
                Log.i("buttontest", "button pressed");
                startActivity(applicationIntent);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent applicationIntent = new Intent(RegisterActivity.this, MainActivity.class);
                Log.i("buttontest", "button pressed");
                startActivity(applicationIntent);
            }
        });
    }
}
