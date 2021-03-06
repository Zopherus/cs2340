package cs2340.donationtracker;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Activity for log in screen
 *
 * @author Eric Zhu
 * @version 1.0
 */
public class LoginActivity extends Activity {
    /**
     * Method for what to do when log in screen is opened
     *
     * @param savedInstanceState Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        final Button cancelButton = findViewById(R.id.cancelButton);
        final Button loginButton = findViewById(R.id.loginButton);

        final EditText username = findViewById(R.id.username_input);
        final EditText password = findViewById(R.id.password_input);

        final FirebaseAuth mAuth = FirebaseAuth.getInstance();
        final LoginActivity activity = this;


        cancelButton.setOnClickListener(new View.OnClickListener() {
            /**
             * method for starting an activity when cancel button pressed
             *
             * @param v
             */
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(loginIntent);
            }
        });

        final AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        loginButton.setOnClickListener(new View.OnClickListener() {
            /**
             * starts activity when login button pressed to launch the app
             *
             * @param v
             */
            @Override
            public void onClick(View v) {
                String u = username.getText().toString();
                String p = password.getText().toString();
                if (u == null || u.isEmpty() || p == null || p.isEmpty()) {
                    dlgAlert.setMessage("Empty username or password");
                    dlgAlert.create();
                    dlgAlert.show();
                    return;
                }
                mAuth.signInWithEmailAndPassword(u, p)
                        .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Intent loginIntent = new Intent(LoginActivity.this, ApplicationActivity.class);
                                    startActivity(loginIntent);
                                } else {
                                    dlgAlert.setMessage("Incorrect login");
                                    dlgAlert.create();
                                    dlgAlert.show();
                                }
                            }
                        });
            }
        });
    }
}
