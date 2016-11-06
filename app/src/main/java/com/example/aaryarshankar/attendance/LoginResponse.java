package com.example.aaryarshankar.attendance;

import com.google.gson.annotations.SerializedName;

/**
 * Created by amrith on 11/6/16.
 */
public class LoginResponse
{
    @SerializedName("success")
    public boolean success;
    @SerializedName("token")
    public String token;
    @SerializedName("data")
    public Data data;
    public boolean isSuccess(){
        return success;
    }
    public String getToken(){
        return token;
    }
    public Data getData(){
        return data;
    }
}
class Data
{
    @SerializedName("_id")
    public String _id;
    @SerializedName("name")
    public String name;
    @SerializedName("sex")
    public String sex;
    @SerializedName("age")
    public int age;
    @SerializedName("address")
    public String address;
    @SerializedName("contact")
    public long contact;
    @SerializedName("email")
    public String email;
    @SerializedName("password")
    public String password;
    @SerializedName("__v")
    public int __v;
    public String getName(){
        return name;
    }
}
