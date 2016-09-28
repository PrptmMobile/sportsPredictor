package com.etu3892.db;


import com.etu3892.db.Entities.Sport;
import com.etu3892.db.Entities.Team;
import com.etu3892.db.Entities.TeamPart;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamPartRepository {

    public static List getLeagueRoster (int id) throws SQLException{
        List partsList = new ArrayList<TeamPart>();
        String tryquery = "select * from teampart where leagueId="+id;
        ResultSet rs1 = DBConnector.getSet(tryquery);
        while (rs1.next()) {
            TeamPart teampart = new TeamPart(rs1.getInt("teampartId"),rs1.getInt("leagueId"),rs1.getInt("teamId"),rs1.getInt("gs"),rs1.getInt("gc"),rs1.getInt("pts"));
            partsList.add(teampart);
        }

        return partsList;
    }

    public class TeamVisual {
        private TeamPart teamPart;
        private Team patricipant;

        public TeamVisual(TeamPart teamPart, Team team) {
            this.teamPart = teamPart;
            this.patricipant = team;
        }

        public TeamPart getTeamPart() {
            return teamPart;
        }

        public Team getPart() {
            return patricipant;
        }
    }
}


