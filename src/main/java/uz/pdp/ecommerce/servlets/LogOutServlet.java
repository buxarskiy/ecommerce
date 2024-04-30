package uz.pdp.ecommerce.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.pdp.ecommerce.entity.BasketProduct;
import uz.pdp.ecommerce.entity.User;
import uz.pdp.ecommerce.repo.BasketProductRepo;
import uz.pdp.ecommerce.repo.BasketRepo;
import uz.pdp.ecommerce.repo.UserRepo;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "logout", value = "/login/logout")
public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("currentUser", null);
        resp.sendRedirect("/index.jsp");
    }
}
