package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Category;
import util.DBManager;

public class CategoryDAO {
    public List<Category> findAll() throws SQLException {
        String sql = "SELECT id, name FROM category ORDER BY id";
        List<Category> categories = new ArrayList<>();

        try (Connection connection = DBManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                categories.add(new Category(results.getInt("id"), results.getString("name")));
            }
        }

        return categories;
    }
}
