package com.example.aaryarshankar.attendance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseSubject extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_subject);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        b6=(Button)findViewById(R.id.b6);
        b7=(Button)findViewById(R.id.b7);
        b8=(Button)findViewById(R.id.b8);
        back=(Button)findViewById(R.id.back);
        //if(yr==2 && br.equals("cs")
        b1.setText("DCS");
        b2.setText("DSA");
        b3.setText("EDC");
        b4.setText("Life_Skills");
        b5.setText("Maths");
        b6.setText("STLD");
        b7.setText("Data_Structures_Lab");
        b8.setText("Electronics_Lab");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set sub variable to "dcs"
                Global.subject="dcs";
                Intent i=new Intent(ChooseSubject.this,S3CS.class);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set sub variable to "dsa"
                Global.subject="dsa";
                Intent i=new Intent(ChooseSubject.this,S3CS.class);
                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set sub variable to "edc"
                Global.subject="edc";
                Intent i=new Intent(ChooseSubject.this,S3CS.class);
                startActivity(i);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set sub variable to "ls" for life skills
                Global.subject="ls";
                Intent i=new Intent(ChooseSubject.this,S3CS.class);
                startActivity(i);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set sub variable to "maths"
                Global.subject="maths";
                Intent i=new Intent(ChooseSubject.this,S3CS.class);
                startActivity(i);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set sub variable to "stld"
                Global.subject="stld";
                Intent i=new Intent(ChooseSubject.this,S3CS.class);
                startActivity(i);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set sub variable to "dslab"
                Global.subject="dslab";
                Intent i=new Intent(ChooseSubject.this,S3CS.class);
                startActivity(i);
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set sub variable to "eclab"
                Global.subject="eclab";
                Intent i=new Intent(ChooseSubject.this,S3CS.class);
                startActivity(i);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set branch variable to ""
                Global.branch=null;
                Intent i=new Intent(ChooseSubject.this,ChooseBranch.class);
                startActivity(i);
            }
        });
    }
}
