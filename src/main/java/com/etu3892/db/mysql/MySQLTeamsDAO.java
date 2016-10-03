package com.etu3892.db.mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.etu3892.db.entities.Team;


public class MySQLTeamsDAO {

    public List getNnStTeams() throws SQLException {
        List teamsList = new ArrayList<Team>();
        String tryquery = "select * from teams where team <> 'None'";
        ResultSet rs1 = DBConnector.getSet(tryquery);
        while (rs1.next()) {
            Team team = new Team(rs1.getInt("teamId"),rs1.getString("team"), MySQLSportsDAO.getById(rs1.getInt("sportId")), MySQLCountriesDAO.getCountryById(rs1.getInt("countryId")));
            teamsList.add(team);
        }

        return teamsList;
    }

    public static List getTeams() throws SQLException {
        List teamsList = new ArrayList<Team>();
        String tryquery = "select * from teams where team <> 'None'";
        ResultSet rs1 = DBConnector.getSet(tryquery);
        while (rs1.next()) {
            Team team = new Team(rs1.getInt("teamId"),rs1.getString("team"), MySQLSportsDAO.getById(rs1.getInt("sportId")), MySQLCountriesDAO.getCountryById(rs1.getInt("countryId")));
            teamsList.add(team);
        }

        return teamsList;
    }

    public static List getTeamsBySportAndCountry(int sportId,int countryId) throws SQLException {
        List teamsList = new ArrayList<Team>();
        String tryquery = "select * from teams where countryId="+countryId+" and sportId="+sportId;
        ResultSet rs1 = DBConnector.getSet(tryquery);
        while (rs1.next()) {
            Team team = new Team(rs1.getInt("teamId"),rs1.getString("team"), MySQLSportsDAO.getById(rs1.getInt("sportId")), MySQLCountriesDAO.getCountryById(rs1.getInt("countryId")));
            teamsList.add(team);
        }

        return teamsList;
    }

    public static Team getTeamById(int id) throws SQLException {
        String tryquery = "select * from teams where teamId="+id;
        ResultSet rs1 = DBConnector.getSet(tryquery);
        rs1.next();
        return new Team(rs1.getInt("teamId"),rs1.getString("team"), MySQLSportsDAO.getById(rs1.getInt("sportId")), MySQLCountriesDAO.getCountryById(rs1.getInt("countryId")));
    }

    public static void addTeam (Team team) throws SQLException {
        String tryquery = "insert into teams values ("+team.getTeamId()+",'"+team.getTeam()+"',"+team.getSport().getSportId()+","+team.getCountry().getCountryId()+")";
        DBConnector.execute(tryquery);
    }

    public static void updateTeam (Team team) throws SQLException {
        String tryquery = "update teams set team='"+team.getTeam()+"', countryId="+team.getCountry().getCountryId()+", sportId="+team.getSport().getSportId()+" where teamId="+team.getTeamId();
        DBConnector.execute(tryquery);
    }

    public static void removeTeam (Team team) throws SQLException {
        String tryquery = "delete from teams where teamId="+team.getTeamId();
        DBConnector.execute(tryquery);
    }


}
