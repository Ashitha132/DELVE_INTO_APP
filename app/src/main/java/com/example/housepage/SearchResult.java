package com.example.housepage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.acl.Owner;
import java.util.ArrayList;

public class SearchResult extends AppCompatActivity
{
    DatabaseReference refee;
    RecyclerView recyclerView;
    AdapterSearch adapter;
    ArrayList<Survey>list;
    String sparent,schild;
    Survey survey;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        Log.d("aaaaa","aa");
        Intent intent=getIntent();
        sparent=intent.getStringExtra("sparent");
        schild=intent.getStringExtra("schild");

        recyclerView=(RecyclerView)findViewById(R.id.rvsearch);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList();
        survey=new Survey();

       if (sparent.equalsIgnoreCase("RELIGION"))
       {
           for (int w=1;w<=10;w++) {


               refee = FirebaseDatabase.getInstance().getReference().child("survey").child(String.valueOf(w));

               refee.addValueEventListener(new ValueEventListener() {
                   @Override
                   public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                       for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                           Survey survey1 = snapshot.getValue(Survey.class);
                           if (survey1.getReligion().equalsIgnoreCase(schild)) {

                               list.add(survey1);
                           }

                       }
                       adapter = new AdapterSearch(SearchResult.this, list);
                       recyclerView.setAdapter(adapter);
                   }

                   @Override
                   public void onCancelled(@NonNull DatabaseError databaseError) {
                       Toast.makeText(getApplicationContext(), "something wnt wrong", Toast.LENGTH_LONG).show();
                   }
               });
           }
       }
        else  if (sparent.equalsIgnoreCase("CAST"))
        {
            for (int w=1;w<=10;w++) {


                refee = FirebaseDatabase.getInstance().getReference().child("survey").child(String.valueOf(w));

                refee.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                            Survey survey1 = snapshot.getValue(Survey.class);
                            if (survey1.getCast().equalsIgnoreCase(schild)) {

                                list.add(survey1);
                            }

                        }
                        adapter = new AdapterSearch(SearchResult.this, list);
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(), "something wnt wrong", Toast.LENGTH_LONG).show();
                    }
                });
            }

        }
        else  if (sparent.equalsIgnoreCase("RATION TYPE"))
        {
            for (int w=1;w<=10;w++) {


                refee = FirebaseDatabase.getInstance().getReference().child("survey").child(String.valueOf(w));

                refee.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                            Survey survey1 = snapshot.getValue(Survey.class);
                            if (survey1.getAplbpl().equalsIgnoreCase(schild)) {

                                list.add(survey1);
                            }

                        }
                        adapter = new AdapterSearch(SearchResult.this, list);
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(), "something wnt wrong", Toast.LENGTH_LONG).show();
                    }
                });
            }

        }


        else if (sparent.equalsIgnoreCase("PENSIONERS"))
        {

        }
        else
       {

       }

    }
}
