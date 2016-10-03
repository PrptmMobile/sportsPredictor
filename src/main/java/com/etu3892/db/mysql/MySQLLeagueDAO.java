package com.etu3892.db.mysql;


import com.etu3892.db.entities.League;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLLeagueDAO {
    public static List getLeagues() throws SQLException {
        List leaguesList = new ArrayList<League>();
        String tryquery = "select * from leagues where league <> 'None'";
        ResultSet rs1 = DBConnector.getSet(tryquery);
        while (rs1.next()) {
            League league = new League(rs1.getInt("leagueId"),rs1.getString("league"), MySQLCountriesDAO.getCountryById(rs1.getInt("countryId")), MySQLSportsDAO.getById(rs1.getInt("sportId")));
            leaguesList.add(league);
        }

        return leaguesList;
    }

    public List getBeanLeagues() throws SQLException {
        return getLeagues();
    }

    public static League getById (int id) throws SQLException {
        String tryquery = "select * from leagues where leagueId="+id;
        ResultSet rs1 = DBConnector.getSet(tryquery);
        rs1.next();
        return new League(rs1.getInt("leagueId"),rs1.getString("league"), MySQLCountriesDAO.getCountryById(rs1.getInt("countryId")), MySQLSportsDAO.getById(rs1.getInt("sportId")));
    }

    public static void addLeague (League league) throws SQLException {
        String tryquery = "insert into leagues values ("+league.getLeagueId()+",'"+league.getLeague()+"',"+league.getCountry().getCountryId()+","+league.getSport().getSportId()+")";
        DBConnector.execute(tryquery);
    }

    public static void updateLeague (League league) throws SQLException {
        String tryquery = "update leagues set league='"+league.getLeague()+"', countryId="+league.getCountry().getCountryId()+", sportId="+league.getSport().getSportId()+" where leagueId="+league.getLeagueId();
        DBConnector.execute(tryquery);
    }

    public static void removeLeague (League league) throws SQLException {
        String tryquery = "delete from leagues where leagueId="+league.getLeagueId();
        DBConnector.execute(tryquery);
    }

}
