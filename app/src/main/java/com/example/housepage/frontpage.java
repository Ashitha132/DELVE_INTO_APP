package com.example.housepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class frontpage extends AppCompatActivity {
    ImageButton admin,surveyor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontpage);
        admin=(ImageButton)findViewById(R.id.adminid);
        surveyor=(ImageButton)findViewById(R.id.surveyorid);

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adintent=new Intent(getApplicationContext(),keywordsearch.class);
                startActivity(adintent);
            }
        });
        surveyor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent surintent=new Intent(getApplicationContext(),login.class);
                startActivity(surintent);
            }
        });
    }
}
