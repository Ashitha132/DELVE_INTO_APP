package com.example.housepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText e1,e2;
    Button log;
    String username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1=(EditText)findViewById(R.id.username);
        e2=(EditText)findViewById(R.id.password);
        log=(Button) findViewById(R.id.login);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username=e1.getText().toString().trim();
                password=e2.getText().toString().trim();
                if(username.equals("panchayath")&& password.equals("12345"))
                {
                    Intent i=new Intent(getApplicationContext(),homesurveyor.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"incorrect username or password",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
