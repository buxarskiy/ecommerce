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

@WebServlet(name = "productCount", value = "/product/count")
public class CountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        UUID basketProductId = UUID.fromString(req.getParameter("id"));
        BasketProduct basketProduct = BasketProductRepo.findById(basketProductId);
        if (name.equals("plus")) {
            BasketProductRepo.changePlus(basketProductId);
        } else if (name.equals("minus")) {
            if (basketProduct.getAmount() > 1) {
                BasketProductRepo.changeMinus(basketProductId);
            }
        }
        resp.sendRedirect("/home/basket.jsp");
    }
}
