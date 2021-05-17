package com.example.lab10_JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "newchanelServlet", value = "/newchanelServlet")
public class newchanelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String channel = request.getParameter("channel");
        String owner = request.getParameter("owner");

        DB.AddNewChannel(channel, owner);

        Cookie cookie = new Cookie("logged", "true");
        cookie.setMaxAge(60 * 10);
        response.addCookie(cookie);
        response.sendRedirect("welcome");
    }
}
