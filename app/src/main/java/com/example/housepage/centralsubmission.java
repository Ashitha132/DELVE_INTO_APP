package com.example.housepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class centralsubmission extends AppCompatActivity {

    Button bland,bhouse,bfamily,basset,bother,bsubmit;
    String wno,hno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centralsubmission);
        bland=(Button)findViewById(R.id.btnland);
        bhouse=(Button)findViewById(R.id.btnhouse);
        bfamily=(Button)findViewById(R.id.btnfamily);
        basset=(Button)findViewById(R.id.btnasset);
        bother=(Button)findViewById(R.id.btnother);
        bsubmit=(Button)findViewById(R.id.btnupload);
        Intent iland=getIntent();
        wno=iland.getStringExtra("wardnum");
        hno=iland.getStringExtra("housenum");

        bland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getApplicationContext(),entryland.class);
                startActivity(i1);

            }
        });
        bhouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(getApplicationContext(),entryhouse.class);
                startActivity(i2);

            }
        });bfamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i3);

            }
        });basset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4=new Intent(getApplicationContext(),entryasset.class);
                startActivity(i4);

            }
        });bother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5=new Intent(getApplicationContext(),entryother.class);
                startActivity(i5);

            }
        });bsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





            }
        });


    }
}
