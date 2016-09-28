package com.etu3892.db.Entities;

/**
 * Created by Artemka on 17.09.2016.
 */
public class Team {
    private int teamId;
    private String team;
    private Sport sport;
    private Country country;

    public Team(int teamId, String team, Sport sport, Country country) {
        this.teamId = teamId;
        this.team = team;
        this.sport = sport;
        this.country = country;
    }

    public Team(int teamId) {
        this.teamId = teamId;
    }

    public int getTeamId() {
        return teamId;
    }

    public String getTeam() {
        return team;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    ///Custom getters
    public String getSportName(){ return sport.getSport();}
    public String getCountryName(){return country.getCountry();}
}
