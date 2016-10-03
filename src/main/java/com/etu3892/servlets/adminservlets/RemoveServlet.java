package com.etu3892.servlets.adminservlets;


import com.etu3892.db.entities.*;
import com.etu3892.db.mysql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/remove")
public class RemoveServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int type = Integer.parseInt(request.getParameter("type"));
        String var = "/administrator";
        try {
        switch (type){
            case 0:
                Country country = new Country(Integer.parseInt(request.getParameter("id")), request.getParameter("country"));
                MySQLCountriesDAO.removeCountry(country);
                break;
            case 1:
                Sport sport = new Sport(Integer.parseInt(request.getParameter("id")), request.getParameter("sport"));
                MySQLSportsDAO.removeSport(sport);
                break;
            case 2:
                League league = new League(Integer.parseInt(request.getParameter("id")));
                MySQLLeagueDAO.removeLeague(league);
                break;
            case 3:
                Team team = new Team(Integer.parseInt(request.getParameter("id")));
                MySQLTeamsDAO.removeTeam(team);
                break;
            case 4:
                TeamPart teampart = new TeamPart(Integer.parseInt(request.getParameter("id")));
                MySQLTeamPartDAO.removeFromRoster(teampart);
                break;
            case 5:
                Match match = new Match(Integer.parseInt(request.getParameter("id")));
                MySQLMatchDAO.removeMatch(match);
                var = "/matches?id="+match.getMatchId();
                break;
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }



        getServletContext().getRequestDispatcher(var).forward(request, response);
    }
}
