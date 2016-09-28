package com.etu3892.servlets.adminservlets;

import com.etu3892.db.CountriesRepository;
import com.etu3892.db.LeaguesRepository;
import com.etu3892.db.SportsRepository;
import com.etu3892.db.TeamsRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/showadmin")
public class AdminPanelWorker extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int table = Integer.parseInt(request.getParameter("table"));
        String page = "";
            try {
            switch (table)  {
                case 0:List countries = CountriesRepository.getStCountries();
                    request.setAttribute("countries",countries);
                    page = "/tables/countries.jsp";
                    break;
                case 1:List sports = SportsRepository.getStSports();
                    request.setAttribute("sports",sports);
                    page = "/tables/sports.jsp";
                    break;
                case 2:List leagues = LeaguesRepository.getLeagues();
                    request.setAttribute("leagues",leagues);
                    countries = CountriesRepository.getStCountries();
                    request.setAttribute("countries",countries);
                    sports = SportsRepository.getStSports();
                    request.setAttribute("sports",sports);
                    page = "/tables/leagues.jsp";
                    break;
                case 3:List teams = TeamsRepository.getTeams();
                    request.setAttribute("teams",teams);
                    countries = CountriesRepository.getStCountries();
                    request.setAttribute("countries",countries);
                    sports = SportsRepository.getStSports();
                    request.setAttribute("sports",sports);
                    page = "/tables/teams.jsp";
                    break;
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }



        getServletContext().getRequestDispatcher(page).include(request, response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
