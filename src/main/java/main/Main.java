package main;

import java.sql.SQLException;

import dao.CategoryDAO;
import dao.ProductDAO;
import model.Category;
import model.Product;

public class Main {
    public static void main(String[] args) {
        try {
            for (Category category : new CategoryDAO().findAll()) {
                System.out.println(category.getId() + ":" + category.getName());
            }
        } catch (SQLException e) {
            System.err.println("Failed to get the category list.");
            e.printStackTrace();
        }

        try {
            Product product = new Product(0, "Desk Lamp", 30000, 4, 1);
            int result = new ProductDAO().insert(product);
            System.out.println("result:" + result);
        } catch (SQLException e) {
            System.err.println("Failed to add the product.");
            e.printStackTrace();
        }
    }
}
