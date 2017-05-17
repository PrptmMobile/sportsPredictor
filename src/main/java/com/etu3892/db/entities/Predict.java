package com.etu3892.db.entities;


public class Predict {
    private int predictId;
    private Match match;
    private User user;
    private int homePr;
    private int awayPr;
    private int points;

    public Predict(int predictId, Match match, User user, int homePr, int awayPr, int points) {
        this.predictId = predictId;
        this.match= match;
        this.user = user;
        this.homePr = homePr;
        this.awayPr = awayPr;
        this.points = points;
    }

    public Predict(int predictId, Match match, User user, int homePr, int awayPr) {
        this.predictId = predictId;
        this.match = match;
        this.user = user;
        this.homePr = homePr;
        this.awayPr = awayPr;
    }

    public Predict(int predictId) {
        this.predictId = predictId;
    }

    public int getPredictId() {
        return predictId;
    }

    public void setPredictId(int predictId) {
        this.predictId = predictId;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getHomePr() {
        return homePr;
    }

    public void setHomePr(int homePr) {
        this.homePr = homePr;
    }

    public int getAwayPr() {
        return awayPr;
    }

    public void setAwayPr(int awayPr) {
        this.awayPr = awayPr;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
