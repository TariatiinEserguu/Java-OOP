package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import util.DBManager;

public class ProductDAO {
    private static final String SELECT_PRODUCTS =
            "SELECT p.id, p.name, p.price, p.stock, p.category_id, c.name AS category_name "
            + "FROM product p JOIN category c ON p.category_id = c.id";

    public List<Product> findAll() throws SQLException {
        String sql = SELECT_PRODUCTS + " ORDER BY p.id";
        List<Product> products = new ArrayList<>();
        try (Connection connection = DBManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                products.add(readProduct(results));
            }
        }
        return products;
    }

    public Product findById(int id) throws SQLException {
        String sql = SELECT_PRODUCTS + " WHERE p.id = ?";
        try (Connection connection = DBManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet results = statement.executeQuery()) {
                return results.next() ? readProduct(results) : null;
            }
        }
    }

    public int insert(Product product) throws SQLException {
        String sql = "INSERT INTO product (name, price, stock, category_id) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, product.getName());
            statement.setInt(2, product.getPrice());
            statement.setInt(3, product.getStock());
            statement.setInt(4, product.getCategoryId());
            return statement.executeUpdate();
        }
    }

    public int delete(int id) throws SQLException {
        String sql = "DELETE FROM product WHERE id = ?";
        try (Connection connection = DBManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            return statement.executeUpdate();
        }
    }

    private Product readProduct(ResultSet results) throws SQLException {
        return new Product(results.getInt("id"), results.getString("name"),
                results.getInt("price"), results.getInt("stock"),
                results.getInt("category_id"), results.getString("category_name"));
    }
}
