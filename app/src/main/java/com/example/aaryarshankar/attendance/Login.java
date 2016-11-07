package com.example.aaryarshankar.attendance;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {

    EditText user, password;
    Button login;
    CheckBox show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.pswrd);
        login=(Button)findViewById(R.id.login);
        show=(CheckBox)findViewById(R.id.show);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://104.245.33.9:1983/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                RestApiInterface service = retrofit.create(RestApiInterface.class);
                final LoginReq loginReq=new LoginReq();
                String phone=user.getText().toString();
                String pswrd=password.getText().toString();
                loginReq.phone=Long.parseLong(phone);
                loginReq.password=pswrd;
                int status=0;
                Call<LoginResponse> loginResponseCall=service.getLogin(loginReq);
                loginResponseCall.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        int status=response.code();
                        LoginResponse   loginResponse=response.body();
                        Log.d("Response","resp "+status);
                        Log.d("Data",String.valueOf(loginResponse.isSuccess()));
                        if(status==200 && loginResponse.isSuccess()) {
                            Intent i=new Intent(Login.this,ChooseYear.class);
                            i.putExtra("name",loginResponse.getData().getName());
                            startActivity(i);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Invalid credentials.\nPlease try again.", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Log.d("Response",t.getMessage());
                    }
                });
            }
        });
        //add code for show password here

    }
}
