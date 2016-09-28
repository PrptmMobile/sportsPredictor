package com.etu3892.db.Entities;


public class Competition {
    private int competitionId;
    private int leagueId;
    private int userId;
    private int points;
    private int scores;

    public Competition(int competitionId, int leagueId, int userId, int points, int scores) {
        this.competitionId = competitionId;
        this.leagueId = leagueId;
        this.userId = userId;
        this.points = points;
        this.scores = scores;
    }

    public int getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(int competitionId) {
        this.competitionId = competitionId;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }
}
