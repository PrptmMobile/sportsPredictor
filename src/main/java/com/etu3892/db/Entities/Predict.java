package com.etu3892.db.Entities;


public class Predict {
    private int predictId;
    private int matchId;
    private int userId;
    private int homePr;
    private int awatPr;
    private int points;

    public Predict(int predictId, int matchId, int userId, int homePr, int awatPr, int points) {
        this.predictId = predictId;
        this.matchId = matchId;
        this.userId = userId;
        this.homePr = homePr;
        this.awatPr = awatPr;
        this.points = points;
    }

    public int getPredictId() {
        return predictId;
    }

    public void setPredictId(int predictId) {
        this.predictId = predictId;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getHomePr() {
        return homePr;
    }

    public void setHomePr(int homePr) {
        this.homePr = homePr;
    }

    public int getAwatPr() {
        return awatPr;
    }

    public void setAwatPr(int awatPr) {
        this.awatPr = awatPr;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
