
public class PaymentProcessor {
    public void pay(Payment payment) {
        payment.processPayment();
        payment.printReceipt();
    }

    public void pay(Payment payment, String reference) {
        System.out.println("Reference: " + reference);
        payment.processPayment();
        payment.printReceipt();
    }
}
