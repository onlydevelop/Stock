public class Inventory {

    private final Store storeA = new Store("A", 100, 50);
    private final Store storeB = new Store("B", 100, 100);

    private static final int STOCK_TRANSFER_BLOCK_SIZE = 10;
    private static final int STOCK_TRANSFER_COST_PER_BLOCK = 400;

    public String placeOrder(String orderData) {

        float minimumCostFromStoreA = 0;
        float minimumCostFromStoreB = 0;
        float minimumCost = 0;

        try {
            Order order = new InputParser().parse(orderData);

            minimumCostFromStoreA = getMinimumCostFromStore(order, "A");
            minimumCostFromStoreB = getMinimumCostFromStore(order, "B");
            minimumCost = (minimumCostFromStoreA < minimumCostFromStoreB)
                ? minimumCostFromStoreA : minimumCostFromStoreB;
            
            if(minimumCostFromStoreA < minimumCostFromStoreB) {
                storeA.reduceItemCount(order.getOrderQuantity());
            } else {
                storeB.reduceItemCount(order.getOrderQuantity());
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return String.format("%d:%d:%d", (int)minimumCost, storeB.getItemCount(), storeA.getItemCount());
    }

    private float getMinimumCostFromStore(Order order, String fromStore) {
        Store store = fromStore.equals("A") ? storeA : storeB;
        float minimumCostFromStore = store.getUnitCost() * order.getOrderQuantity();
        if(!order.getStoreName().equals(store.getName())) {
            minimumCostFromStore += Math.ceil((float)order.getOrderQuantity() / STOCK_TRANSFER_BLOCK_SIZE) * STOCK_TRANSFER_COST_PER_BLOCK;
        }
        return minimumCostFromStore;
    }
}
