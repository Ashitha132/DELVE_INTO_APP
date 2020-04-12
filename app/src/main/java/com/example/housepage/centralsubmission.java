package com.example.housepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class centralsubmission extends AppCompatActivity {

    Button bland,bhouse,bfamily,basset,bother,bsubmit,bback;
    Wsurvey wsurvey;
    DatabaseReference reference;
    String wno,hno,splot,srname,sraddress,sregion,srent,splinth,scarpet,sheight,sfloor,sroof,rainvalue,farmvalue,wastevalue,watervalue,scarcityvalue;
    String religion,castevalue,aplbplvalue,pensionvalue,dapvalue,disvalue,diseasevalue,rationvalue,vehicle,domestic;
    String soname,soaddress,difname,disname,disename,disease;


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
        bback=(Button)findViewById(R.id.btnback);
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
        splot=sharedPreferences2.getString("splot",null);
        sraddress=sharedPreferences2.getString("sraddress",null);
        srname=sharedPreferences2.getString("srname",null);
        sregion=sharedPreferences2.getString("sregion",null);
        srent=sharedPreferences2.getString("srent",null);
        soname=sharedPreferences2.getString("soname",null);
        soaddress=sharedPreferences2.getString("soaddress",null);

        SharedPreferences sharedPreferences3=getSharedPreferences("housedetails",MODE_PRIVATE);
        splinth=sharedPreferences3.getString("splinth",null);
        scarpet=sharedPreferences3.getString("scarpet",null);
        sheight=sharedPreferences3.getString("sheight",null);
        sfloor=sharedPreferences3.getString("sfloor",null);
        sroof=sharedPreferences3.getString("sroof",null);

        SharedPreferences sharedPreferences4=getSharedPreferences("otherdetails",MODE_PRIVATE);
        rainvalue=sharedPreferences4.getString("rainvalue",null);
        farmvalue=sharedPreferences4.getString("farmvalue",null);
        wastevalue=sharedPreferences4.getString("wastevalue",null);
        scarcityvalue=sharedPreferences4.getString("scarcityvalue",null);
        watervalue=sharedPreferences4.getString("watervalue",null);

        SharedPreferences sharedPreferences5=getSharedPreferences("familydetails",MODE_PRIVATE);
        religion=sharedPreferences5.getString("religion",null);
        aplbplvalue=sharedPreferences5.getString("aplbplvalue",null);
        castevalue=sharedPreferences5.getString("castevalue",null);
        rationvalue=sharedPreferences5.getString("rationvalue",null);
        pensionvalue=sharedPreferences5.getString("pensionvalue",null);
        dapvalue=sharedPreferences5.getString("dapvalue",null);
        disvalue=sharedPreferences5.getString("disvalue",null);
        diseasevalue=sharedPreferences5.getString("diseasevalue",null);
        difname=sharedPreferences5.getString("difname",null);
        disname=sharedPreferences5.getString("disname",null);
        disename=sharedPreferences5.getString("disename",null);
        disease=sharedPreferences5.getString("disease",null);


        SharedPreferences sharedPreferences6=getSharedPreferences("assetdetails",MODE_PRIVATE);
        vehicle=sharedPreferences6.getString("vehicle",null);
        domestic=sharedPreferences6.getString("domestic",null);



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
                    wsurvey.setReligion(religion);
                    wsurvey.setAplbpl(aplbplvalue);
                    wsurvey.setCast(castevalue);
                    wsurvey.setRationcardno(rationvalue);
                    wsurvey.setPension(pensionvalue);
                    wsurvey.setDiffer(dapvalue);
                    wsurvey.setDisable(disvalue);
                    wsurvey.setDiseases(diseasevalue);
                    wsurvey.setVehicles(vehicle);
                    wsurvey.setDomestic(domestic);
                    wsurvey.setOwnername(soname);
                    wsurvey.setOwneraddress(soaddress);
                    wsurvey.setDiffername(difname);
                    wsurvey.setDisablename(disname);
                    wsurvey.setPatientname(disename);
                    wsurvey.setDisease(disease);
                    reference = FirebaseDatabase.getInstance().getReference().child("survey").child(wno).child(hno).child("basic");
                    reference.setValue(wsurvey);





            }
        });
        bback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor1=getSharedPreferences("assetdetails",MODE_PRIVATE).edit();
                editor1.clear();
                editor1.commit();SharedPreferences.Editor editor2=getSharedPreferences("familydetails",MODE_PRIVATE).edit();
                editor2.clear();
                editor2.commit();SharedPreferences.Editor editor3=getSharedPreferences("housedetails",MODE_PRIVATE).edit();
                editor3.clear();
                editor3.commit();SharedPreferences.Editor editor4=getSharedPreferences("landdetails",MODE_PRIVATE).edit();
                editor4.clear();
                editor4.commit();SharedPreferences.Editor editor5=getSharedPreferences("otherdetails",MODE_PRIVATE).edit();
                editor5.clear();
                editor5.commit();SharedPreferences.Editor editor6=getSharedPreferences("wardhouse",MODE_PRIVATE).edit();
                editor6.clear();
                editor6.commit();
                Intent ibck=new Intent(getApplicationContext(),homesurveyor.class);
                startActivity(ibck);

            }
        });


    }
    Toast backToast;
    long backpress;
    @Override
    public void onBackPressed()
    {
        if (backpress+2000>System.currentTimeMillis())
        {
            backToast.cancel();
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
        else
        {
            backToast=Toast.makeText(getApplicationContext(), "Press again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backpress=System.currentTimeMillis();
    }
}
