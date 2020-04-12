package com.example.housepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class entryother extends AppCompatActivity {
    Button sub;
    Spinner water;
    String rainvalue,farmvalue,wastevalue,scarcityvalue,WATERVALUE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entryother);
        sub=(Button)findViewById(R.id.subdetails);
        water=(Spinner)findViewById(R.id.spinnerwater);
        final RadioGroup rainradio=(RadioGroup)findViewById(R.id.rain);
        final RadioGroup wasteradio=(RadioGroup)findViewById(R.id.waste);
        final RadioGroup farmradio=(RadioGroup)findViewById(R.id.farm);
        final RadioGroup scarcityradio=(RadioGroup)findViewById(R.id.scarcity);
        rainradio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rainvalue = ((RadioButton)findViewById(rainradio.getCheckedRadioButtonId())).getText().toString().trim();
                Toast.makeText(getApplicationContext(), rainvalue, Toast.LENGTH_SHORT).show();

            }
        });
        wasteradio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                wastevalue = ((RadioButton)findViewById(wasteradio.getCheckedRadioButtonId())).getText().toString().trim();
                Toast.makeText(getApplicationContext(), wastevalue, Toast.LENGTH_SHORT).show();

            }
        });
        farmradio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                farmvalue = ((RadioButton)findViewById(farmradio.getCheckedRadioButtonId())).getText().toString().trim();
                Toast.makeText(getApplicationContext(), farmvalue, Toast.LENGTH_SHORT).show();

            }
        });
        scarcityradio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                scarcityvalue = ((RadioButton)findViewById(scarcityradio.getCheckedRadioButtonId())).getText().toString().trim();
                Toast.makeText(getApplicationContext(), scarcityvalue, Toast.LENGTH_SHORT).show();

            }
        });


        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WATERVALUE=water.getSelectedItem().toString().trim();
                SharedPreferences.Editor editor=getSharedPreferences("otherdetails",MODE_PRIVATE).edit();
                editor.putString("rainvalue",rainvalue);
                editor.putString("farmvalue",farmvalue);
                editor.putString("wastevalue",wastevalue);
                editor.putString("scarcityvalue",scarcityvalue);
                editor.putString("watervalue",WATERVALUE);
                editor.commit();
                Intent iother=new Intent(getApplicationContext(),centralsubmission.class);
                startActivity(iother);
            }
        });

    }
}
