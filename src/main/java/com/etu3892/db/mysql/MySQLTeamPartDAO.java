package com.etu3892.db.mysql;


import com.etu3892.db.entities.TeamPart;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLTeamPartDAO {

    public static List getLeagueRoster (int id) throws SQLException{
        List partsList = new ArrayList<TeamPart>();
        String tryquery = "select *,(gs-gc) from teampart where leagueId="+id+" order by pts desc, 2 desc";
        ResultSet rs1 = DBConnector.getSet(tryquery);
        while (rs1.next()) {
            TeamPart teampart = new TeamPart(rs1.getInt("teampartId"), MySQLLeagueDAO.getById(rs1.getInt("leagueId")), MySQLTeamsDAO.getTeamById(rs1.getInt("teamId")), rs1.getInt("pld"), rs1.getInt("gs"),rs1.getInt("gc"),rs1.getInt("pts"));
            partsList.add(teampart);
        }

        return partsList;
    }

    public static TeamPart getByTeamIdAndLeagueId (int teamId,int leagueId) throws SQLException{
        String tryquery = "select * from teampart where teamId="+teamId+" and leagueId="+leagueId;
        ResultSet rs1 = DBConnector.getSet(tryquery);
        rs1.next();


        return new TeamPart(rs1.getInt("teampartId"), MySQLLeagueDAO.getById(rs1.getInt("leagueId")), MySQLTeamsDAO.getTeamById(rs1.getInt("teamId")), rs1.getInt("pld"), rs1.getInt("gs"),rs1.getInt("gc"),rs1.getInt("pts"));

}
    public static void addToRoster(TeamPart teamPart) throws SQLException{
        String tryquery = "insert into teampart values (0,"+teamPart.getLeague().getLeagueId()+","+teamPart.getTeam().getTeamId()+",0,0,0,0)";
        DBConnector.execute(tryquery);
    }

    public static void updateRoster(TeamPart teamPart) throws SQLException{
        String tryquery = "update teampart set teamId="+teamPart.getTeam().getTeamId()+", gs="+teamPart.getGs()+", gc="+teamPart.getGc()+", pts="+teamPart.getPts()+", pld="+teamPart.getPld()+" where teampartId="+teamPart.getTeampartId();
        DBConnector.execute(tryquery);
    }

    public static void removeFromRoster(TeamPart teamPart) throws SQLException{
        String tryquery = "delete from teampart where teampartId="+teamPart.getTeampartId();
        DBConnector.execute(tryquery);
    }


}


