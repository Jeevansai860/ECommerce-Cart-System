package main;

import models.*;
import services.*;
import exceptions.*;

import java.util.Scanner;

public class ECommerceApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryService inventory = new InventoryService();
        PaymentService paymentService = new PaymentService();
        Cart cart = new Cart();

        while (true) {
            System.out.println("\n1. View Products\n2. Add to Cart\n3. View Cart\n4. Checkout\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (Product p : inventory.getAllProducts()) {
                        p.displayDetails();
                    }
                    break;
                case 2:
                    System.out.print("Enter Product ID to add: ");
                    int id = sc.nextInt();
                    try {
                        Product p = inventory.getProductById(id);
                        cart.addProduct(p);
                        System.out.println(p.getName() + " added to cart.");
                    } catch (OutOfStockException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    cart.viewCart();
                    break;
                case 4:
                    Order order = new Order(cart.getCartItems());
                    double total = order.calculateTotal();
                    System.out.print("Enter payment method (card/upi): ");
                    String method = sc.next();
                    try {
                        paymentService.processPayment(method, total);
                        order.confirmOrder();
                    } catch (InvalidPaymentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
