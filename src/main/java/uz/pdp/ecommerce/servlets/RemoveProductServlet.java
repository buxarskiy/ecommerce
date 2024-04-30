package uz.pdp.ecommerce.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.ecommerce.entity.BasketProduct;
import uz.pdp.ecommerce.entity.Product;
import uz.pdp.ecommerce.repo.BasketProductRepo;
import uz.pdp.ecommerce.repo.ProductRepo;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "removeProduct", value = "/remove/product")
public class RemoveProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID basketProductId = UUID.fromString(req.getParameter("basketProductId"));
        Product product = ProductRepo.findById(basketProductId);
        if (product.getId().equals(basketProductId)) {
            BasketProductRepo.removeById(product.getId());
        }
        resp.sendRedirect("/home/basket.jsp");
    }
}
