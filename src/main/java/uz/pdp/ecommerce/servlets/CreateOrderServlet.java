package uz.pdp.ecommerce.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.ecommerce.entity.BasketProduct;
import uz.pdp.ecommerce.entity.Order;
import uz.pdp.ecommerce.enums.Status;
import uz.pdp.ecommerce.repo.BasketProductRepo;
import uz.pdp.ecommerce.repo.OrderProductRepo;
import uz.pdp.ecommerce.repo.OrderRepo;
import uz.pdp.ecommerce.services.AuthService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "createOrder", value = "/order/create")
public class CreateOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID basketId = UUID.fromString(req.getParameter("basketId"));

        Order order = Order.builder().userId(AuthService.currentUser.getId()).status(Status.OPEN).build();
        Integer orderId = OrderRepo.save(order);

        List<BasketProduct> basketProducts = BasketProductRepo.findByBasket(basketId);
        OrderProductRepo.create(basketProducts, orderId);
        BasketProductRepo.deleteAll(basketId);
        resp.sendRedirect("/index.jsp");
    }
}
