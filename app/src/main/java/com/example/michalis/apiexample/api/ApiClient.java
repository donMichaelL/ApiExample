package com.example.michalis.apiexample.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by michalis on 3/20/2017.
 */

public class ApiClient {
    private static final String BASE_URL = "http://annadi.di.uoa.gr:8001";
    private static String CSRF_TOKEN = "q81QvZQxXJxXPllEBU5NGMIFau59ivtr";
    private static String SESSION_ID = "";

    public static Retrofit retrofit;

    public static Retrofit createRetrofitInstance(){
        if (retrofit == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient defaultClinet = new OkHttpClient.Builder()
                    .addInterceptor(new AddCookieInterceptor())
                    .addInterceptor(new ReceivedCookiesInterceptor())
                    .addInterceptor(logging)
                    .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(defaultClinet)
                    .build();
        }
        return retrofit;
    }

    public static String getCsrfToken() {
        return CSRF_TOKEN;
    }

    public static void setCsrfToken(String csrfToken) {
        CSRF_TOKEN = csrfToken;
    }

    public static String getSessionId() {
        return SESSION_ID;
    }

    public static void setSessionId(String sessionId) {
        SESSION_ID = sessionId;
    }
}
