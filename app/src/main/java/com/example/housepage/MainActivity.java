package com.example.housepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import static com.example.housepage.R.array.religion;

public class MainActivity extends AppCompatActivity {

    EditText addno,e1,e2,e3,e4,e5,e6,e7,pensionno;
    EditText edrationcardnumber;
    Spinner religionspin;
    Button addmember,memberviewer,memberdelete,pensionadd,pensionsave,pensiondel;
    Button submit;
    LinearLayout lineardisease,lineardiffer,lineardisable;
    Button difadd,disadd,diseadd;
    EditText difname,disname,disename;
    Spinner disease;

    int memnum,n;

    TableLayout tableLayout1,tableLayout2;
    LinearLayout pensionerlayout,pensionertitle,linearpen;
    TextView pensionname,pensionername,membername,membergender,memberage,memberoccupation,memberaadhar;
    TableRow tableRow2;
    DatabaseReference reference;


    String religion,aplbplvalue,castevalue;
    String[] membernamearray,membergenderarray,memberagearray,memberoccupationarray;
    String[] pensionernamearray,pensionnamearray;
    String pensionvalue,dapvalue,disvalue,diseasevalue;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        addno=(EditText)findViewById(R.id.added);
        pensionno=(EditText)findViewById(R.id.pennum);
        difname=(EditText)findViewById(R.id.edit1);
        disname=(EditText)findViewById(R.id.edit2);
        disename=(EditText)findViewById(R.id.edit3);
        edrationcardnumber=(EditText)findViewById(R.id.houserationcardno);


        religionspin=(Spinner)findViewById(R.id.religionspinner);
        disease=(Spinner)findViewById(R.id.spinnerdiseases);
        final RadioGroup pensionradio = (RadioGroup) findViewById(R.id.pensioners);

        final RadioGroup aplbplradio = (RadioGroup) findViewById(R.id.aplbpl);
        final RadioGroup casteradio = (RadioGroup) findViewById(R.id.caste);
        final RadioGroup differradio = (RadioGroup) findViewById(R.id.dap);
        final RadioGroup disableradio = (RadioGroup) findViewById(R.id.accident);
        final RadioGroup diseaseradio = (RadioGroup) findViewById(R.id.diseasesradio);

        addmember=(Button) findViewById(R.id.add);
        memberviewer=(Button) findViewById(R.id.save);
        pensionadd=(Button)findViewById(R.id.penadd);
        pensionsave=(Button)findViewById(R.id.pensave);
        memberdelete=(Button)findViewById(R.id.del);
        pensiondel=(Button)findViewById(R.id.penDEL);
        submit=(Button)findViewById(R.id.submittingall);
        difadd=(Button)findViewById(R.id.adddap);
        disadd=(Button)findViewById(R.id.addaccident);
        diseadd=(Button)findViewById(R.id.addddiseases);

        tableLayout1=(TableLayout)findViewById(R.id.membertable);
        tableLayout2=(TableLayout)findViewById(R.id.pensiontable);




        linearpen=(LinearLayout)findViewById(R.id.linearpension);
        lineardisease=(LinearLayout)findViewById(R.id.diseaseslay);
        lineardisable=(LinearLayout)findViewById(R.id.linear1);
        lineardiffer=(LinearLayout)findViewById(R.id.linear2);

        pensionername=(TextView)findViewById(R.id.pensionernametextview);
        pensionname=(TextView)findViewById(R.id.pensionnametextview);
        membername=(TextView)findViewById(R.id.membername);
        membergender=(TextView)findViewById(R.id.membergender);
        memberage=(TextView)findViewById(R.id.memberage);
        memberoccupation=(TextView)findViewById(R.id.memberoccupation);
        memberaadhar=(TextView)findViewById(R.id.memberaadhare);




        addmember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String no =addno.getText().toString().trim();

