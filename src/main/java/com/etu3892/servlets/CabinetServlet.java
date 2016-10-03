package com.etu3892.servlets;

import com.etu3892.db.entities.User;
import com.etu3892.db.mysql.MySQLTeamsDAO;
import com.etu3892.db.mysql.MySQLUserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/cabinet")
public class CabinetServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        String message = request.getParameter("message");
        User user = null;
        try {
            user = MySQLUserDAO.findUserByUserName(username);
            request.setAttribute("username",user.getUsername());
            request.setAttribute("email",user.getEmail());
            request.setAttribute("teamname", MySQLTeamsDAO.getTeamById(user.getTeamId()).getTeam());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("message",message);
        getServletContext().getRequestDispatcher("/cabinet.jsp").forward(request, response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
