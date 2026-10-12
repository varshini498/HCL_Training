
public class DebugPractice {

    public static void main(String[] args) {

        int stock = 10;
        int quantity = 0;
        int pricePerItem = 100;

        if (quantity <= 0) {
            System.out.println("Error: Quantity must be greater than zero.");
            return;
        }

        if (quantity > stock) {
            System.out.println("Error: Insufficient stock.");
            return;
        }

        int total = pricePerItem * quantity;

        System.out.println("Stock remaining: " + (stock - quantity));
        System.out.println("Total price: Rs. " + total);
    }
}
