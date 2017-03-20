package com.example.michalis.apiexample.api;

import com.example.michalis.apiexample.models.LoginResponse;
import com.example.michalis.apiexample.models.LogoutResponse;
import com.example.michalis.apiexample.models.RaceResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by michalis on 3/20/2017.
 */

public interface ApiInterface {
    @GET("races/")
    Call<RaceResponse> gettingRaces();

    @POST("user/login/")
    @FormUrlEncoded
    Call<LoginResponse> loginUser(@Field("login") String username, @Field("password") String password);

    @POST("user/logout/")
    Call<LogoutResponse> logoutUser();

}
