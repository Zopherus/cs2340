package cs2340.donationtracker;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cs2340.donationtracker.model.Account;
import cs2340.donationtracker.model.Database;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        final Button cancelButton = (Button) findViewById(R.id.cancelButton);
        final Button loginButton = (Button) findViewById(R.id.loginButton);

        final EditText username = (EditText) findViewById(R.id.username_input);
        final EditText password = (EditText) findViewById(R.id.password_input);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(LoginActivity.this,MainActivity.class);
                Log.i("buttontest", "button pressed");
                startActivity(loginIntent);
            }
        });

        final AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage("Incorrect login");
        dlgAlert.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (Account account : Database.accounts) {
                    System.out.println(account.getUsername() + "   " + account.getPassword());
                    if (account.getUsername().equals(username.getText().toString()) &&
                            account.getPassword().equals(password.getText().toString())) {
                        Intent applicationIntent = new Intent(LoginActivity.this, ApplicationActivity.class);
                        Log.i("buttontest", "button pressed");
                        startActivity(applicationIntent);
                        return;
                    }
                }
                dlgAlert.create();
                dlgAlert.show();
            }
        });
    }
}
