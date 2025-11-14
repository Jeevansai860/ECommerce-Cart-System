package services;

import models.Product;
import exceptions.OutOfStockException;

import java.util.ArrayList;
import java.util.List;

public class InventoryService {
    private List<Product> productList = new ArrayList<>();

    public InventoryService() {
        productList.add(new Product(1, "Laptop", 50000, 5));
        productList.add(new Product(2, "Mobile", 20000, 0)); // out of stock
        productList.add(new Product(3, "Headphones", 2000, 10));
        productList.add(new Product(4, "Keyboard", 1500, 7));
        productList.add(new Product(5, "Mouse", 800, 15));
        productList.add(new Product(6, "Monitor", 12000, 4));
        productList.add(new Product(7, "Webcam", 3000, 6));
        productList.add(new Product(8, "Smartwatch", 7000, 9));
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public Product getProductById(int id) throws OutOfStockException {
        for (Product p : productList) {
            if (p.getId() == id) {
                if (p.getStockQuantity() <= 0) {
                    throw new OutOfStockException("Product is out of stock.");
                }
                return p;
            }
        }
        return null;
    }
}
