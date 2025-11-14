package services;

import exceptions.InvalidPaymentException;

public class PaymentService {
    public void processPayment(String method, double amount) throws InvalidPaymentException {
        if (!method.equalsIgnoreCase("card") && !method.equalsIgnoreCase("upi")) {
            throw new InvalidPaymentException("Unsupported payment method: " + method);
        }
        if (amount <= 0) {
            throw new InvalidPaymentException("Invalid payment amount.");
        }
        System.out.println("Payment of ₹" + amount + " via " + method + " successful.");
    }
}
