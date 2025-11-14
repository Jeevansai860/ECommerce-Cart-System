package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> cartItems = new ArrayList<>();

    public void addProduct(Product p) {
        cartItems.add(p);
    }

    public void removeProduct(Product p) {
        cartItems.remove(p);
    }

    public void viewCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            for (Product p : cartItems) {
                p.displayDetails();
            }
        }
    }

    public List<Product> getCartItems() {
        return cartItems;
    }
}
