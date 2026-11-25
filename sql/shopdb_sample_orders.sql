-- ============================================================
-- (Optional) Sample orders for the Sales Report (Lesson 16)
-- Run shopdb_setup.sql first.
-- user_id: 2 = user, 3 = Bat, 4 = Saraa
-- ============================================================
USE shopdb;

INSERT INTO orders (product_id, product_name, price, category_id, user_id, quantity, delivery_name, delivery_fee, ordered_at) VALUES
    (1, 'Wireless Mouse', 45000, 1, 3, 1, 'Standard', 5000, '2026-10-01 10:15:00'),
    (5, 'Milk Tea 500ml', 4500, 3, 4, 3, 'Express', 10000, '2026-10-01 13:40:00'),
    (7, 'Cashmere Scarf', 180000, 4, 2, 1, 'Standard', 0, '2026-10-02 09:05:00'),
    (3, 'Java Textbook', 38000, 2, 4, 2, 'Express', 10000, '2026-10-02 16:20:00');

SELECT * FROM orders;
