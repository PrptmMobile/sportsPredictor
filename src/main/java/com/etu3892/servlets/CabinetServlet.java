package com.etu3892.servlets;

import com.etu3892.db.Entities.User;
import com.etu3892.db.TeamsRepository;
import com.etu3892.db.UserRepositury;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cabinet")
public class CabinetServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        String message = request.getParameter("message");
        User user = null;
        try {
            user = UserRepositury.findUserByUserName(username);
            request.setAttribute("username",user.getUsername());
            request.setAttribute("email",user.getEmail());
            request.setAttribute("teamname", TeamsRepository.getTeamById(user.getTeamId()).getTeam());

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
