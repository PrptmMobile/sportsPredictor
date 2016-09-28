package com.etu3892.servlets.adminservlets;


import com.etu3892.db.CountriesRepository;
import com.etu3892.db.Entities.Country;
import com.etu3892.db.Entities.League;
import com.etu3892.db.Entities.Sport;
import com.etu3892.db.Entities.Team;
import com.etu3892.db.LeaguesRepository;
import com.etu3892.db.SportsRepository;
import com.etu3892.db.TeamsRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int type = Integer.parseInt(request.getParameter("type"));
        try {
        switch (type) {
            case 0:
                Country country = new Country(Integer.parseInt(request.getParameter("id")), request.getParameter("country"));
                CountriesRepository.updateCountry(country);
                break;
            case 1:
                Sport sport = new Sport(Integer.parseInt(request.getParameter("id")), request.getParameter("sport"));
                SportsRepository.updateSport(sport);
                break;
            case 2:
                League league = new League(Integer.parseInt(request.getParameter("id")),request.getParameter("league"),Integer.parseInt(request.getParameter("country")),Integer.parseInt(request.getParameter("sport")));
                LeaguesRepository.updateLeague(league);
                break;
            case 3:
                Team team = new Team(Integer.parseInt(request.getParameter("id")),request.getParameter("team"), SportsRepository.getById(Integer.parseInt(request.getParameter("sport"))), CountriesRepository.getCountryById(Integer.parseInt(request.getParameter("country"))));
                TeamsRepository.updateTeam(team);
                break;
        }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        HttpSession session = request.getSession(false);
        if (null == request.getRequestedSessionId()){
            session = request.getSession(true);
            String encodedURL = response.encodeURL("/administrator");
            response.sendRedirect(encodedURL);
        }

        getServletContext().getRequestDispatcher("/administrator").forward(request, response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

