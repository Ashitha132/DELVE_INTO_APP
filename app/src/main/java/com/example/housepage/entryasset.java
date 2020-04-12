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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class entryasset extends AppCompatActivity {
    Button nextasset,vehicleadd,vehiclesave,vehicledelete;
    TableLayout vehtab;
    LinearLayout vehtit,vehlayout,dom1,dom2;
    EditText vehnum,e1,e2,e3;
    String vehiclevalue,domesticvalue;
    String[] vehicletypearray,vehiclenumrarray,vehicleownerarray;
    ArrayList<String > domesticstring;
    Addvehicle addvehicleob;
    int svehnum;
    String wardnumber,housenumber;
    DatabaseReference referee;
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
         domesticstring=new ArrayList<String>();
         addvehicleob=new Addvehicle();

        vehnum=(EditText)findViewById(R.id.vehiclenum);
        final RadioGroup vehicleradio=(RadioGroup)findViewById(R.id.vehicles);
        final RadioGroup domesticradio=(RadioGroup)findViewById(R.id.domestic);
        SharedPreferences sharedPreference=getSharedPreferences("wardhouse",MODE_PRIVATE);
        wardnumber=sharedPreference.getString("sward",null);
        housenumber=sharedPreference.getString("shouse",null);



        vehicleradio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.vehicleno : vehiclevalue = ((RadioButton)findViewById(vehicleradio.getCheckedRadioButtonId())).getText().toString().trim();
                        Toast.makeText(getApplicationContext(), vehiclevalue, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.vehicleyes : vehiclevalue = ((RadioButton)findViewById(vehicleradio.getCheckedRadioButtonId())).getText().toString().trim();
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
                        e3 = new EditText(getApplicationContext());
                        e3.setHint("                 ");
                        e3.setId(i+2*svehnum);
                        tableRow.addView(e3);

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
                vehicleownerarray =new String[svehnum];

                for(int i=0;i<svehnum;i++)
                {
                    e1=(EditText)findViewById(i);
                    String s1=e1.getText().toString().trim();
                    vehicletypearray[i]=s1;
                    e2=(EditText)findViewById(i+svehnum);
                    String s2=e2.getText().toString().trim();
                    vehiclenumrarray[i]=s2;
                    e3=(EditText)findViewById(i+2*svehnum);
                    String s3=e3.getText().toString().trim();
                    vehicleownerarray[i]=s3;
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
                    case R.id.domesticno : domesticvalue = ((RadioButton)findViewById(domesticradio.getCheckedRadioButtonId())).getText().toString().trim();
                        Toast.makeText(getApplicationContext(), domesticvalue, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.domesticyes : domesticvalue = ((RadioButton)findViewById(domesticradio.getCheckedRadioButtonId())).getText().toString().trim();
                        dom1.setVisibility(View.VISIBLE);
                        dom2.setVisibility(View.VISIBLE);
                        break;

                }
            }
        });




        nextasset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


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

                for(String val:domesticstring)
                {
                    referee = FirebaseDatabase.getInstance().getReference().child("survey").child(wardnumber).child(housenumber).child("domestic").child(val);
                    referee.setValue(val);

                }

                for(int i=0;i<svehnum;i++)
                {
                    addvehicleob.setVehicletype(vehicletypearray[i]);
                    addvehicleob.setVehiclenum(vehiclenumrarray[i]);
                    addvehicleob.setVehicleowner(vehicleownerarray[i]);
                    referee = FirebaseDatabase.getInstance().getReference().child("survey").child(wardnumber).child(housenumber).child("vehicle").child(vehicletypearray[i]);
                    referee.setValue(addvehicleob);
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
