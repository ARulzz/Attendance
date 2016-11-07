package com.example.aaryarshankar.attendance;

//import android.app.AlertDialog;
//import android.support.v7.app.AlertDialog;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

public class S3CS extends AppCompatActivity {

    Button check, submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s3_cs);
        check=(Button)findViewById(R.id.check);
        submit=(Button)findViewById(R.id.submit);
        LinearLayout rollList = (LinearLayout)findViewById(R.id.rollList);
        for (int i = 0; i < 70; i++)
        {
            CheckBox checkBox = new CheckBox(this);
            checkBox.setId(i);
            checkBox.setText("Roll No. "+(i+1));
            checkBox.setTextSize(20);
            rollList.addView(checkBox);
        }

        check.setOnClickListener(new View.OnClickListener() {
            int j=0;
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(
                        S3CS.this).create();

                // Setting Dialog Title
                alertDialog.setTitle("Absentees:");

                // Setting Dialog Message
                alertDialog.setMessage("Welcome to AndroidHive.info");

                // Setting Icon to Dialog
                //alertDialog.setIcon(R.drawable.tick);

                // Setting OK Button
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog closed
                        Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                    }
                });

                // Showing Alert Message
                alertDialog.show();
            }
        });



    }
}
