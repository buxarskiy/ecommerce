package uz.pdp.ecommerce.photo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static uz.pdp.ecommerce.photo.PathUtils.rootDirectory;


@WebServlet(name = "fileUpload", value = "/file/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("photo");
        InputStream inputStream = part.getInputStream();

        String photoPath = rootDirectory + "/Desktop/file/profile.png";
        PathUtils.filePath = photoPath;

        OutputStream outputStream = new FileOutputStream(photoPath);
        outputStream.write(inputStream.readAllBytes());
        resp.sendRedirect("/admin/product.jsp");
    }

}
