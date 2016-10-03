package com.etu3892.servlets.adminservlets;

import com.etu3892.db.mysql.MySQLMatchDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/results")
public class ResultServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List matches = new LinkedList();
        try {
            matches = MySQLMatchDAO.findByLeagueIdNoResult(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("matches",matches);
        request.setAttribute("name",request.getParameter("name"));
        request.setAttribute("id",request.getParameter("id"));
        getServletContext().getRequestDispatcher("/tables/edit/results.jsp").forward(request, response);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
