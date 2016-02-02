public class Inventory {

    private static final int INITIAL_ITEM_COUNT = 100;
    private static final int ITEM_COST_IN_STORE_A = 50;
    private static final int ITEM_COST_IN_STORE_B = 100;
    private static final int STOCK_TRANSFER_BLOCK_SIZE = 10;
    private static final int STOCK_TRANSFER_COST_PER_BLOCK = 400;

    private int itemLeftInStoreA = INITIAL_ITEM_COUNT;
    private int itemLeftInStoreB = INITIAL_ITEM_COUNT;

    String placeOrder(String orderData) {

        int minimumCostFromStoreA = 0;
        int minimumCostFromStoreB = 0;
        int minimumCost = 0;

        try {
            Order order = new InputParser().parse(orderData);

            minimumCostFromStoreA = ITEM_COST_IN_STORE_A * order.getOrderQuantity();
            minimumCostFromStoreB = ITEM_COST_IN_STORE_B * order.getOrderQuantity();

            if(order.getStoreName().equals("A")) {
                minimumCostFromStoreB += Math.ceil((float)order.getOrderQuantity() / STOCK_TRANSFER_BLOCK_SIZE) * STOCK_TRANSFER_COST_PER_BLOCK;
            } else {
                minimumCostFromStoreA += Math.ceil((float)order.getOrderQuantity() / STOCK_TRANSFER_BLOCK_SIZE) * STOCK_TRANSFER_COST_PER_BLOCK;
            }

            if(minimumCostFromStoreA < minimumCostFromStoreB) {
                minimumCost = minimumCostFromStoreA;
                itemLeftInStoreA -= order.getOrderQuantity();
            } else {
                minimumCost = minimumCostFromStoreB;
                itemLeftInStoreB -= order.getOrderQuantity();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return String.format("%d:%d:%d", minimumCost, itemLeftInStoreB, itemLeftInStoreA);
    }
}
