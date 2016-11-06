package com.example.aaryarshankar.attendance;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by amrith on 11/6/16.
 */

public interface RestApiInterface {
    @POST("api/signup")
    Call<RegResponse> regResponse(@Body RegRequest regRequest);
    @POST("api/login")
    Call<LoginResponse> getLogin(@Body LoginReq loginReq);
}
