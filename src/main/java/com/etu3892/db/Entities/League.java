package com.etu3892.db.Entities;


public class League {
    private int leagueId;
    private String league;
    private int countryId;
    private int sportId;

    public League(int leagueId, String league, int countryId, int sportId) {
        this.leagueId = leagueId;
        this.league = league;
        this.countryId = countryId;
        this.sportId = sportId;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getSportId() {
        return sportId;
    }

    public void setSportId(int sportId) {
        this.sportId = sportId;
    }
}
