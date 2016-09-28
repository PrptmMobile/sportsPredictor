package com.etu3892.servlets;


import com.etu3892.db.Entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.etu3892.db.UserRepositury;
import com.etu3892.functional.EmailChecker;

@WebServlet("/sportncountry")
public class SelectServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pswd = request.getParameter("password");
        String pswdagn = request.getParameter("passwordagain");
        Boolean inuse = false, pswdch = false, emailch = false, emailused = false;
        try {

            pswdch = !pswd.equals(pswdagn);
            inuse = UserRepositury.findUserByUserName(request.getParameter("name")) != null;
            emailch = !EmailChecker.validate(request.getParameter("email"));
            emailused = UserRepositury.findUserByEmail(request.getParameter("email")) != null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int countryId = Integer.parseInt(request.getParameter("country"));
        User user = new User(0, request.getParameter("name"), request.getParameter("password"), countryId, 3, request.getParameter("email"));
        if (pswdch || inuse || emailch || emailused) {
            request.setAttribute("name", request.getParameter("name"));
            request.setAttribute("email",request.getParameter("email"));
            if(inuse) request.setAttribute("Error1", " Name already in use! ");
            if(pswdch) request.setAttribute("Error2", " Passwords doesn`t match! ");
            if(emailch) request.setAttribute("Error3", " Your e-mail is invalid!");
            if(emailused) request.setAttribute("Error3", " E-mail already in use!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/signUp.jsp");
            requestDispatcher.forward(request, response);

        } else {

           try {
               UserRepositury.createUser(user);
           } catch (SQLException e) {
           }
           request.setAttribute("username", user.getUsername());
           RequestDispatcher requestDispatcher = request.getRequestDispatcher("/sportncountry.jsp");
           requestDispatcher.forward(request, response);
        }
    }
}
