package uz.pdp.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.ecommerce.enums.Status;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private int id;
    private Timestamp dateTime;
    private Integer userId;
    private Status status;
}
