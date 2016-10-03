package com.etu3892.servlets;

import com.etu3892.db.entities.*;
import com.etu3892.db.entities.League;
import com.etu3892.db.mysql.MySQLCompetDAO;
import com.etu3892.db.mysql.MySQLLeagueDAO;
import com.etu3892.db.mysql.MySQLPredictDAO;
import com.etu3892.db.mysql.MySQLUserDAO;

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

@WebServlet("/ratings")
public class Ratings extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = "None";
        List ratings = new ArrayList(), predicts = new LinkedList();
        League league = null;
        try {
            name = MySQLLeagueDAO.getById(id).getLeague();
            league = MySQLLeagueDAO.getById(id);
            ratings = MySQLCompetDAO.getRating(id);
            predicts = MySQLPredictDAO.findComputedPredicts(MySQLUserDAO.findUserByUserName((String)req.getSession().getAttribute("username")).getUserId(),league.getLeagueId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("id",id);
        req.setAttribute("name",name);
        req.setAttribute("ratings",ratings);
        req.setAttribute("predicts",predicts);
        getServletContext().getRequestDispatcher("/ratings.jsp").include(req,resp);
    }
}
