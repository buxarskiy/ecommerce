package uz.pdp.ecommerce.services;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.pdp.ecommerce.entity.User;
import uz.pdp.ecommerce.enums.Role;
import uz.pdp.ecommerce.repo.UserRepo;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "auth", value = "/auth/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Optional<User> optionalUser = UserRepo.findByUserName(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getPassword().equals(password)) {
                if (user.getRole().equals(Role.ADMIN)) {
                    HttpSession session = req.getSession();
                    session.setAttribute("currentUser", user);
                    resp.sendRedirect("/admin/admin.jsp");
                    return;
                } else {
                    req.getSession().setAttribute("currentUser", user);
                    resp.sendRedirect("/index.jsp");
                }
                return;
            }
        }
        resp.sendRedirect("/login.jsp");
    }
}
