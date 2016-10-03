package com.etu3892.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/locale")
public class Locale extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String lang = req.getParameter("lang");
        if (lang != null) session.setAttribute("language", lang);
        else session.setAttribute("language", "default");
        req.getRequestDispatcher("/index").forward(req,resp);
    }
}
