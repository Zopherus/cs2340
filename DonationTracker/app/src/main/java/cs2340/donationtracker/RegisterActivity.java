package cs2340.donationtracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import cs2340.donationtracker.model.AccountType;
/**
 * @author      Eric Zhu
 * @version     1.0
 */
public class RegisterActivity extends Activity {

    /**
     * method for what happens when the registration screen is open
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_screen);

        final Button registerButton = findViewById(R.id.registerButton);
        final Button cancelButton = findViewById(R.id.cancelButton);

        final EditText name =  findViewById((R.id.name_input));
        final EditText username = findViewById(R.id.username_input);
        final EditText password = findViewById(R.id.password_input);
        final Spinner accountType = findViewById(R.id.spinner);
        final FirebaseAuth mAuth = FirebaseAuth.getInstance();
        final RegisterActivity activity = this;

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, AccountType.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        accountType.setAdapter(adapter);

        registerButton.setOnClickListener(new View.OnClickListener() {
            /**
             * what happens when the register button is clicked
             * @param v
             */
            @Override
            public void onClick(View v) {
                mAuth.createUserWithEmailAndPassword(username.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                Intent applicationIntent = new Intent(RegisterActivity.this, ApplicationActivity.class);
                startActivity(applicationIntent);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            /**
             * what happens when the cancel button is clicked
             * @param v
             */
            @Override
            public void onClick(View v) {
                Intent applicationIntent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(applicationIntent);
            }
        });
    }
}
