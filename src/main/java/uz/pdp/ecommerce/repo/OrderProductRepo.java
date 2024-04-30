package uz.pdp.ecommerce.repo;

import uz.pdp.ecommerce.config.ConnectionPoolManager;
import uz.pdp.ecommerce.entity.BasketProduct;
import uz.pdp.ecommerce.entity.OrderProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderProductRepo {

    public static void create(List<BasketProduct> basketProducts, Integer orderId) {
        for (BasketProduct basketProduct : basketProducts) {
            String query = "insert into order_product(order_id,product_id, amount) values(?,?,?)";
            try (
                    Connection connection = ConnectionPoolManager.getDataSource().getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(query)
            ) {

                preparedStatement.setObject(1, orderId);
                preparedStatement.setObject(2, basketProduct.getProductId());
                preparedStatement.setInt(3, basketProduct.getAmount());
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static List<OrderProduct> findByOrder(int orderId) {
        String query = "select * from order_product where order_id = ?";
        try (
                Connection connection = ConnectionPoolManager.getDataSource().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setInt(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<OrderProduct> orderProducts = new ArrayList<>();
            while (resultSet.next()) {
                orderProducts.add(new OrderProduct(
                        resultSet.getInt("order_id"),
                        UUID.fromString(resultSet.getString("product_id")),
                        resultSet.getInt("amount")
                ));
            }
            System.out.println(orderProducts);
            return orderProducts;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
