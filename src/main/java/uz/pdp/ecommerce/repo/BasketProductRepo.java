package uz.pdp.ecommerce.repo;

import uz.pdp.ecommerce.config.ConnectionPoolManager;
import uz.pdp.ecommerce.entity.Basket;
import uz.pdp.ecommerce.entity.BasketProduct;
import uz.pdp.ecommerce.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BasketProductRepo {

    public static void save(UUID basketId, UUID productId) {
        String query = "insert into basket_product(basket_id,product_id,amount) values (?,?,?)";
        try (
                Connection connection = ConnectionPoolManager.getDataSource().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.executeUpdate();
            preparedStatement.setObject(1, basketId);
            preparedStatement.setObject(2, productId);
            preparedStatement.setInt(3, 1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void create(UUID id, Basket basket) {
        String query = "insert into basket_product(product_id,basket_id,amount) values (?,?,?)";
        try (
                Connection connection = ConnectionPoolManager.getDataSource().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setObject(1, id);
            preparedStatement.setObject(2, basket.getId());
            preparedStatement.setInt(3, 1);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<BasketProduct> findAll() {
        String query = "select * from basket_product order by timer";
        try (
                Connection connection = ConnectionPoolManager.getDataSource().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<BasketProduct> basketProducts = new ArrayList<>();
            while (resultSet.next()) {
                basketProducts.add(new BasketProduct(
                        UUID.fromString(resultSet.getString("id")),
                        UUID.fromString(resultSet.getString("product_id")),
                        UUID.fromString(resultSet.getString("basket_id")),
                        resultSet.getInt("amount"),
                        resultSet.getTimestamp("timer")
                ));
            }
            return basketProducts;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void changePlus(UUID id) {
        String query = "update basket_product set amount = amount + 1 where id = ?";
        try (
                Connection connection = ConnectionPoolManager.getDataSource().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setObject(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void changeMinus(UUID id) {
        String query = "update basket_product set amount = amount - 1 where id = ?";
        try (
                Connection connection = ConnectionPoolManager.getDataSource().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setObject(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static BasketProduct findById(UUID basketProductId) {
        String query = "select * from basket_product where id = ?";
        try (Connection connection = ConnectionPoolManager.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setObject(1, basketProductId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new BasketProduct(
                    UUID.fromString(resultSet.getString("id")),
                    UUID.fromString(resultSet.getString("product_id")),
                    UUID.fromString(resultSet.getString("basket_id")),
                    resultSet.getInt("amount"),
                    resultSet.getTimestamp("timer")
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void removeById(UUID productId) {
        String query = "delete from basket_product where product_id = ?";
        try (Connection connection = ConnectionPoolManager.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setObject(1, productId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<BasketProduct> findByBasket(UUID id) {
        String query = "select * from basket_product where basket_id = ?";
        try (
                Connection connection = ConnectionPoolManager.getDataSource().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<BasketProduct> basketProducts = new ArrayList<>();
            while (resultSet.next()) {
                basketProducts.add(new BasketProduct(
                        UUID.fromString(resultSet.getString("id")),
                        UUID.fromString(resultSet.getString("product_id")),
                        UUID.fromString(resultSet.getString("basket_id")),
                        resultSet.getInt("amount"),
                        resultSet.getTimestamp("timer")
                ));
            }
            return basketProducts;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void deleteAll(UUID basketId) {
        String query = "delete from basket_product where basket_id = ?";
        try (
                Connection connection = ConnectionPoolManager.getDataSource().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setObject(1, basketId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Optional<BasketProduct> findByProductId(UUID id) {
        String query = "select * from basket_product where product_id = ?";
        try (
                Connection connection = ConnectionPoolManager.getDataSource().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<BasketProduct> basketProducts = new ArrayList<>();
            while (resultSet.next()) {
                basketProducts.add(new BasketProduct(
                        UUID.fromString(resultSet.getString("id")),
                        UUID.fromString(resultSet.getString("product_id")),
                        UUID.fromString(resultSet.getString("basket_id")),
                        resultSet.getInt("amount"),
                        resultSet.getTimestamp("timer")
                ));
            }
            if (!basketProducts.isEmpty()) {
                return Optional.of(basketProducts.get(0));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
