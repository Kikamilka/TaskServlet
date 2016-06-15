package com.epam;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class MyFilter implements Filter {

    public MyFilter() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        if (!name.isEmpty() && !surname.isEmpty()) {
            chain.doFilter(request, response);
        } else {
            HttpServletResponse resp = (HttpServletResponse) response;
            resp.sendError(403, "Name or surname should be fill!");
        }
    }

    @Override
    public void init(FilterConfig fc) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}
