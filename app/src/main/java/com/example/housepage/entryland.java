package com.example.housepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class entryland extends AppCompatActivity {
    Button nextland;
    EditText plotarea,residentaddress,residentname,ownername,owneraddres;
    Spinner region;
    String rentvalue;
    LinearLayout lname,laddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entryland);
        nextland=(Button)findViewById(R.id.landnext);
        plotarea=(EditText)findViewById(R.id.plot);
        residentaddress=(EditText)findViewById(R.id.raddress);
        residentname=(EditText)findViewById(R.id.rname);
        ownername=(EditText)findViewById(R.id.oname);
        owneraddres=(EditText)findViewById(R.id.oaddress);
        region=(Spinner)findViewById(R.id.regionspinner);
        final RadioGroup rentradio=(RadioGroup)findViewById(R.id.rent);
        lname=(LinearLayout)findViewById(R.id.linearname);
        laddress=(LinearLayout)findViewById(R.id.linearaddress);

        rentradio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.rentno : rentvalue = ((RadioButton)findViewById(rentradio.getCheckedRadioButtonId())).getText().toString();
                        Toast.makeText(getApplicationContext(), rentvalue, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rentyes : rentvalue = ((RadioButton)findViewById(rentradio.getCheckedRadioButtonId())).getText().toString();
                        lname.setVisibility(View.VISIBLE);
                        laddress.setVisibility(View.VISIBLE);

                        break;
                }
            }
        });


        nextland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String splot=plotarea.getText().toString().trim();
                String sraddress=residentaddress.getText().toString().trim();
                String srname=residentname.getText().toString().trim();
                String soname=ownername.getText().toString().trim();
                String soaddress=owneraddres.getText().toString().trim();
                String sregion=region.getSelectedItem().toString().trim();
                Toast.makeText(getApplicationContext(), splot+sraddress+srname+soaddress+soname+sregion, Toast.LENGTH_SHORT).show();


            }
        });
    }
}
