package com.example.michalis.apiexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.michalis.apiexample.api.ApiClient;
import com.example.michalis.apiexample.api.ApiInterface;
import com.example.michalis.apiexample.models.LoginResponse;
import com.example.michalis.apiexample.models.LogoutResponse;
import com.example.michalis.apiexample.models.Race;
import com.example.michalis.apiexample.models.RaceResponse;

import java.io.IOException;
import java.net.CookieStore;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Headers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();

    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void loginUser(View view) {
        String username = "admin";
        String password = "intellia";

        Call<LoginResponse> responseCall = apiInterface.loginUser(username, password);
        responseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "Response Successful");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
            }
        });

    }

    public void logoutUser(View view) {
        Call<LogoutResponse> logoutResponseCall = apiInterface.logoutUser();
        logoutResponseCall.enqueue(new Callback<LogoutResponse>() {
            @Override
            public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "Logout Successful");
                }
            }
            @Override
            public void onFailure(Call<LogoutResponse> call, Throwable t) {
            }
        });
    }

    public void getRaces(View view) {
        apiInterface = ApiClient.createRetrofitInstance()
                .create(ApiInterface.class);
        Call<RaceResponse> raceResponseCall = apiInterface.gettingRaces();
        Log.d(TAG, raceResponseCall.request().toString());
        raceResponseCall.enqueue(new Callback<RaceResponse>() {
            @Override
            public void onResponse(Call<RaceResponse> call, Response<RaceResponse> response) {
                if (response.isSuccessful()) {
                    RaceResponse response1 = response.body();
                    Log.d(TAG, Integer.toString(response1.getCount()));
                    ArrayList<Race> arrayList = response1.getRaceArrayList();
                    for(Race race: arrayList){
                        Log.d(TAG, race.getParticipationStatus());
                    }
                }
            }

            @Override
            public void onFailure(Call<RaceResponse> call, Throwable t) {
            }
        });
    }
}
