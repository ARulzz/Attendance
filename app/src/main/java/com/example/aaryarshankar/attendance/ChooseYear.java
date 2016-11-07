package com.example.aaryarshankar.attendance;

import android.content.Intent;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ChooseYear extends AppCompatActivity {

    Button y1,y2,y3,y4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_year);
        Bundle bundle=getIntent().getExtras();
        String name="NULL";
        if(bundle!=null){
        name=bundle.getString("name");
        Log.d("user",name);}
        TextView logname=(TextView)findViewById(R.id.loguser);
        logname.setText(name);
        y1=(Button)findViewById(R.id.first);
        y2=(Button)findViewById(R.id.second);
        y3=(Button)findViewById(R.id.third);
        y4=(Button)findViewById(R.id.fourth);
        y2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set yr variable as 2.....
                Global.year=2;
                Intent i=new Intent(ChooseYear.this,ChooseBranch.class);
                startActivity(i);
            }
        });
    }
}
