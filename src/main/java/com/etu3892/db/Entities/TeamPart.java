package com.etu3892.db.entities;



public class TeamPart {
    private int teampartId;
    private League league;
    private Team team;
    private int pld;
    private int gs;
    private int gc;
    private int pts;



    public TeamPart(int teampartId, League league, Team team, int pld, int gs, int gc, int pts) {
        this.teampartId = teampartId;
        this.league = league;
        this.team = team;
        this.pld = pld;
        this.gs = gs;
        this.gc = gc;
        this.pts = pts;
    }

    public TeamPart(int teampartId) {
        this.teampartId = teampartId;
    }

    public int getPld() {
        return pld;
    }

    public void setPld(int pld) {
        this.pld = pld;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public TeamPart(int teampartId, League league, Team team, int pld) {
        this.teampartId = teampartId;
        this.league = league;
        this.team = team;
        this.pld = pld;

    }

    public int getTeampartId() {
        return teampartId;
    }

    public void setTeampartId(int teampartId) {
        this.teampartId = teampartId;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getGs() {
        return gs;
    }

    public void setGs(int gs) {
        this.gs = gs;
    }

    public int getGc() {
        return gc;
    }

    public void setGc(int gc) {
        this.gc = gc;
    }

    public int getPts() {
        return pts;
    }
}
