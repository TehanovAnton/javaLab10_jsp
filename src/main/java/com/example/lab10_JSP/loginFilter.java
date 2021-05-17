package com.example.lab10_JSP;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebFilter(urlPatterns = { "/welcome" }, initParams = { @WebInitParam(name = "encoding", value = "UTF-8", description = "Encoding Param") })
public class loginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String password = request.getParameter("password") == null ? "" : request.getParameter("password");
        String username = request.getParameter("username") == null ? "" : request.getParameter("username");

        Boolean logged = false;
        Cookie[] cookies = ((HttpServletRequest)request).getCookies();
        for(int e = 0; e < cookies.length; e++) {
            if (cookies[e].getValue().equals("true") && cookies[e].getName().equals("logged")) {
                logged = true;

                Cookie cookie = new Cookie("logged", "false");
                cookie.setMaxAge(0);
                ((HttpServletResponse)response).addCookie(cookie);
            }
        }

        if (!logged)
            if (password.equals("") || username.equals("") || !DB.CheckUser(username, password)){

                HttpSession session = ((HttpServletRequest)request).getSession();
                String error = (String) session.getAttribute("error");

                if(error == null) {
                    error = "no user or empty fields";
                }

                session.setAttribute("error", error);
                ((HttpServletResponse)response).sendRedirect("error");
            }

        chain.doFilter(request, response);
    }
}
