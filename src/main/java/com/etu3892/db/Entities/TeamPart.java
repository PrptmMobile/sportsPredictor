package com.etu3892.db.Entities;



public class TeamPart {
    private int teampartId;
    private int leagueId;
    private int teamId;
    private int gs;
    private int gc;
    private int pts;



    public TeamPart(int teampartId, int leagueId, int teamId, int gs, int gc, int pts) {
        this.teampartId = teampartId;
        this.leagueId = leagueId;
        this.teamId = teamId;
        this.gs = gs;
        this.gc = gc;
        this.pts = pts;
    }

    public int getTeampartId() {
        return teampartId;
    }

    public void setTeampartId(int teampartId) {
        this.teampartId = teampartId;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
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
