package com.example.michalis.apiexample.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by michalis on 3/20/2017.
 */

public class LoginResponse {
    @SerializedName("username")
    private String username;
    @SerializedName("message")
    private String message;
    @SerializedName("group")
    private String group;
    @SerializedName("name")
    private String name;
    @SerializedName("profileImg")
    private String profileImg;

    public String getUsername() {
        return username;
    }
}
