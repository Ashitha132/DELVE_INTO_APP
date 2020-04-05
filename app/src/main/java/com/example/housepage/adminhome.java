package com.example.housepage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class adminhome extends AppCompatActivity {
    EditText ward,house;
    Button sub,forw;
    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminhome);
        ward=(EditText)findViewById(R.id.searchward);
        house=(EditText)findViewById(R.id.searchhouse);
        sub=(Button) findViewById(R.id.searchbtn);
        forw=(Button)findViewById(R.id.forbtn);
        forw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ii=new Intent(getApplicationContext(),keywordsearch.class);
                startActivity(ii);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sward=ward.getText().toString().trim();
                final String shouse=house.getText().toString().trim();
                ref= FirebaseDatabase.getInstance().getReference().child("survey").child(sward);
                Query query=ref.orderByChild("survey").equalTo(sward);
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists())
                        {
                            Intent i=new Intent(getApplicationContext(),housedetails.class);
                            startActivity(i);

                        }
                        else
                       {
                            Toast.makeText(getApplicationContext(),"Not exists",Toast.LENGTH_SHORT).show();
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
