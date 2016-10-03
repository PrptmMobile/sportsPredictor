package com.etu3892.servlets;

import com.etu3892.db.entities.League;
import com.etu3892.db.mysql.MySQLLeagueDAO;
import com.etu3892.db.mysql.MySQLMatchDAO;
import com.etu3892.db.mysql.MySQLPredictDAO;
import com.etu3892.db.mysql.MySQLUserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/predict")
public class Predictor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        League league = null;
        List matches = new LinkedList(), predicts = new LinkedList();
        try {
            league = MySQLLeagueDAO.getById(id);
            matches = MySQLMatchDAO.findByLeagueIdFuture(id);
            predicts = MySQLPredictDAO.findNotComputedPredicts(MySQLUserDAO.findUserByUserName((String)req.getSession().getAttribute("username")).getUserId(),league.getLeagueId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("id",id);
        req.setAttribute("name",league.getLeague());
        req.setAttribute("matches",matches);
        req.setAttribute("predicts",predicts);
        getServletContext().getRequestDispatcher("/predict.jsp").include(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
