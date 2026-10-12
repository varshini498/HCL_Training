
public class Main {

    public static void main(String[] args) {

        PaymentProcessor processor = new PaymentProcessor();

        Payment card = new CardPayment(2000);
        Payment upi = new UPIPayment(1500);
        Payment cash = new CashPayment(500);

        System.out.println("=== Card Payment ===");
        processor.pay(card);

        System.out.println("\n=== UPI Payment ===");
        processor.pay(upi, "TXN101");

        System.out.println("\n=== Cash Payment ===");
        processor.pay(cash);

        System.out.println("\n=== Refund ===");

        Refundable refundable = new CardPayment(2000);
        refundable.refund(500);
    }
}
