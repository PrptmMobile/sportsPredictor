package com.etu3892.servlets;


import com.etu3892.db.mysql.MySQLTeamsDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/teamselect")
public class TeamChaser extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        int country = Integer.parseInt(request.getParameter("countries"));
        int sport = Integer.parseInt(request.getParameter("sports"));
        List teamsList = null;
        try {
            teamsList = MySQLTeamsDAO.getTeamsBySportAndCountry(sport,country);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("teamList",teamsList);
        request.setAttribute("username",username);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/chooseteam.jsp");
        requestDispatcher.forward(request, response);
    }
}
