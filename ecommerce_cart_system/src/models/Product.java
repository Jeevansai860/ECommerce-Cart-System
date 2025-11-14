package models;

public class Product {
    private int id;
    private String name;
    private double price;
    private int stockQuantity;

    public Product(int id, String name, double price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public void displayDetails() {
        System.out.println(id + " - " + name + " | Price: " + price + " | Stock: " + stockQuantity);
    }

    public void updateStock(int quantity) {
        this.stockQuantity -= quantity;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }
}
