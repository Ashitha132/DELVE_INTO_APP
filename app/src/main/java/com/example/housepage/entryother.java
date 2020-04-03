package com.example.housepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class entryother extends AppCompatActivity {
    Button sub;
    Spinner water;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entryother);
        water=(Spinner)findViewById(R.id.spinnerwater);
        final RadioGroup rainradio=(RadioGroup)findViewById(R.id.rain);
        final RadioGroup waste=(RadioGroup)findViewById(R.id.waste);
        final RadioGroup farm=(RadioGroup)findViewById(R.id.farm);
        final RadioGroup scarcity=(RadioGroup)findViewById(R.id.scarcity);



        sub=(Button)findViewById(R.id.subdetails);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iother=new Intent(getApplicationContext(),homesurveyor.class);
                startActivity(iother);
            }
        });

    }
}
