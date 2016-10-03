package com.etu3892.db.entities;


public class Competition {
    private int competitionId;
    private League league;
    private User user;
    private int points;
    private int scores;

    public Competition(int competitionId, League leagueId, User userId, int points, int scores) {
        this.competitionId = competitionId;
        this.league = leagueId;
        this.user = userId;
        this.points = points;
        this.scores = scores;
    }



    public int getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(int competitionId) {
        this.competitionId = competitionId;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League leagueId) {
        this.league = leagueId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User userId) {
        this.user = userId;
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
