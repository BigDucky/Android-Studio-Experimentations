package com.example.atung.quicklauncher;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button secondActivityButton = (Button) findViewById(R.id.secondActivityButton);
        final EditText emailText = (EditText) findViewById(R.id.emailText);


        secondActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(),SecondActivity.class);
                startIntent.putExtra("WATDEFUCK",emailText.getText().toString());
                startActivity(startIntent);

            }
        });
        final Button googleButton = (Button) findViewById(R.id.googleButton);
        // Attempt to launch an activity outside our app
        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webadress = Uri.parse("http://www.facebook.com");
                Intent goToGoogle = new Intent(Intent.ACTION_VIEW, webadress);
                if (goToGoogle.resolveActivity(getPackageManager())!= null){
                    startActivity(goToGoogle);
                }
            }
        });

    }
}
