package com.example.transline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class DriverProfile extends AppCompatActivity {
    private TextView tvName,textViewContainer;
    private TextView tvAbout;
    private TextView tvDepot;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_profile);
        tvName = findViewById(R.id.textViewName);
        tvAbout = findViewById(R.id.textViewAbout);
        tvDepot = findViewById(R.id.textViewDepot);
        ratingBar = findViewById(R.id.ratingBar);
        textViewContainer=findViewById(R.id.textViewContainer);
        Intent intent = getIntent();
        String name = intent.getStringExtra("driveName");
        String details = intent.getStringExtra("driveDetails");
        String transit = intent.getStringExtra("driveTransit");
        String container=intent.getStringExtra("containerName");
        tvName.setText(name);
        tvAbout.setText(details);
        tvDepot.setText(transit);
        textViewContainer.setText(container);

    }
}
