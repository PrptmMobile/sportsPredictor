package com.etu3892.filters;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"/*"})
public class LoginFilter implements Filter{
    public void init(FilterConfig filterConfig) throws ServletException {

    }



    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        for(String ignoreUri : ignore){
            if(request.getRequestURI().equals("/sportsPredictor/" + ignoreUri)){
                request.getRequestDispatcher("/" + ignoreUri).forward(servletRequest, servletResponse);
                return;
            }
        }
        if(request.getRequestURI().equals("/sportsPredictor/login.jsp")){
            if(request.getSession().getAttribute("username")==null)
                request.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
            else{
                String[] requestedUri = request.getRequestURI().split("/");
                request.getRequestDispatcher("/" + requestedUri[requestedUri.length - 1]).forward(servletRequest, servletResponse);
            }
        }
        else{
            if(request.getSession().getAttribute("username")!=null) request.getRequestDispatcher("/403.jsp").forward(servletRequest, servletResponse);
        }
    }

    public void destroy() {

    }
    public static final LinkedList<String> ignore = new LinkedList<String>(Arrays.asList( "index.jsp",
            "login.jsp",
            "signUp.jsp",
            "sportncountry.jsp",
            "chooseteam.jsp",
            "notLogged.jsp",
            "index",
            ""));

}
