package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static final String URL = System.getenv().getOrDefault(
            "SHOPAPP_DB_URL", "jdbc:mysql://localhost:3306/shopdb");
    private static final String USER = System.getenv().getOrDefault("SHOPAPP_DB_USER", "root");
    private static final String PASSWORD = System.getenv().getOrDefault("SHOPAPP_DB_PASSWORD", "root");

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("JDBC driver not found.", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
