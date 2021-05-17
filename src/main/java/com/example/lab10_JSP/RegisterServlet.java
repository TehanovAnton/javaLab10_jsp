package com.example.lab10_JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        String username = request.getParameter("username");

        if (DB.SignInUser(username, password)){
            HttpSession session = ((HttpServletRequest)request).getSession();
            String error = (String) session.getAttribute("error");

            error = "user already exists";

            session.setAttribute("error", error);

            RequestDispatcher dispatcher = request.getRequestDispatcher("error");
            dispatcher.forward(request, response);
        }

        if(DB.CheckUser(username, password))
            response.sendRedirect("login");
    }
}
