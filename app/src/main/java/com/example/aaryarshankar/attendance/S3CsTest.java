package com.example.aaryarshankar.attendance;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class S3CsTest extends AppCompatActivity {

    Button check, submit;
    boolean confirmed=false;
    int count=0, i;
    LinearLayout row;
    Button[] roll =new Button[Global.nstuds];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s3_cs_test);
        check=(Button)findViewById(R.id.check);
        submit=(Button)findViewById(R.id.submit);
        LinearLayout rollList = (LinearLayout)findViewById(R.id.rollList);
        for (i=0; i< Global.nstuds; i++) {
            if (i%4==0) {
                row=new LinearLayout(this);
                row.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                row.setOrientation(LinearLayout.HORIZONTAL);
                rollList.addView(row);
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            //params.leftMargin = 20;
            if(i%4!=3)
            params.rightMargin=20;
            params.topMargin=20;

            //(set params as you need)
            roll[i]=new Button(this);
            roll[i].setId(i);
            //DisplayMetrics displaymetrics = new DisplayMetrics();
            //getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            //int height = displaymetrics.heightPixels;
            //int width = displaymetrics.widthPixels;
            //int temp=height/4;
            roll[i].setText(String.valueOf(i+1));
            //roll[0].setText(String.valueOf(height));
            //roll[1].setText(String.valueOf(temp));
            roll[i].setTextColor(Color.parseColor("#000000"));
            roll[i].setBackgroundColor(Color.parseColor("#B2ff59"));
            //roll[0].setb
            //roll[i].setTextColor(Color.parseColor("#ffffff"));
            //roll[i].setBackgroundColor(Color.parseColor("#B2ff59"));
            roll[i].setTextSize(20);
            //roll[i].setHeight(100);
            //roll[i].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            roll[i].setPadding(0, 0, 0, 0);
            row.addView(roll[i],params);
        }

        for (i=0; i<Global.nstuds; i++) {

            roll[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    roll[i].setBackgroundColor(Color.parseColor("FF3D00"));
                }
            });
        }
    }
}
