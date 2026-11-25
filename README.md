# shopapp

Object-Oriented Programming, lesson 12. Add a product to the shop, validate its
name, price and stock, and keep the form values and category selected when
validation fails.

## Run locally

1. Start MySQL. Run `sql/shopdb_setup.sql` to load the classroom data. This
   script drops and recreates the local `shopdb` database.
2. The starter uses `jdbc:mysql://localhost:3306/shopdb` with the demo user
   `root` and password `root`. If your setup differs, set `SHOPAPP_DB_URL`,
   `SHOPAPP_DB_USER`, and `SHOPAPP_DB_PASSWORD` in Tomcat's environment.
3. With JDK 17 or newer and Maven, run `mvn package`. Deploy
   `target/shopapp.war` to Tomcat 11.
4. Open [Product List](http://localhost:8080/shopapp/products) and choose
   **Add Product**.

For the classroom Eclipse setup, import this directory as an existing project,
select the starter's Tomcat 11 and Java 25 runtimes, and copy the three JARs
from the original starter's `src/main/webapp/WEB-INF/lib` into the same folder
in this project before running it on the server.

## Lesson checks

- Run `main.Main` with the JDBC driver on the classpath. It prints the four
  categories and inserts one Desk Lamp, then prints `result:1`.
- On **Add Product**, enter Desk Lamp, PC, 30000, and 4. The app returns to
  the list with the new product. Refreshing the list leaves one new row.
- Try Food with price `abc`, or submit with a blank name. The form shows
  errors, keeps the inputs and category selection, and leaves the list alone.
