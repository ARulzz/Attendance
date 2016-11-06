package com.example.aaryarshankar.attendance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseBranch extends AppCompatActivity {

    Button ae, ce, cs, ec, ie, me, back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_branch);
        ae=(Button)findViewById(R.id.ae);
        ce=(Button)findViewById(R.id.ce);
        cs=(Button)findViewById(R.id.cs);
        ec=(Button)findViewById(R.id.ec);
        ie=(Button)findViewById(R.id.ie);
        me=(Button)findViewById(R.id.me);
        back=(Button)findViewById(R.id.back);
        cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.branch="cs";
                Intent i=new Intent(ChooseBranch.this,ChooseSubject.class);
                startActivity(i);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.year=0;
                Intent i=new Intent(ChooseBranch.this,ChooseYear.class);
                startActivity(i);
            }
        });

    }
}
