package com.etu3892.servlets;


import com.etu3892.db.Entities.User;
import com.etu3892.db.UserRepositury;
import com.etu3892.functional.EmailSender;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/sendpassword")
public class SendPasswordServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = null;
        try {
            user = UserRepositury.findUserByEmail(request.getParameter("email"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user==null) request.setAttribute("ErrorPswd","User with same e-mail doesn`t exist!");
        else {
            request.setAttribute("ErrorPswd","Password sent, check your email");
            EmailSender.forgotPassword(user);
        }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
            requestDispatcher.forward(request, response);
    }
}
