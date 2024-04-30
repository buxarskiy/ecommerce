package uz.pdp.ecommerce.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.ecommerce.entity.*;
import uz.pdp.ecommerce.repo.BasketProductRepo;
import uz.pdp.ecommerce.repo.BasketRepo;
import uz.pdp.ecommerce.repo.ProductRepo;
import uz.pdp.ecommerce.services.AuthService;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "addBasket", value = "/add/basket")
public class AddToBasket extends HttpServlet {
   /* @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID product = UUID.fromString(req.getParameter("productId"));
        UUID categoryId = UUID.fromString(req.getParameter("categoryId"));
        Basket basket = BasketRepo.findBasket();
        if (basket == null) {
            basket = new Basket();
            BasketRepo.create();
        }
        BasketProductRepo.create(product, basket);
        resp.sendRedirect("../home/productByCategory.jsp?categoryId=" + categoryId);

    }*/

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID productId = UUID.fromString(req.getParameter("productId"));
        Product product = ProductRepo.findById(productId);
        Basket basket = BasketRepo.findBasket(AuthService.currentUser.getId());
        if (basket == null) {
            basket = new Basket();
            BasketRepo.create();
        }
        BasketProductRepo.create(product.getId(), basket);
        resp.sendRedirect("/?categoryId=" + product.getCategoryId());
    }
}
