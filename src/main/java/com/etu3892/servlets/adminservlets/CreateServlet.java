package com.etu3892.servlets.adminservlets;


import com.etu3892.db.entities.*;
import com.etu3892.db.mysql.*;
import com.etu3892.functional.SportsDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

@WebServlet("/create")
public class CreateServlet extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int type = Integer.parseInt(request.getParameter("type"));
        String link = "/administrator";
                try {
                    switch (type){
                        case 0:Country country = new Country(0, request.getParameter("country"));
                            MySQLCountriesDAO.addCountry(country);
                            break;
                        case 1:Sport sport = new Sport(0,request.getParameter("sport"));
                            MySQLSportsDAO.addSport(sport);
                            break;
                        case 2:
                            League league = new League(0,request.getParameter("league"), MySQLCountriesDAO.getCountryById(Integer.parseInt(request.getParameter("country"))), MySQLSportsDAO.getById(Integer.parseInt(request.getParameter("sport"))));
                            MySQLLeagueDAO.addLeague(league);
                            break;
                        case 3:
                            Team team = new Team(0,request.getParameter("team"),  MySQLSportsDAO.getById(Integer.parseInt(request.getParameter("sport"))), MySQLCountriesDAO.getCountryById(Integer.parseInt(request.getParameter("country"))));
                            MySQLTeamsDAO.addTeam(team);
                            break;
                        case 4:
                            League lg = MySQLLeagueDAO.getById(Integer.parseInt(request.getParameter("lid")));
                            TeamPart teampart = new TeamPart(0,lg, MySQLTeamsDAO.getTeamById(Integer.parseInt(request.getParameter("team"))),0,0,0,0);
                            link = "/participants?id="+lg.getLeagueId()+"&name="+lg.getLeague();
                            MySQLTeamPartDAO.addToRoster(teampart);
                            break;
                        case 5:
                            League lg1 = MySQLLeagueDAO.getById(Integer.parseInt(request.getParameter("lid")));
                            String dt = request.getParameter("dt")+":00";
                            dt = dt.replace('T',' ');
                            Match match = new Match(0, MySQLTeamsDAO.getTeamById(Integer.parseInt(request.getParameter("home"))), MySQLTeamsDAO.getTeamById(Integer.parseInt(request.getParameter("away"))),lg1, new SportsDateTime(Timestamp.valueOf(dt)));
                            MySQLMatchDAO.addMatch(match);
                            link = "/matches?id="+lg1.getLeagueId();
                            break;
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }




        getServletContext().getRequestDispatcher(link).include(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