                if(no.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), " field empty", Toast.LENGTH_SHORT).show();

                }
                else {
                     memnum = Integer.parseInt(no);
                    membername.setVisibility(View.VISIBLE);
                    membergender.setVisibility(View.VISIBLE);
                    memberage.setVisibility(View.VISIBLE);
                    memberoccupation.setVisibility(View.VISIBLE);
                    memberaadhar.setVisibility(View.VISIBLE);
                    addmember.setEnabled(false);

                    for (int i = 0; i < memnum; i++) {
                        TableRow tableRow=new TableRow(getApplicationContext());
                        tableLayout1.addView(tableRow);
                        e1 = new EditText(getApplicationContext());
                        e1.setHint("                         ");
                        e1.setId(i);
                        tableRow.addView(e1);
                        e2 = new EditText(getApplicationContext());
                        e2.setHint("                 ");
                        e2.setId(i+memnum);
                        tableRow.addView(e2);
                        e3 = new EditText(getApplicationContext());
                        e3.setHint("           ");
                        e3.setId(i + 2*memnum);
                        tableRow.addView(e3);
                        e4 = new EditText(getApplicationContext());
                        e4.setHint("                           ");
                        e4.setId(i + 3 * memnum);
                        tableRow.addView(e4);
                        e5=new EditText(getApplicationContext());
                        e5.setHint("                 ");
                        e5.setId(i + 4 * memnum);
                        memberviewer.setVisibility(View.VISIBLE);
                        memberdelete.setVisibility(View.VISIBLE);


                    }
                }


            }
        });
        memberviewer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 membernamearray =new String[memnum];
                 membergenderarray =new String[memnum];
                 memberagearray =new String[memnum];
                 memberoccupationarray =new String[memnum];
                for(int i=0;i<memnum;i++)
                {
                    e1=(EditText)findViewById(i);
                    String s1=e1.getText().toString().trim();
                    membernamearray[i]=s1;
                    e2=(EditText)findViewById(i+memnum);
                    String s2=e2.getText().toString().trim();
                    membergenderarray[i]=s2;
                    e3=(EditText)findViewById(i+2*memnum);
                    String s3=e3.getText().toString().trim();
                    memberagearray[i]=s3;
                    e4=(EditText)findViewById(i+3*memnum);
                    String s4=e4.getText().toString().trim();
                    memberoccupationarray[i]=s4;
                }

            }
        });

        memberdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tableLayout1.removeAllViews();
                addmember.setEnabled(true);


            }
        });
        pensionradio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.pensionno : pensionvalue = ((RadioButton)findViewById(pensionradio.getCheckedRadioButtonId())).getText().toString();
                        Toast.makeText(getApplicationContext(), pensionvalue, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.pensionyes : pensionvalue = ((RadioButton)findViewById(pensionradio.getCheckedRadioButtonId())).getText().toString();
                        pensionadd.setVisibility(View.VISIBLE);
                        pensionno.setVisibility(View.VISIBLE);

                        break;

                }
            }
        });



        pensionadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pennum=pensionno.getText().toString().trim();
                if(pennum.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), " field empty", Toast.LENGTH_SHORT).show();

                }
                else
                {
                     n = Integer.parseInt(pennum);
                    pensionadd.setEnabled(false);
                    pensionername.setVisibility(View.VISIBLE);
                    pensionname.setVisibility(View.VISIBLE);

                    for (int j = 200; j <n+200 ; j++) {
                        tableRow2=new TableRow(getApplicationContext());
                        tableLayout2.addView(tableRow2);
                        e5 = new EditText(getApplicationContext());
                        e5.setHint("                            ");
                        e5.setId(j);
                        tableRow2.addView(e6);
                        TextView t=new TextView(getApplicationContext());
                        t.setText("          ");
                        e6 = new EditText(getApplicationContext());
                        e6.setHint("                            ");
                        e6.setId(j+n);
                        tableRow2.addView(e7);



                    }
                    pensionsave.setVisibility(View.VISIBLE);

                    pensiondel.setVisibility(View.VISIBLE);



                }


            }
        });
        pensionsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pensionernamearray =new String[n];
                pensionnamearray =new String[n];
                for(int j=0;j<n;j++) {

                        e1 = (EditText) findViewById(j+200);
                        String s1 = e1.getText().toString().trim();
                        pensionernamearray[j] = s1;
                        e2 = (EditText) findViewById(j +200+ n);
                        String s2 = e2.getText().toString().trim();
                        pensionnamearray[j] = s2;

                    }

            }
        });
        pensiondel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int  n=Integer.parseInt(pensionno.getText().toString().trim());

                tableLayout2.removeAllViews();
                    pensionadd.setEnabled(true);




            }
        });


        aplbplradio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                aplbplvalue = ((RadioButton)findViewById(aplbplradio.getCheckedRadioButtonId())).getText().toString().trim();

            }
        });
        casteradio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                castevalue = ((RadioButton)findViewById(casteradio.getCheckedRadioButtonId())).getText().toString().trim();

            }
        });

        differradio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.dapno : dapvalue = ((RadioButton)findViewById(differradio.getCheckedRadioButtonId())).getText().toString();
                        Toast.makeText(getApplicationContext(), dapvalue, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.dapyes : dapvalue = ((RadioButton)findViewById(differradio.getCheckedRadioButtonId())).getText().toString();
                    lineardiffer.setVisibility(View.VISIBLE);

                        break;

                }

            }
        });

        difadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String difpatient=difname.getText().toString().trim();
                Toast.makeText(getApplicationContext(), difpatient, Toast.LENGTH_SHORT).show();


            }
        });


        disableradio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.accidentno : disvalue = ((RadioButton)findViewById(differradio.getCheckedRadioButtonId())).getText().toString();
                        Toast.makeText(getApplicationContext(), dapvalue, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.accidentyes : disvalue = ((RadioButton)findViewById(differradio.getCheckedRadioButtonId())).getText().toString();
                        lineardisable.setVisibility(View.VISIBLE);

                        break;

                }


            }
        });
        disadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dispatient=disname.getText().toString().trim();
                Toast.makeText(getApplicationContext(), dispatient, Toast.LENGTH_SHORT).show();

            }
        });


        diseaseradio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.dapno : diseasevalue = ((RadioButton)findViewById(differradio.getCheckedRadioButtonId())).getText().toString();
                        Toast.makeText(getApplicationContext(), dapvalue, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.dapyes : diseasevalue = ((RadioButton)findViewById(differradio.getCheckedRadioButtonId())).getText().toString();
                        lineardisease.setVisibility(View.VISIBLE);

                        break;

                }


            }
        });
        diseadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String disepatient=disename.getText().toString().trim();
                String diseasename=disease.getSelectedItem().toString().trim();
                Toast.makeText(getApplicationContext(), disepatient, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), diseasename, Toast.LENGTH_SHORT).show();
            }
        });



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ifam=new Intent(getApplicationContext(),entryasset.class);
                startActivity(ifam);




            }
        });






    }
}
