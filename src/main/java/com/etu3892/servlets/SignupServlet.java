package com.etu3892.servlets;

import com.etu3892.db.entities.User;
import com.etu3892.db.mysql.MySQLUserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.SQLException;

@WebServlet("/endreg")
public class SignupServlet extends HttpServlet{


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = null;
        String username = request.getParameter("username");
        int teamId = Integer.parseInt(request.getParameter("team"));
        try {
            user = MySQLUserDAO.findUserByUserName(username);
            user.setTeamId(teamId);
            MySQLUserDAO.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index");
        requestDispatcher.forward(request, response);
    }




}
