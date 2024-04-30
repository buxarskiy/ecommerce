package uz.pdp.ecommerce.repo;

import uz.pdp.ecommerce.config.ConnectionPoolManager;
import uz.pdp.ecommerce.entity.Basket;
import uz.pdp.ecommerce.entity.BasketProduct;
import uz.pdp.ecommerce.entity.User;
import uz.pdp.ecommerce.services.AuthService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BasketRepo {
    /*public static void save(UUID productId){
        String query = "insert into basket_product(product_id, amount) values (?,?)";
        try (Connection connection = ConnectionPoolManager.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setObject(1, productId);
            preparedStatement.setInt(2, 1);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/


   /* public static Basket findByUser(int userId) {
        String query = " select * from basket where user_id =?";
        try (
                Connection connection = ConnectionPoolManager.getDataSource().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new Basket(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getInt("user_id")
            );
        } catch (Exception e) {
            return null;
        }
    }*/

    public static Basket findBasket(int id) {
        String query = "select * from basket where user_id = ?";
        try (
                Connection connection = ConnectionPoolManager.getDataSource().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Basket(
                        UUID.fromString(resultSet.getString("id")),
                        resultSet.getInt("user_id")
                );
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void create() {
        String query = "insert into basket(user_id) values (?)";
        try (
                Connection connection = ConnectionPoolManager.getDataSource().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, AuthService.currentUser.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
