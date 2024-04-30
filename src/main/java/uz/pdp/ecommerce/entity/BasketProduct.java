package uz.pdp.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.ecommerce.repo.BasketProductRepo;
import uz.pdp.ecommerce.repo.CategoryRepo;
import uz.pdp.ecommerce.repo.ProductRepo;

import java.sql.Timestamp;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasketProduct {
    private UUID id;
    private UUID productId;
    private UUID basketId;
    private Integer amount;
    private Timestamp timer;

    public String getProductName() {
        Product product = ProductRepo.findById(productId);
        return product.getName();
    }
}
