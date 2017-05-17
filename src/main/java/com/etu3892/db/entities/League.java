package com.etu3892.db.entities;


public class League {
    private int leagueId;
    private String league;
    private Country country;
    private Sport sport;

    public League(int leagueId, String league, Country country, Sport sport) {
        this.leagueId = leagueId;
        this.league = league;
        this.country = country;
        this.sport = sport;
    }

    public League(int leagueId) {
        this.leagueId = leagueId;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }
}
