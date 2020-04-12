package com.example.housepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homesurveyor extends AppCompatActivity {
    Button newbtn;
    String wardnumber,housenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homesurveyor);
        newbtn=(Button)findViewById(R.id.news);
        SharedPreferences sharedPreferences=getSharedPreferences("wardhouse",MODE_PRIVATE);
        wardnumber=sharedPreferences.getString("sward",null);
        housenumber=sharedPreferences.getString("shouse",null);
        if(wardnumber!=null && housenumber!=null)
        {
            Intent igo=new Intent(getApplicationContext(),centralsubmission.class);
            startActivity(igo);
        }
        newbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ihome=new Intent(getApplicationContext(),entryhome.class);
                startActivity(ihome);
            }
        });
    }
}
