package com.example.aaryarshankar.attendance;

//import android.app.AlertDialog;
//import android.support.v7.app.AlertDialog;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

public class S3CS extends AppCompatActivity {

    Button check, submit;
    boolean confirmed=false;
    int count=0;
    CheckBox[] checkBox =new CheckBox[Global.nstuds];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s3_cs);
        check=(Button)findViewById(R.id.check);
        submit=(Button)findViewById(R.id.submit);
        LinearLayout rollList = (LinearLayout)findViewById(R.id.rollList);
        for (int i = 0; i < Global.nstuds; i++)
        {
            checkBox[i] = new CheckBox(this);
            checkBox[i].setId(i);
            checkBox[i].setText("Roll No. "+(i+1));
            checkBox[i].setTextSize(20);
            rollList.addView(checkBox[i]);
        }
        check.setOnClickListener(new View.OnClickListener() {
            String disp="";
            int j=0;
            @Override
            public void onClick(View v) {
                for (int i = 0; i < Global.nstuds; i++)
                {
                    if(checkBox[i].isChecked()) {
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
                confirmed=true;
                if(confirmed) {
                    //etho panni cheyyende part
                    Toast.makeText(getApplicationContext(), "Successfully Submitted", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
