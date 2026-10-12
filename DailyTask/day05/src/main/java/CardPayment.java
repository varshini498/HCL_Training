
public class CardPayment extends Payment implements Refundable {

    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public void processPayment() {
        System.out.println(
            "Processing card payment of Rs. " + amount
        );
    }

    @Override
    public void refund(double refundAmount) {
        if (!Double.isFinite(refundAmount)
                || refundAmount <= 0
                || refundAmount > amount) {
            System.out.println("Invalid refund amount.");
            return;
        }

        System.out.println(
            "Card refund initiated: Rs. " + refundAmount
        );
    }
}
