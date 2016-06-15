package com.epam;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("link.html").include(request, response);

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        if (!name.isEmpty() && !surname.isEmpty()) {
            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            session.setAttribute("surname", surname);
            response.sendRedirect("ProfileServlet");
        } else {
            out.print("Sorry, field of name or surname didn't fill!");
            request.getRequestDispatcher("login.html").include(request, response);
        }
        out.close();
    }
}
