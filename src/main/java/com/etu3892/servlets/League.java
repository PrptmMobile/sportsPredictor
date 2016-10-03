package com.etu3892.servlets;

import com.etu3892.db.mysql.MySQLLeagueDAO;
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

@WebServlet("/leaguetable")
public class League extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = "None";
        List table = new ArrayList();
        List matches = new LinkedList();
        try {
            name = MySQLLeagueDAO.getById(id).getLeague();
            table = MySQLTeamPartDAO.getLeagueRoster(id);
            matches = MySQLMatchDAO.getResultsOfLeague(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("id",id);
        req.setAttribute("table",table);
        req.setAttribute("name",name);
        req.setAttribute("matches",matches);
        getServletContext().getRequestDispatcher("/leaguetable.jsp").forward(req,resp);
    }
}
