package com.example.aaryarshankar.attendance;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    EditText user, password;
    Button submit;
    CheckBox show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.pswrd);
        submit=(Button)findViewById(R.id.submit);
        show=(CheckBox)findViewById(R.id.show);
        String sb;
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=user.getText().toString();
                String pswrd=password.getText().toString();
                if(username.equals("admin") && pswrd.equals("admin")) {
                    Intent i=new Intent(Login.this,ChooseSemester.class);
                    startActivity(i);
                }
                else {
                    //add code for invalid login id and password here
                }
            }
        });
        //add code for show password here

    }
}
