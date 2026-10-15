
public abstract class Payment {

    protected double amount;

    public Payment(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException(
                "Payment amount must be positive and finite"
            );
        }

        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public abstract void processPayment();

    public void printReceipt() {
        System.out.println("Payment amount: Rs. " + amount);
    }
}
