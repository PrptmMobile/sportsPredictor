package com.etu3892.db.mysql;


import com.etu3892.db.entities.Match;
import com.etu3892.db.entities.Predict;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class MySQLPredictDAO {
    public static Predict findById(int id) throws SQLException{
        String query = "select * from predicts where predictId="+id;
        ResultSet set = DBConnector.getSet(query);
        while (set.next()) {
            return new Predict(set.getInt("predictId"), MySQLMatchDAO.findById(set.getInt("matchId")), MySQLUserDAO.findUserById(set.getInt("userId")),set.getInt("homePr"),set.getInt("awayPr"),set.getInt("points"));
        }
        return null;
    }
    public static List findNotComputedPredicts(int userid,int leagueid) throws SQLException{
        List predicts = new LinkedList<Predict>();
        String query = "select * from predicts, matches where predicts.matchId=matches.matchId and leagueId="+leagueid+" and userId="+userid+" and points is null";
        ResultSet set = DBConnector.getSet(query);
        while (set.next()) {
            predicts.add(new Predict(set.getInt("predictId"), MySQLMatchDAO.findById(set.getInt("matchId")), MySQLUserDAO.findUserById(set.getInt("userId")), set.getInt("homePr"), set.getInt("awayPr"), set.getInt("points")));
        }

        return predicts;
    }
    public static List findComputedPredicts(int userid,int leagueid) throws SQLException{
        List predicts = new LinkedList<Predict>();
        String query = "select * from predicts, matches where predicts.matchId=matches.matchId and leagueId="+leagueid+" and userId="+userid+" and points is not null";
        ResultSet set = DBConnector.getSet(query);
        while (set.next()) {
            predicts.add(new Predict(set.getInt("predictId"), MySQLMatchDAO.findById(set.getInt("matchId")), MySQLUserDAO.findUserById(set.getInt("userId")), set.getInt("homePr"), set.getInt("awayPr"), set.getInt("points")));
        }

        return predicts;
    }

    public static Predict findByUserIdAndMatchId(int userid,int matchid) throws SQLException{
        String query = "select * from predicts where matchId="+matchid+" and userId="+userid;
        ResultSet set = DBConnector.getSet(query);
        while (set.next()) {
            return new Predict(set.getInt("predictId"), MySQLMatchDAO.findById(set.getInt("matchId")), MySQLUserDAO.findUserById(set.getInt("userId")),set.getInt("homePr"),set.getInt("awayPr"),set.getInt("points"));
            }
        return null;
    }

    public static List findByUserId(int userId) throws SQLException {
        List predicts = new LinkedList<Predict>();
        String query = "select * from predicts where userId=" + userId;
        ResultSet set = DBConnector.getSet(query);
        while (set.next()) {
            predicts.add(new Predict(set.getInt("predictId"), MySQLMatchDAO.findById(set.getInt("matchId")), MySQLUserDAO.findUserById(set.getInt("userId")), set.getInt("homePr"), set.getInt("awayPr"), set.getInt("points")));
        }

        return predicts;
    }
    public static List findByMatch(Match match) throws SQLException {
        List predicts = new LinkedList<Predict>();
        String query = "select * from predicts where matchId=" + match.getMatchId();
        ResultSet set = DBConnector.getSet(query);
        while (set.next()) {
            predicts.add(new Predict(set.getInt("predictId"), MySQLMatchDAO.findById(set.getInt("matchId")), MySQLUserDAO.findUserById(set.getInt("userId")), set.getInt("homePr"), set.getInt("awayPr"), set.getInt("points")));
        }

        return predicts;
    }
    public static void add(Predict predict) throws SQLException{
        if(null==findByUserIdAndMatchId(predict.getUser().getUserId(),predict.getMatch().getMatchId())) {
            String query = "insert into predicts values (0," + predict.getMatch().getMatchId() + "," + predict.getUser().getUserId() + "," + predict.getHomePr() + "," + predict.getAwayPr() + ",null)";
            DBConnector.execute(query);
        } else updateOnlyScore(predict);
    }

    public static void updateOnlyScore(Predict predict) throws SQLException{
        String query = "update predicts set homePr="+predict.getHomePr()+", awayPr="+predict.getAwayPr()+" where predictId="+predict.getPredictId();
        DBConnector.execute(query);
    }

    public static void updatePts(Predict predict) throws SQLException{
        String query = "update predicts set points="+predict.getPoints()+" where predictId="+predict.getPredictId();
        DBConnector.execute(query);
    }

    public static void remove(Predict predict) {

    }


}
