package com.example.michalis.apiexample.api;

import android.util.Log;

import com.example.michalis.apiexample.api.ApiClient;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by michalis on 3/20/2017.
 */

public class ReceivedCookiesInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());

        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            HashSet<String> cookies = new HashSet<>();
            for (String header : originalResponse.headers("Set-Cookie")) {
                cookies.add(header);
                String[] headers = header.split(";");

                for (int i=0; i<headers.length; i++){
                    String cookie = headers[0].trim();
                    if (cookie.substring(0, "csrftoken".length()+1).equals("csrftoken=")){
                        ApiClient.setCsrfToken(cookie.substring("csrftoken".length()+1));
                    }
                    if (cookie.substring(0, "sessionid".length()+1).equals("sessionid=")){
                        ApiClient.setSessionId(cookie.substring("sessionid".length()+1));
                    }
                }
            }
        }
        return originalResponse;
    }
}
