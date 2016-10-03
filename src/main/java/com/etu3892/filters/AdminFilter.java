package com.etu3892.filters;

import com.etu3892.db.entities.User;
import com.etu3892.db.mysql.MySQLUserDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"/tables/*","/administrator"})
public class AdminFilter implements Filter{
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        boolean isadmin = false;
        try {
            isadmin = MySQLUserDAO.isAdmin(MySQLUserDAO.findUserByUserName((String)request.getSession().getAttribute("username")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (isadmin){
            String[] requestedUri = request.getRequestURI().split("/");
            request.getRequestDispatcher("/" + requestedUri[requestedUri.length - 1]).forward(servletRequest, servletResponse);
        } else request.getRequestDispatcher("/denied.jsp").forward(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
