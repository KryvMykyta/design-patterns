package hw21.task21_3_1;

public class PayPalPayment implements PaymentStrategy {
    @Override
    public void processPayment(int amount) {
        System.out.println("Payment of $" + amount + " made from PayPal.");
    }
}