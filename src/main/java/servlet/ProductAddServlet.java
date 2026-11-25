package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.CategoryDAO;
import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;
import model.Product;
import util.Validator;

@WebServlet("/productAdd")
public class ProductAddServlet extends HttpServlet {
    private final CategoryDAO categoryDAO = new CategoryDAO();
    private final ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        showForm(request, response, loadCategories());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = parameter(request, "name");
        String categoryId = parameter(request, "categoryId");
        String price = parameter(request, "price");
        String stock = parameter(request, "stock");

        String productName = name.strip();
        List<String> errors = Validator.validateProduct(productName, price, stock);
        if (productName.codePointCount(0, productName.length()) > 100) {
            errors.add("Name must be 100 characters or fewer.");
        }

        List<Category> categories = loadCategories();
        boolean validCategory = categories.stream()
                .anyMatch(category -> Integer.toString(category.getId()).equals(categoryId));
        if (!validCategory) {
            errors.add("Choose a valid category.");
        }

        if (!errors.isEmpty()) {
            request.setAttribute("errors", errors);
            request.setAttribute("name", name);
            request.setAttribute("categoryId", validCategory ? categoryId : "");
            request.setAttribute("price", price);
            request.setAttribute("stock", stock);
            showForm(request, response, categories);
            return;
        }

        Product product = new Product(0, productName, Integer.parseInt(price),
                Integer.parseInt(stock), Integer.parseInt(categoryId));
        try {
            productDAO.insert(product);
        } catch (SQLException e) {
            throw new ServletException("Failed to add the product.", e);
        }
        response.sendRedirect("products");
    }

    private List<Category> loadCategories() throws ServletException {
        try {
            return categoryDAO.findAll();
        } catch (SQLException e) {
            throw new ServletException("Failed to get the category list.", e);
        }
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response,
            List<Category> categories) throws ServletException, IOException {
        request.setAttribute("categoryList", categories);
        request.getRequestDispatcher("/WEB-INF/productAdd.jsp").forward(request, response);
    }

    private String parameter(HttpServletRequest request, String name) {
        String value = request.getParameter(name);
        return value == null ? "" : value;
    }
}
