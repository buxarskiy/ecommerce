package uz.pdp.ecommerce.config;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.pdp.ecommerce.entity.User;
import uz.pdp.ecommerce.enums.Role;

import java.io.IOException;

@WebFilter(urlPatterns = {"/admin/*"})
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        Object currentUSerObj = session.getAttribute("currentUser");
        if (currentUSerObj != null) {
            User user = (User) currentUSerObj;
            if (user.getRole().equals(Role.ADMIN)) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
            res.sendRedirect("/404");
        }
    }
}

