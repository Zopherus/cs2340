package cs2340.donationtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
/**
 * Creates an AVL Tree
 *
 * @author Eric Zhu
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    /**
     * onCreate method to show opening screen with login and register button
     *
     * @param savedInstanceState Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);
        final Button registerButton = (Button) findViewById(R.id.registerButton);
        final Button loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new OnClickListener() {
            /**
             * launches login when login button is clicked
             *
             * @param v
             */
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(MainActivity.this,LoginActivity.class);
                Log.i("buttontest", "button pressed");
                startActivity(loginIntent);
            }
        });

        registerButton.setOnClickListener(new OnClickListener() {
            /**
             * launches registration when register button is clicked
             *
             * @param v
             */
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(MainActivity.this,RegisterActivity.class);
                Log.i("buttontest", "button pressed");
                startActivity(loginIntent);
            }
        });
    }
}
