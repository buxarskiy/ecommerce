package uz.pdp.ecommerce.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.ecommerce.repo.BasketProductRepo;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "deleteBasketProduct", value = "/delete/basketProduct")
public class DeleteBasketProduct extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID productId = UUID.fromString(req.getParameter("productId"));
        BasketProductRepo.removeById(productId);
        resp.sendRedirect("/index.jsp");
    }
}
