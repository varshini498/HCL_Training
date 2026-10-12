
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

    // Child classes must implement this method
    public abstract void processPayment();

    // Common method shared by all payment types
    public void printReceipt() {
        System.out.println("Payment amount: Rs. " + amount);
    }
}
