package uz.pdp.ecommerce.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import uz.pdp.ecommerce.entity.Product;
import uz.pdp.ecommerce.repo.ProductRepo;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@WebServlet(name = "addProduct", value = "/product/add")
@MultipartConfig
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        UUID categoryId = UUID.fromString(req.getParameter("categoryId"));
        Part part = req.getPart("photo");
        InputStream inputStream = part.getInputStream();
        byte[] photo = inputStream.readAllBytes();
        Product product = Product.builder().name(name).price(price).categoryId(categoryId).photoPath(photo).build();
        ProductRepo.save(product);
        resp.sendRedirect("/admin/product.jsp");
    }
}

