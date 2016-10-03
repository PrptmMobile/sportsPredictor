package com.etu3892.db.mysql;



import com.etu3892.db.entities.Sport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLSportsDAO {
    public List getSports() throws SQLException {
        List sportsList = new ArrayList<Sport>();
        String tryquery = "select * from sports where sport<>'None'";
        ResultSet rs1 = DBConnector.getSet(tryquery);
        while (rs1.next()) {
            Sport sport = new Sport(rs1.getInt("sportId"),rs1.getString("sport"));
            sportsList.add(sport);
        }

        return sportsList;
    }

    public static List getStSports() throws SQLException {
        List sportsList = new ArrayList<Sport>();
        String tryquery = "select * from sports where sport<>'None'";
        ResultSet rs1 = DBConnector.getSet(tryquery);
        while (rs1.next()) {
            Sport sport = new Sport(rs1.getInt("sportId"),rs1.getString("sport"));
            sportsList.add(sport);
        }

        return sportsList;
    }

    public static Sport getById(int id) throws SQLException {
        String tryquery = "select * from sports where sportId="+id;
        ResultSet rs1 = DBConnector.getSet(tryquery);
        rs1.next();
        return new Sport(rs1.getInt("sportId"),rs1.getString("sport"));
    }

    public static void updateSport(Sport sport) throws SQLException {
        String tryquery = "update sports set sport='"+sport.getSport()+"' where sportId="+sport.getSportId();
        DBConnector.execute(tryquery);
    }

    public static void removeSport(Sport sport) throws SQLException {
        String tryquery = "delete from sports where sportId="+sport.getSportId();
        DBConnector.execute(tryquery);
    }

    public static void addSport (Sport sport) throws SQLException {
        String tryquery = "insert into sports values ("+sport.getSportId()+",'"+sport.getSport()+"')";
        DBConnector.execute(tryquery);
    }
}
