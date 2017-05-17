package com.etu3892.db.entities;


import com.etu3892.functional.SportsDateTime;

import java.sql.Timestamp;

public class Match {
    private int matchId;
    private Team home;
    private Team away;
    private int homeGls;
    private int awayGls;
    private League league;
    private SportsDateTime datetime;

    public Match(int matchId, Team home, Team away, int homeGls, int awayGls, League league, SportsDateTime datetime) {
        this.matchId = matchId;
        this.home = home;
        this.away = away;
        this.homeGls = homeGls;
        this.awayGls = awayGls;
        this.league = league;
        this.datetime = datetime;
    }

    public Match(int matchId, Team home, Team away, League league, SportsDateTime datetime) {
        this.matchId = matchId;
        this.home = home;
        this.away = away;
        this.league = league;
        this.datetime = datetime;
    }

    public Match(int matchId) {
        this.matchId = matchId;
    }

    public Match(int matchId, int homeGls, int awayGls, SportsDateTime datetime) {
        this.matchId = matchId;
        this.homeGls = homeGls;
        this.awayGls = awayGls;
        this.datetime = datetime;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public Team getHome() {
        return home;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
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

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(SportsDateTime datetime) {
        this.datetime = datetime;
    }
}
