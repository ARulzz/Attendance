package com.example.aaryarshankar.attendance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class ChooseSemester extends AppCompatActivity {

    Button y1,y2,y3,y4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_semester);
        y1=(Button)findViewById(R.id.first);
        y2=(Button)findViewById(R.id.first);
        y3=(Button)findViewById(R.id.first);
        y4=(Button)findViewById(R.id.first);

    }
}
