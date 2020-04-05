package com.example.housepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class entryasset extends AppCompatActivity {
    Button nextasset,vehicleadd,vehiclesave,vehicledelete;
    TableLayout vehtab;
    LinearLayout vehtit,vehlayout,dom1,dom2;
    EditText vehnum,e1,e2;
    String vehiclevalue,domesticvalue;
    String[] vehicletypearray,vehiclenumrarray;
    int svehnum;
    CheckBox cattlecheck,sheepcheck,poultrycheck,goatcheck,pigcheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entryasset);
        nextasset=(Button)findViewById(R.id.assetnext);
        vehicleadd=(Button)findViewById(R.id.vehicleadd);
        vehiclesave=(Button)findViewById(R.id.vehiclesave);
        vehicledelete=(Button)findViewById(R.id.vehicleDEL);
        vehtab=(TableLayout)findViewById(R.id.vehicletable);
        vehtit=(LinearLayout)findViewById(R.id.vehicletitle);
        vehlayout=(LinearLayout)findViewById(R.id.vehiclelayout);
        dom1=(LinearLayout)findViewById(R.id.domesticlayout);
        dom2=(LinearLayout)findViewById(R.id.domesticlayout2);
        cattlecheck=(CheckBox)findViewById(R.id.cattle);
        sheepcheck=(CheckBox)findViewById(R.id.sheep);
        poultrycheck=(CheckBox)findViewById(R.id.poultry);
        goatcheck=(CheckBox)findViewById(R.id.goat);
        pigcheck=(CheckBox)findViewById(R.id.pig);
        final ArrayList<String> domesticstring=new ArrayList<String>();

        vehnum=(EditText)findViewById(R.id.vehiclenum);
        final RadioGroup vehicleradio=(RadioGroup)findViewById(R.id.vehicles);
        final RadioGroup domesticradio=(RadioGroup)findViewById(R.id.domestic);


        vehicleradio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.vehicleno : vehiclevalue = ((RadioButton)findViewById(vehicleradio.getCheckedRadioButtonId())).getText().toString();
                        Toast.makeText(getApplicationContext(), vehiclevalue, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.vehicleyes : vehiclevalue = ((RadioButton)findViewById(vehicleradio.getCheckedRadioButtonId())).getText().toString();
                        vehlayout.setVisibility(View.VISIBLE);
                        Log.d("aaa","a");
                        break;

                }
            }
        });
        vehicleadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String no =vehnum.getText().toString().trim();


                if(no.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), " field empty", Toast.LENGTH_SHORT).show();

                }
                else {
                    svehnum = Integer.parseInt(no);
                    vehtit.setVisibility(View.VISIBLE);

                    vehicleadd.setEnabled(false);

                    for (int i =0; i < svehnum; i++) {
                        TableRow tableRow=new TableRow(getApplicationContext());
                        vehtab.addView(tableRow);
                        e1 = new EditText(getApplicationContext());
                        e1.setHint("                         ");
                        e1.setId(i);
                        tableRow.addView(e1);
                        e2 = new EditText(getApplicationContext());
                        e2.setHint("                 ");
                        e2.setId(i+svehnum);
                        tableRow.addView(e2);

                        vehiclesave.setVisibility(View.VISIBLE);
                        vehicledelete.setVisibility(View.VISIBLE);


                    }
                }


            }
        });
        vehiclesave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vehicletypearray =new String[svehnum];
                vehiclenumrarray =new String[svehnum];

                for(int i=0;i<svehnum;i++)
                {
                    e1=(EditText)findViewById(i);
                    String s1=e1.getText().toString().trim();
                    vehicletypearray[i]=s1;
                    e2=(EditText)findViewById(i+svehnum);
                    String s2=e2.getText().toString().trim();
                    vehiclenumrarray[i]=s2;
                }

            }
        });
        vehicledelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vehtab.removeAllViews();
                vehicleadd.setEnabled(true);


            }
        });
        domesticradio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.domesticno : domesticvalue = ((RadioButton)findViewById(domesticradio.getCheckedRadioButtonId())).getText().toString();
                        Toast.makeText(getApplicationContext(), domesticvalue, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.domesticyes : domesticvalue = ((RadioButton)findViewById(domesticradio.getCheckedRadioButtonId())).getText().toString();
                        dom1.setVisibility(View.VISIBLE);
                        dom2.setVisibility(View.VISIBLE);
                        break;

                }
            }
        });

        if(cattlecheck.isChecked())
        {
            domesticstring.add("cattle");

        }
        if(sheepcheck.isChecked())
        {
            domesticstring.add("sheep");
        }
        if(poultrycheck.isChecked())
        {
            domesticstring.add("poultry");
        }
        if(goatcheck.isChecked())
        {
            domesticstring.add("goat");
        }
        if(pigcheck.isChecked())
        {
            domesticstring.add("pig");
        }



        nextasset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(String val:domesticstring)
                {
                    Toast.makeText(getApplicationContext(),val, Toast.LENGTH_SHORT).show();
                }

                SharedPreferences.Editor editor=getSharedPreferences("assetdetails",MODE_PRIVATE).edit();
                editor.putString("vehicle",vehiclevalue);
                editor.putString("domestic",domesticvalue);
                editor.commit();

                Intent iasset =new Intent(getApplicationContext(),centralsubmission.class);
                startActivity(iasset);
            }
        });
    }
}
