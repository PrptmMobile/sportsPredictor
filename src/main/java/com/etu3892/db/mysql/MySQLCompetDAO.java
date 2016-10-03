package com.etu3892.db.mysql;



import com.etu3892.db.entities.Competition;
import com.etu3892.db.entities.League;
import com.etu3892.db.entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class MySQLCompetDAO {
    public static Competition findByUserAndLeague(User user, League league) throws SQLException{
        String query = "select * from competitions where userId="+user.getUserId()+" and leagueId="+league.getLeagueId();
        ResultSet set = DBConnector.getSet(query);
        while (set.next()){
            return new Competition(set.getInt("competitionId"), MySQLLeagueDAO.getById(set.getInt("leagueId")), MySQLUserDAO.findUserById(set.getInt("userId")),set.getInt("pts"),set.getInt("scores"));
        }
        return null;
    }
    public static List getRating(int leagueid) throws SQLException{
        List rating = new LinkedList<Competition>();
        String query = "select * from competitions where leagueId="+leagueid+" order by pts desc";
        ResultSet set = DBConnector.getSet(query);
        while (set.next()){
            rating.add(new Competition(set.getInt("competitionId"), MySQLLeagueDAO.getById(set.getInt("leagueId")), MySQLUserDAO.findUserById(set.getInt("userId")),set.getInt("pts"),set.getInt("scores")));
        }
        return rating;
    }
    public static void add(Competition competition) throws SQLException{
        String query = "insert into competitions values(0,"+competition.getLeague().getLeagueId()+" ,"+competition.getUser().getUserId()+" ,"+competition.getPoints()+" ,"+competition.getScores()+")";
        DBConnector.execute(query);
    }
    public static void update(Competition competition) throws SQLException{
        if (null!=findByUserAndLeague(competition.getUser(),competition.getLeague())){
            String query = "update competitions set pts="+competition.getPoints()+", scores="+competition.getScores()+" where competitionId="+competition.getCompetitionId();
            DBConnector.execute(query);
        } else {
            add(competition);
        }
    }
    public static void remove(Competition competition) throws SQLException{
        String query = "delete from competitions where competitionId="+competition.getCompetitionId();
        DBConnector.execute(query);
    }



}
