package com.etu3892.servlets.adminservlets;


import com.etu3892.db.TeamPartRepository;
import com.etu3892.db.UserRepositury;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/participants")
public class PartServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List roster = new ArrayList();
        try {
            roster = TeamPartRepository.getLeagueRoster(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("roster",roster);
        request.setAttribute("name",request.getParameter("name"));
        getServletContext().getRequestDispatcher("/tables/edit/participants.jsp").forward(request, response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
