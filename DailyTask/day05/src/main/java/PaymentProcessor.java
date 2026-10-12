
public class PaymentProcessor {

    // Overloaded method 1
    public void pay(Payment payment) {
        payment.processPayment();
        payment.printReceipt();
    }

    // Overloaded method 2
    public void pay(Payment payment, String reference) {
        System.out.println("Reference: " + reference);
        payment.processPayment();
        payment.printReceipt();
    }
}
