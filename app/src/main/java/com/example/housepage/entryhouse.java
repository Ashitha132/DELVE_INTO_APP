package com.example.housepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class entryhouse extends AppCompatActivity {
    Button nexthouse;
    EditText plinth,carpet,height,floor;
    Spinner roof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entryhouse);
        nexthouse=(Button)findViewById(R.id.housenext);
        plinth=(EditText)findViewById(R.id.plinthed);
        carpet=(EditText)findViewById(R.id.carpeted);
        height=(EditText)findViewById(R.id.heighted);
        floor=(EditText)findViewById(R.id.floreed);
        roof=(Spinner)findViewById(R.id.spinnerroof);
        nexthouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String splinth=plinth.getText().toString().trim();
                String scarpet=carpet.getText().toString().trim();
                String sheight=height.getText().toString().trim();
                String sfloor=floor.getText().toString().trim();
                String sroof=roof.getSelectedItem().toString().trim();
                Toast.makeText(getApplicationContext(), splinth+scarpet+sheight+sfloor+sroof, Toast.LENGTH_SHORT).show();
                Intent ihouse=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(ihouse);
            }
        });
    }
}
