package com.etu3892.servlets;


import com.etu3892.db.entities.User;
import com.etu3892.db.mysql.MySQLUserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/updateprofile")
public class UpdateProfile extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = null;
        String var = "/cabinet";
        User user = null;
        String username = (String) request.getSession().getAttribute("username");
        String newname =  request.getParameter("username");
        String newpswd =  request.getParameter("newpswd");
        String newmail =  request.getParameter("email");
        String pswd = request.getParameter("pswd");
        try {
            user= MySQLUserDAO.findUserByUserName(username);
            if (pswd.equals(user.getPassword())){
                user.setUsername(newname);
                user.setEmail(newmail);
                if(newpswd!="")user.setPassword(newpswd);
                MySQLUserDAO.updateUser(user);
                message = "Profile updated!";
            } else {
                message = "Incorrect password!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("message",message);
        getServletContext().getRequestDispatcher(var).forward(request, response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
