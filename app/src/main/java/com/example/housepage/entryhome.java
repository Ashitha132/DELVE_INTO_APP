package com.example.housepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class entryhome extends AppCompatActivity {
    Button checkbotn;
    EditText house;
    Spinner ward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entryhome);
        checkbotn=(Button)findViewById(R.id.checkbtn);
        house=(EditText)findViewById(R.id.shouse);
        ward=(Spinner)findViewById(R.id.wno);

        checkbotn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String hno=house.getText().toString().trim();
                String wno=ward.getSelectedItem().toString().trim();
                Intent icheck =new Intent(getApplicationContext(),entryland.class);
                startActivity(icheck);
            }
        });

    }
}
