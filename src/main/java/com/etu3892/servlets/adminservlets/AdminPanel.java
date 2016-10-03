package com.etu3892.servlets.adminservlets;

import com.etu3892.db.mysql.MySQLUserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/administrator")
public class AdminPanel extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String)request.getSession().getAttribute("username");
        Boolean isadmin = false;

        try {
            isadmin = MySQLUserDAO.isAdmin(MySQLUserDAO.findUserByUserName(username));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (isadmin) getServletContext().getRequestDispatcher("/adminpanel.jsp").forward(request, response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
