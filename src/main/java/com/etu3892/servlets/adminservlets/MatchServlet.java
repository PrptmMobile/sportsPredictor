package com.etu3892.servlets.adminservlets;


import com.etu3892.db.mysql.MySQLMatchDAO;
import com.etu3892.db.mysql.MySQLTeamPartDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/matches")
public class MatchServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List matches = new LinkedList();
        List roster = new ArrayList();
        try {
            roster = MySQLTeamPartDAO.getLeagueRoster(id);
            matches = MySQLMatchDAO.findByLeagueIdFuture(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("roster",roster);
        request.setAttribute("matches",matches);
        request.setAttribute("id",request.getParameter("id"));
        getServletContext().getRequestDispatcher("/tables/edit/matches.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
