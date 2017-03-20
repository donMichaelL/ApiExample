package com.example.michalis.apiexample.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by michalis on 3/20/2017.
 */

public class RaceResponse {
    @SerializedName("count")
    private int count;
    @SerializedName("next")
    private String next;
    @SerializedName("previous")
    private String previous;
    @SerializedName("results")
    private ArrayList<Race> raceArrayList;

    public int getCount() {
        return count;
    }

    public ArrayList<Race> getRaceArrayList() {
        return raceArrayList;
    }
}
