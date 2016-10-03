package com.etu3892.servlets;


import com.etu3892.db.mysql.MySQLUserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        String access = "Unknown username";
        try {
            access = MySQLUserDAO.checkUser(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (access.equals("granted")){
            response.setContentType("text/html; charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            request.getSession().setAttribute("username",username);
            request.setAttribute("username", username);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index");
            requestDispatcher.forward(request, response);
        }
        else {
            response.setContentType("text/html; charset=windows-1251");
            request.setCharacterEncoding("cp1251");
            request.setAttribute("Error", access);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
