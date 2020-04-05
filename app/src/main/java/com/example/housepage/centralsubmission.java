package com.example.housepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class centralsubmission extends AppCompatActivity {

    Button bland,bhouse,bfamily,basset,bother,bsubmit;
    Wsurvey wsurvey;
    DatabaseReference reference;
    String wno,hno,splot,srname,sraddress,sregion,srent,splinth,scarpet,sheight,sfloor,sroof,rainvalue,farmvalue,wastevalue,watervalue,scarcityvalue;
   String religion,castevalue,aplbplvalue,pensionvalue,dapvalue,disvalue,diseasevalue,rationvalue,vehicle,domestic;
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
        wsurvey=new Wsurvey();


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
        });



        SharedPreferences sharedPreferences1=getSharedPreferences("wardhouse",MODE_PRIVATE);
        wno=sharedPreferences1.getString("sward",null);
        hno=sharedPreferences1.getString("shouse",null);
        SharedPreferences sharedPreferences2=getSharedPreferences("landdetails",MODE_PRIVATE);
        splot=sharedPreferences1.getString("splot",null);
        sraddress=sharedPreferences1.getString("sraddress",null);
        srname=sharedPreferences1.getString("srname",null);
        sregion=sharedPreferences1.getString("sregion",null);
        srent=sharedPreferences1.getString("srent",null);

        SharedPreferences sharedPreferences3=getSharedPreferences("housedetails",MODE_PRIVATE);
        splinth=sharedPreferences1.getString("splinth",null);
        scarpet=sharedPreferences1.getString("scarpet",null);
        sheight=sharedPreferences1.getString("sheight",null);
        sfloor=sharedPreferences1.getString("sfloor",null);
        sroof=sharedPreferences1.getString("sroof",null);

        SharedPreferences sharedPreferences4=getSharedPreferences("otherdetails",MODE_PRIVATE);
        rainvalue=sharedPreferences1.getString("rainvalue",null);
        farmvalue=sharedPreferences1.getString("farmvalue",null);
        wastevalue=sharedPreferences1.getString("wastevalue",null);
        scarcityvalue=sharedPreferences1.getString("scarcityvalue",null);
        watervalue=sharedPreferences1.getString("watervalue",null);

        SharedPreferences sharedPreferences5=getSharedPreferences("familydetails",MODE_PRIVATE);
        religion=sharedPreferences1.getString("religion",null);
        aplbplvalue=sharedPreferences1.getString("aplbplvalue",null);
        castevalue=sharedPreferences1.getString("castevalue",null);
        rationvalue=sharedPreferences1.getString("rationvalue",null);
        pensionvalue=sharedPreferences1.getString("pensionvalue",null);
        dapvalue=sharedPreferences1.getString("dapvalue",null);
        disvalue=sharedPreferences1.getString("disvalue",null);
        diseasevalue=sharedPreferences1.getString("dapvalue",null);

        SharedPreferences sharedPreferences6=getSharedPreferences("assetetails",MODE_PRIVATE);
        vehicle=sharedPreferences1.getString("vehicle",null);
        domestic=sharedPreferences1.getString("domestic",null);







        bsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                wsurvey.setWard(wno);
                wsurvey.setHouse(hno);
                wsurvey.setPlotarea(splot);
                wsurvey.setResidentaddress(sraddress);
                wsurvey.setResidentname(srname);
                wsurvey.setRegion(sregion);
                wsurvey.setRent(srent);
                wsurvey.setPlintharea(splinth);
                wsurvey.setCarpetarea(scarpet);
                wsurvey.setHeight(sheight);
                wsurvey.setRooftype(sroof);
                wsurvey.setFloornum(sfloor);
                wsurvey.setRainharvest(rainvalue);
                wsurvey.setWaste(wastevalue);
                wsurvey.setFarm(farmvalue);
                wsurvey.setScarcity(scarcityvalue);
                wsurvey.setWatersource(watervalue);
                wsurvey.setRegion(religion);
                wsurvey.setAplbpl(aplbplvalue);
                wsurvey.setCast(castevalue);
                wsurvey.setRationcardno(rainvalue);
                wsurvey.setPension(pensionvalue);
                wsurvey.setDiffer(dapvalue);
                wsurvey.setDisable(disvalue);
                wsurvey.setDiseases(diseasevalue);
                wsurvey.setVehicles(vehicle);
                wsurvey.setDomestic(domestic);
                reference= FirebaseDatabase.getInstance().getReference().child("survey").child(wno).child(hno);
                reference.setValue(wsurvey);





            }
        });


    }
}
