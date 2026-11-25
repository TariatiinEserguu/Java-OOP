-- ============================================================
-- shopdb: create all tables and put the first data
-- Run this file again to go back to the first data.
-- WARNING: this deletes the whole shopdb database first.
-- ============================================================
DROP DATABASE IF EXISTS shopdb;
CREATE DATABASE shopdb DEFAULT CHARACTER SET utf8mb4;
USE shopdb;

-- Category of products (Lesson 10, used from Lesson 11)
CREATE TABLE category (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

-- Products (Lesson 10)
CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price INT NOT NULL,
    stock INT NOT NULL,
    category_id INT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category(id)
);

-- Users (Lesson 13)
-- role: 'admin' = can log in to the admin pages
--       'customer' = can order products (Lesson 15)
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    role VARCHAR(20) NOT NULL
);

-- Orders (Lesson 15)
-- The table name is "orders", because ORDER is a reserved word in SQL (ORDER BY).
-- product_name, price and category_id are copied from the product when the order is placed,
-- so the order history does not change even if the product is deleted or its price is changed.
-- product_id has no FOREIGN KEY, so a product can be deleted even after it is ordered.
-- delivery_name and delivery_fee are also saved when the order is placed (Lesson 15),
-- so the order history does not change even if the delivery fee rule is changed.
-- This table is empty at first.
CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    product_name VARCHAR(100) NOT NULL,
    price INT NOT NULL,
    category_id INT NOT NULL,
    user_id INT NOT NULL,
    quantity INT NOT NULL,
    delivery_name VARCHAR(20) NOT NULL,
    delivery_fee INT NOT NULL,
    ordered_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES category(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO category (name) VALUES
    ('PC'),
    ('Book'),
    ('Food'),
    ('Clothes');

INSERT INTO product (name, price, stock, category_id) VALUES
    ('Wireless Mouse', 45000, 12, 1),
    ('USB Keyboard', 65000, 5, 1),
    ('Java Textbook', 38000, 8, 2),
    ('English Dictionary', 52000, 0, 2),
    ('Milk Tea 500ml', 4500, 30, 3),
    ('Chocolate Bar', 3500, 50, 3),
    ('Cashmere Scarf', 180000, 3, 4),
    ('Wool Socks', 25000, 20, 4);

INSERT INTO users (name, password, role) VALUES
    ('admin', 'admin', 'admin'),
    ('user', 'user', 'customer'),
    ('Bat', 'bat', 'customer'),
    ('Saraa', 'saraa', 'customer');

SELECT * FROM category;
SELECT * FROM product;
SELECT * FROM users;
