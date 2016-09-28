package com.etu3892.db;


import com.etu3892.db.DBConnector;
import com.etu3892.db.Entities.Country;
import com.etu3892.db.Entities.League;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeaguesRepository {
    public static List getLeagues() throws SQLException {
        List leaguesList = new ArrayList<League>();
        String tryquery = "select * from leagues where league <> 'None'";
        ResultSet rs1 = DBConnector.getSet(tryquery);
        while (rs1.next()) {
            League league = new League(rs1.getInt("leagueId"),rs1.getString("league"),rs1.getInt("countryId"),rs1.getInt("sportId"));
            leaguesList.add(league);
        }

        return leaguesList;
    }

    public static void addLeague (League league) throws SQLException {
        String tryquery = "insert into leagues values ("+league.getLeagueId()+",'"+league.getLeague()+"',"+league.getCountryId()+","+league.getSportId()+")";
        DBConnector.execute(tryquery);
    }

    public static void updateLeague (League league) throws SQLException {
        String tryquery = "update leagues set league='"+league.getLeague()+"', countryId="+league.getCountryId()+", sportId="+league.getSportId()+" where leagueId="+league.getLeagueId();
        DBConnector.execute(tryquery);
    }

    public static void removeLeague (League league) throws SQLException {
        String tryquery = "delete from leagues where leagueId="+league.getLeagueId();
        DBConnector.execute(tryquery);
    }

}
