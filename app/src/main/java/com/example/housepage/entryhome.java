package com.example.housepage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class entryhome extends AppCompatActivity {
    Button checkbotn;
    EditText house;
    Spinner ward;
    String hno,wno;
    DatabaseReference refer;
    Wsurvey wsurvey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entryhome);
        checkbotn=(Button)findViewById(R.id.checkbtn);
        house=(EditText)findViewById(R.id.shouse);
        ward=(Spinner)findViewById(R.id.wno);
        wsurvey=new Wsurvey();

        checkbotn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hno=house.getText().toString().trim();
                wno=ward.getSelectedItem().toString().trim();
                refer= FirebaseDatabase.getInstance().getReference().child("survey").child(wno);
                Query query=refer.orderByChild("hnum").equalTo(hno);
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists())
                        {
                            Toast.makeText(getApplicationContext(),"Already exists",Toast.LENGTH_SHORT).show();


                        }
                        else
                        {
                            SharedPreferences.Editor editor=getSharedPreferences("wardhouse",MODE_PRIVATE).edit();
                            editor.putString("sward",wno);
                            editor.putString("shouse",hno);
                            editor.commit();
                            Intent icheck =new Intent(getApplicationContext(),centralsubmission.class);
                            startActivity(icheck);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });

    }
}
