package models;

import java.util.List;

public class Order {
    private List<Product> products;

    public Order(List<Product> products) {
        this.products = products;
    }

    public double calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

    public void confirmOrder() {
        for (Product p : products) {
            p.updateStock(1); // assuming one item each
        }
        System.out.println("Order confirmed. Total: ₹" + calculateTotal());
    }
}
