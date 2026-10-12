
public class InventoryService {

    private final Inventory inventory = new Inventory();

    public void processSale(int quantity)
            throws InsufficientStockException {

        try {
            inventory.sell(quantity);
        } catch (InvalidQuantityException e) {
            throw new IllegalStateException(
                "Unable to process inventory sale.", e
            );
        }
    }
}
