package uz.pdp.ecommerce.repo;

import uz.pdp.ecommerce.config.ConnectionPoolManager;
import uz.pdp.ecommerce.entity.Order;
import uz.pdp.ecommerce.enums.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrderRepo {
    public static Integer save(Order order) {
        String query = "INSERT INTO orders (user_id, status) VALUES (?, ?) RETURNING id";
        try (
                Connection connection = ConnectionPoolManager.getDataSource().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {

            preparedStatement.setInt(1, order.getUserId());
            preparedStatement.setString(2, String.valueOf(order.getStatus()));
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt("id");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Order> findAll(int id) {
        String query = "select * from orders where user_id = ?";
        try (
                Connection connection = ConnectionPoolManager.getDataSource().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Order> orders = new ArrayList<>();
            while (resultSet.next()) {
                orders.add(Order.builder()
                        .id(resultSet.getInt("id"))
                        .userId(resultSet.getInt("user_id"))
                        .dateTime(resultSet.getTimestamp("date_time"))
                        .status(Status.valueOf(resultSet.getString("status")))
                        .build()
                );
            }
            return orders;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Order find(int orderId) {
        String query = "select * from orders where id = ?";
        try (
                Connection connection = ConnectionPoolManager.getDataSource().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Order.builder()
                        .userId(resultSet.getInt("user_id"))
                        .dateTime(resultSet.getTimestamp("date_time"))
                        .status(Status.valueOf(resultSet.getString("status")))
                        .build();
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
