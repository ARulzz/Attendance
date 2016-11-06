package com.example.aaryarshankar.attendance;

import com.google.gson.annotations.SerializedName;

/**
 * Created by amrith on 11/6/16.
 */

public class RegResponse {

    @SerializedName("success")
    public boolean success;
    @SerializedName("msg")
    public String msg;
}
