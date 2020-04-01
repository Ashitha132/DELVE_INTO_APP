package com.example.housepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class keywordsearch extends AppCompatActivity {


    Spinner parent,child;
    Button search;
    String sparent,schild;
    ArrayList<String> parentarraylist;
    ArrayList<String> religion,cast,ration_type,pensioners,daf,vehicles;

    ArrayAdapter<String> parentarrayadapter,childarrayadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keywordsearch);
        parent=(Spinner)findViewById(R.id.parent_spinner);
        child=(Spinner)findViewById(R.id.child_spinner);

        search=(Button)findViewById(R.id.searchkeyword);


        parentarraylist=new ArrayList<>();
        parentarraylist.add("RELIGION");
        parentarraylist.add("CAST");
        parentarraylist.add("RATION TYPE");
        parentarraylist.add("PENSIONERS");
        parentarraylist.add("DOMESTIC ANIMAL FEEDING");
        parentarraylist.add("VEHICLES");
        parentarrayadapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,parentarraylist);
        parent.setAdapter(parentarrayadapter);

        religion=new ArrayList<>();
        religion.add("HINDU");
        religion.add("MUSLIM");
        religion.add("CHRISTIAN");
        religion.add("OTHERS");

        cast=new ArrayList<>();
        cast.add("GENERAL");
        cast.add("OBC");
        cast.add("SC");
        cast.add("ST");

        ration_type=new ArrayList<>();
        ration_type.add("APL");
        ration_type.add("BPL");

        daf=new ArrayList<>();
        daf.add("YES");
        daf.add("NO");

        pensioners=new ArrayList<>();
        pensioners.add("YES");
        pensioners.add("NO");

        vehicles=new ArrayList<>();
        vehicles.add("YES");
        vehicles.add("NO");


        parent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    childarrayadapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,religion);
                }
                if(position==1)
                {
                    childarrayadapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,cast);
                }
                if(position==2)
                {
                    childarrayadapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,ration_type);
                }
                if(position==3)
                {
                    childarrayadapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,pensioners);
                }
                if(position==4)
                {
                    childarrayadapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,daf);
                }
                if(position==5)
                {
                    childarrayadapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,vehicles);
                }
                child.setAdapter(childarrayadapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                sparent=parent.getSelectedItem().toString();
                schild=child.getSelectedItem().toString();

                Intent intent=new Intent(getApplicationContext(),SearchResult.class);
                intent.putExtra("sparent",sparent);
                intent.putExtra("schild",schild);
                startActivity(intent);


            }
        });










    }
}
