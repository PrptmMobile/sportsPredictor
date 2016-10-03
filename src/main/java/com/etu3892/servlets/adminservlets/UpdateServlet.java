package com.etu3892.servlets.adminservlets;


import com.etu3892.db.entities.*;
import com.etu3892.db.mysql.*;
import com.etu3892.functional.Resulter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int type = Integer.parseInt(request.getParameter("type"));
        String var = "/administrator";
        try {
        switch (type) {
            case 0:
                Country country = new Country(Integer.parseInt(request.getParameter("id")), request.getParameter("country"));
                MySQLCountriesDAO.updateCountry(country);
                break;
            case 1:
                Sport sport = new Sport(Integer.parseInt(request.getParameter("id")), request.getParameter("sport"));
                MySQLSportsDAO.updateSport(sport);
                break;
            case 2:
                League league = new League(Integer.parseInt(request.getParameter("id")),request.getParameter("league"), MySQLCountriesDAO.getCountryById(Integer.parseInt(request.getParameter("country"))), MySQLSportsDAO.getById(Integer.parseInt(request.getParameter("sport"))));
                MySQLLeagueDAO.updateLeague(league);
                break;
            case 3:
                Team team = new Team(Integer.parseInt(request.getParameter("id")),request.getParameter("team"), MySQLSportsDAO.getById(Integer.parseInt(request.getParameter("sport"))), MySQLCountriesDAO.getCountryById(Integer.parseInt(request.getParameter("country"))));
                MySQLTeamsDAO.updateTeam(team);
                break;
            case 5:
                Match match= MySQLMatchDAO.findById(Integer.parseInt(request.getParameter("id")));
                match.setHomeGls(Integer.parseInt(request.getParameter("homeGls")));
                match.setAwayGls(Integer.parseInt(request.getParameter("awayGls")));
                MySQLMatchDAO.udpateMatch(match);
                Resulter.ComputeResult(match);
                List<Predict> predicts = MySQLPredictDAO.findByMatch(match);
                for (Predict predict : predicts){
                    Resulter.ComputePredict(predict,match);
                }
                var = "/results?id="+match.getLeague().getLeagueId()+"&name="+match.getLeague().getLeague();
                break;
            case 11:
                Predict predict = new Predict(0, MySQLMatchDAO.findById(Integer.parseInt(request.getParameter("matchId"))), MySQLUserDAO.findUserByUserName((String)request.getSession().getAttribute("username")),Integer.parseInt(request.getParameter("homeGls")),Integer.parseInt(request.getParameter("awayGls")));
                var = "/predict?id="+predict.getMatch().getLeague().getLeagueId();
                Predict test = MySQLPredictDAO.findByUserIdAndMatchId(predict.getUser().getUserId(),predict.getMatch().getMatchId());
                if (null!=test) {
                    predict.setPredictId(test.getPredictId());
                    MySQLPredictDAO.updateOnlyScore(predict);
                } else MySQLPredictDAO.add(predict);
                break;
        }

        } catch (SQLException e) {
            e.printStackTrace();
        }



        getServletContext().getRequestDispatcher(var).forward(request, response);
    }

}

