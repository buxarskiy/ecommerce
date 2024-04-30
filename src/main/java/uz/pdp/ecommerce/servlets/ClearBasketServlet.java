package uz.pdp.ecommerce.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.ecommerce.entity.BasketProduct;
import uz.pdp.ecommerce.repo.BasketProductRepo;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "clearBasket", value = "/basket/clear")
public class ClearBasketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID basketId = UUID.fromString(req.getParameter("basketId"));
        List<BasketProduct> basketProducts = BasketProductRepo.findByBasket(basketId);
        basketProducts.clear();
        BasketProductRepo.deleteAll(basketId);
        resp.sendRedirect("/index.jsp");
    }
}
