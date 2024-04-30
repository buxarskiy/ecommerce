package uz.pdp.ecommerce.entity;

import lombok.*;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Category {
    private UUID id;
    private String name;
}
