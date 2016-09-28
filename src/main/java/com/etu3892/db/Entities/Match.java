package com.etu3892.db.Entities;


import java.sql.Timestamp;

public class Match {
    private int matchId;
    private int homeId;
    private int awayId;
    private int homeGls;
    private int awayGls;
    private int leagueId;
    private Timestamp datetime;

    public Match(int matchId, int homeId, int awayId, int homeGls, int awayGls, int leagueId, Timestamp datetime) {
        this.matchId = matchId;
        this.homeId = homeId;
        this.awayId = awayId;
        this.homeGls = homeGls;
        this.awayGls = awayGls;
        this.leagueId = leagueId;
        this.datetime = datetime;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getHomeId() {
        return homeId;
    }

    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }

    public int getAwayId() {
        return awayId;
    }

    public void setAwayId(int awayId) {
        this.awayId = awayId;
    }

    public int getHomeGls() {
        return homeGls;
    }

    public void setHomeGls(int homeGls) {
        this.homeGls = homeGls;
    }

    public int getAwayGls() {
        return awayGls;
    }

    public void setAwayGls(int awayGls) {
        this.awayGls = awayGls;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }
}
