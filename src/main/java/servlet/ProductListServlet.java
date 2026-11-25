package servlet;

import java.io.IOException;
import java.sql.SQLException;

import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/products")
public class ProductListServlet extends HttpServlet {
    private final ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("productList", productDAO.findAll());
        } catch (SQLException e) {
            throw new ServletException("Failed to get the product list.", e);
        }
        request.getRequestDispatcher("/WEB-INF/productList.jsp").forward(request, response);
    }
}
