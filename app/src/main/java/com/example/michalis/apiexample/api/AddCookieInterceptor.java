package com.example.michalis.apiexample.api;

import android.util.Log;

import com.example.michalis.apiexample.api.ApiClient;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by michalis on 3/20/2017.
 */

public class AddCookieInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        builder.header("Cookie", "csrftoken=" + ApiClient.getCsrfToken()
               + ";sessionid=" + ApiClient.getSessionId());
        builder.header("X-CSRFToken", ApiClient.getCsrfToken());
        return chain.proceed(builder.build());
    }

}
