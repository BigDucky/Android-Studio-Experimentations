package com.example.atung.quicklauncher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if(getIntent().hasExtra("WATDEFUCK")){
            TextView tv = (TextView) findViewById(R.id.textView);

            tv.setText(getIntent().getExtras().getString("WATDEFUCK"));
        }
    }
}
