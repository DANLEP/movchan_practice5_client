package ua.nure.location.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter({"/add", "/delete/*", "/edit/*"})
public class ModifyingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var request = ((HttpServletRequest) servletRequest);
        var response = ((HttpServletResponse) servletResponse);
        var user = request.getSession().getAttribute("user");

        if (user == null) {
            request.getSession().setAttribute("errorMessage", "Access for modifying content is denied.");
            response.sendRedirect(request.getContextPath() + "/places");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
