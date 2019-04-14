import Product.Product;

import java.util.ArrayList;

public class Basket {
    private static ArrayList<Product> basket = new ArrayList<>();

    static void addItems(Product product, int count) {
        for (int i = 0; i < count; i++) {
            basket.add(product);
        }
    }

    public static ArrayList<Product> getBasket() {
        return basket;
    }

    public static void clear() {
        basket.clear();
    }
}
