package com.example.aaryarshankar.attendance;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class S3CS extends AppCompatActivity {

    Button check, submit;
    boolean confirmed=false;
    String disp="";
    int count=0;
    LinearLayout row;
    Button[] roll =new Button[Global.nstuds];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s3_cs);
        check=(Button)findViewById(R.id.check);
        submit=(Button)findViewById(R.id.submit);
        LinearLayout rollList = (LinearLayout)findViewById(R.id.rollList);
        final Button[] roll = new Button[Global.nstuds];
        for (int i = 0; i < Global.nstuds; i++) {

            if(i%4==0) {
                row=new LinearLayout(this);
                row.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));
                rollList.addView(row);
            }
            roll[i] = new Button(getApplicationContext());
            roll[i].setText(String.valueOf(i+1));
            roll[i].setTextColor(Color.parseColor("#000000"));
            roll[i].setBackgroundColor(Color.parseColor("#B2ff59"));
            //try to insert space between buttons
            roll[i].setTextSize(20);
            roll[i].setHeight(100);
            roll[i].setTag("true");
            roll[i].setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));
            roll[i].setPadding(15, 5, 15, 5);
            row.addView(roll[i]);
            roll[i].setOnClickListener(handleOnClick(roll[i],i));
        }
        check.setOnClickListener(new View.OnClickListener() {
            int j=0;
            @Override
            public void onClick(View v) {
                for (int i = 0; i < Global.nstuds; i++)
                {
                    if(roll[i].getTag().equals("false")) {
                        Global.absentees[j++]=i+1;
                        disp=disp+", "+String.valueOf(i+1);
                    }
                }
                count=j;
                AlertDialog alertDialog = new AlertDialog.Builder(
                        S3CS.this).create();

                // Setting Dialog Title
                alertDialog.setTitle("Absentees:");

                // Setting Dialog Message
                alertDialog.setMessage(disp.substring(disp.indexOf(" ")+1));
                disp="";

                // Setting Icon to Dialog
                //alertDialog.setIcon(R.drawable.tick);

                // Setting OK Button
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog closed
                        Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                        confirmed=true;
                    }
                });

                // Showing Alert Message
                alertDialog.show();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disp="";
                int t=0;
                for (int i = 0; i < Global.nstuds; i++)
                {
                    if(roll[i].getTag().equals("false")) {
                        Global.absentees[t++]=i+1;
                        disp=disp+", "+String.valueOf(i+1);
                    }
                }
                Global.absenteesOverview=disp.substring(disp.indexOf(" ")+1);
                confirmed=true;
                if(confirmed) {
                    Toast.makeText(getApplicationContext(), "Successfully Submitted", Toast.LENGTH_SHORT).show();
                }
                Intent i=new Intent(S3CS.this,Overview.class);
                startActivity(i);
            }
        });



    }

    View.OnClickListener handleOnClick(final Button button, final int x) {
        return new View.OnClickListener() {
            public void onClick(View v) {
                if(button.getTag().equals("true")) {
                    button.setTag("false");
                    button.setBackgroundColor(Color.parseColor("#ff6e40"));
                    button.setTextColor(Color.parseColor("#ffffff"));
                }
                else {
                    button.setTag("true");
                    button.setBackgroundColor(Color.parseColor("#B2ff59"));
                    button.setTextColor(Color.parseColor("#000000"));
                }
            }
        };
    }


}
