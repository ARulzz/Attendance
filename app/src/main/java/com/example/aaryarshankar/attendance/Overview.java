package com.example.aaryarshankar.attendance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Overview extends AppCompatActivity {

    TextView userName, yEar, bRanch, sUbject, absentees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);
        userName=(TextView)findViewById(R.id.userName);
        yEar=(TextView)findViewById(R.id.yEar);
        bRanch=(TextView)findViewById(R.id.bRanch);
        sUbject=(TextView)findViewById(R.id.sUbject);
        absentees=(TextView)findViewById(R.id.absentees);
        userName.setText(Global.userNaMe);
        yEar.setText(String.valueOf(Global.year));
        bRanch.setText(Global.branch.toUpperCase());
        sUbject.setText(Global.subject.toUpperCase());
        absentees.setText(Global.absenteesOverview);
    }
}
