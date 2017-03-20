package com.example.michalis.apiexample.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by michalis on 3/20/2017.
 */

public class Race {
    @SerializedName("id")
    private int id;
    @SerializedName("iteration")
    private int iteration;
    @SerializedName("poster")
    private String poster;
    @SerializedName("participation_status")
    private String participationStatus;

    public int getIteration() {
        return iteration;
    }

    public String getParticipationStatus() {
        return participationStatus;
    }
}
