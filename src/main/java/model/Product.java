package model;

public class Product {
    private final int id;
    private final String name;
    private final int price;
    private final int stock;
    private final int categoryId;
    private final String categoryName;

    public Product(int id, String name, int price, int stock, int categoryId) {
        this(id, name, price, stock, categoryId, null);
    }

    public Product(int id, String name, int price, int stock, int categoryId, String categoryName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
