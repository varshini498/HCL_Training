
public class Main {

    public static void main(String[] args) {

        InventoryService service = new InventoryService();

        try {
            service.processSale(0);
        } catch (InsufficientStockException e) {
            System.out.println("Stock error: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Service error: " + e.getMessage());
            System.out.println(
                "Original cause: " + e.getCause().getMessage()
            );
        } finally {
            System.out.println("Inventory operation completed.");
        }
    }
}
