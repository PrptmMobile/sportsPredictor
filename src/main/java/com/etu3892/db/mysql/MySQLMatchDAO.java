package com.etu3892.db.mysql;


import com.etu3892.db.entities.Match;
import com.etu3892.functional.SportsDateTime;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class MySQLMatchDAO {
    public static void addMatch(Match match) throws SQLException {
        String tryquery = "insert into matches (homeId,awayId,leagueId,dt) values ("+match.getHome().getTeamId()+","+match.getAway().getTeamId()+","+match.getLeague().getLeagueId()+",?)";
        DBConnector.executeTime(tryquery, match.getDatetime());
    }

    public static void udpateMatch(Match match) throws SQLException {
        String tryquery = "update matches set homeGls="+match.getHomeGls()+", awayGls="+match.getAwayGls()+" where matchId="+match.getMatchId();
        DBConnector.execute(tryquery);
    }

    public static void removeMatch(Match match) throws SQLException{
        String tryquery = "delete from matches where matchId="+match.getMatchId();
        DBConnector.execute(tryquery);
    }

    public static Match findById (int id) throws SQLException{
        String query = "select * from matches where matchId="+id;
        ResultSet set = DBConnector.getSet(query);
        if (set.wasNull()) return null;
        set.next();
        return new Match(set.getInt("matchId"), MySQLTeamsDAO.getTeamById(set.getInt("homeId")), MySQLTeamsDAO.getTeamById(set.getInt("awayId")), MySQLLeagueDAO.getById(set.getInt("leagueId")), new SportsDateTime(set.getTimestamp("dt")));
    }

    public static List findByLeagueIdFuture(int id) throws SQLException {
        List matches = new LinkedList<Match>();
        String query = "select * from matches where leagueId="+id+" and dt>now() and homeGls is null";
        ResultSet set = DBConnector.getSet(query);

        while (set.next()) {
            Match match = new Match(set.getInt("matchId"), MySQLTeamsDAO.getTeamById(set.getInt("homeId")), MySQLTeamsDAO.getTeamById(set.getInt("awayId")), MySQLLeagueDAO.getById(set.getInt("leagueId")), new SportsDateTime(set.getTimestamp("dt")));
            matches.add(match);
        }

        return matches;
    }

    public static List getResultsOfLeague(int id) throws SQLException {
        List matches = new LinkedList<Match>();
        String query = "select * from matches where leagueId="+id+" and homeGls is not null order by dt";
        ResultSet set = DBConnector.getSet(query);

        while (set.next()) {
            Match match = new Match(set.getInt("matchId"), MySQLTeamsDAO.getTeamById(set.getInt("homeId")), MySQLTeamsDAO.getTeamById(set.getInt("awayId")),set.getInt("homeGls"),set.getInt("awayGls"), MySQLLeagueDAO.getById(set.getInt("leagueId")), new SportsDateTime(set.getTimestamp("dt")));
            matches.add(match);
        }

        return matches;
    }

    public static List findByLeagueIdNoResult(int id) throws SQLException {
        List matches = new LinkedList<Match>();
        String query = "select * from matches where leagueId="+id+" and homeGls is null";
        ResultSet set = DBConnector.getSet(query);

        while (set.next()) {
            Match match = new Match(set.getInt("matchId"), MySQLTeamsDAO.getTeamById(set.getInt("homeId")), MySQLTeamsDAO.getTeamById(set.getInt("awayId")), MySQLLeagueDAO.getById(set.getInt("leagueId")), new SportsDateTime(set.getTimestamp("dt")));
            matches.add(match);
        }

        return matches;
    }



}
