package uz.pdp.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.ecommerce.repo.CategoryRepo;
import uz.pdp.ecommerce.repo.ProductRepo;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private UUID id;
    private String name;
    private int price;
    private UUID categoryId;
    private byte[] photoPath;

    public static Product findProduct(UUID productId) {
        List<Product> products = ProductRepo.findAll();
        for (Product product : products) {
            if (product.getId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public String getCategoryName() {
        Category category = CategoryRepo.findById(categoryId);
        return category.getName();
    }

}
