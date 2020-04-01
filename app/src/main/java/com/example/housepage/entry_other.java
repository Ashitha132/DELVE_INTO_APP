package com.example.housepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class entry_other extends AppCompatActivity {
    Button sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sub=(Button)findViewById(R.id.submitdetails);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iother=new Intent(getApplicationContext(),homesurveyor.class);
                startActivity(iother);
            }
        });
    }
}
