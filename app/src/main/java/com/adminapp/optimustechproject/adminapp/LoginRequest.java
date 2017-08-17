package com.adminapp.optimustechproject.adminapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by satyam on 5/8/17.
 */

public interface LoginRequest {

    @GET("skills_req/AdminLogin.php")
    Call<LoginPOJO> requestResponse(@Query("fcm") String fcm);
}
