public class Inventory {

    private static final int INITIAL_ITEM_COUNT = 100;
    private static final int ITEM_COST_IN_STORE_A = 50;
    private static final int ITEM_COST_IN_STORE_B = 100;

    private static int itemLeftInStoreA = INITIAL_ITEM_COUNT;
    private static int itemLeftInStoreB = INITIAL_ITEM_COUNT;

    String placeOrder(String orderData) {

        int minimumCost = 0;
        try {
            Order order = new InputParser().parse(orderData);

            if(order.getStoreName().equals("A")) {
                itemLeftInStoreA -= order.getOrderQuantity();
                minimumCost = ITEM_COST_IN_STORE_A * order.getOrderQuantity();
            } else {
                itemLeftInStoreB -= order.getOrderQuantity();
                minimumCost = ITEM_COST_IN_STORE_B * order.getOrderQuantity();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return String.format("%d:%d:%d", minimumCost, itemLeftInStoreB, itemLeftInStoreA);
    }
}
