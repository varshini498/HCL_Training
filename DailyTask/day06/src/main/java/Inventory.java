
public class Inventory {

    private int stock = 4;

    public void sell(int quantity)
            throws InsufficientStockException {

        if (quantity <= 0) {
            throw new InvalidQuantityException(
                "Quantity must be greater than zero."
            );
        }

        if (quantity > stock) {
            throw new InsufficientStockException(
                "Not enough stock. Available: " + stock
            );
        }

        stock -= quantity;

        System.out.println("Sale successful!");
        System.out.println("Remaining stock: " + stock);
    }
}
