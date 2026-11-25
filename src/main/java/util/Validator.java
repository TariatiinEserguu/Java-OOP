package util;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static boolean isNumberAtLeast(String value, int min) {
        try {
            return Integer.parseInt(value) >= min;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static List<String> validateProduct(String name, String price, String stock) {
        List<String> errors = new ArrayList<>();
        if (name.isEmpty()) {
            errors.add("Name is required.");
        }
        if (price.isEmpty()) {
            errors.add("Price is required.");
        } else if (!isNumberAtLeast(price, 0)) {
            errors.add("Price must be a number of 0 or more.");
        }
        if (stock.isEmpty()) {
            errors.add("Stock is required.");
        } else if (!isNumberAtLeast(stock, 0)) {
            errors.add("Stock must be a number of 0 or more.");
        }
        return errors;
    }

    public static List<String> validateOrder(String quantity) {
        List<String> errors = new ArrayList<>();
        if (!isNumberAtLeast(quantity, 1)) {
            errors.add("Quantity must be a number of 1 or more.");
        }
        return errors;
    }
}
