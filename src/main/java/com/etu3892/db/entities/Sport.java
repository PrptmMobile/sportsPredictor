package com.etu3892.db.entities;

/**
 * Created by Artemka on 17.09.2016.
 */
public class Sport {
    private int sportId;
    private String sport;

    public Sport(int sportId, String sport) {
        this.sportId = sportId;
        this.sport = sport;
    }

    public int getSportId() {
        return sportId;
    }

    public void setSportId(int sportId) {
        this.sportId = sportId;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }
}
