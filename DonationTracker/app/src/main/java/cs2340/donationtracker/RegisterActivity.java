package cs2340.donationtracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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

        final EditText name = ((EditText) findViewById((R.id.name_input)));
        final EditText username = ((EditText) findViewById(R.id.username_input));
        final EditText password = ((EditText) findViewById(R.id.password_input));
        final Spinner accountType = (Spinner) findViewById(R.id.spinner);
        final FirebaseAuth mAuth = FirebaseAuth.getInstance();
        final RegisterActivity activity = this;
        final Account account = new Account();
        account.setName("Error");



        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, AccountType.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        accountType.setAdapter(adapter);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.createUserWithEmailAndPassword(username.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    account.setName("");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                } else {
                                    Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    account.setName("Error");
                                }
                            }
                        });
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
