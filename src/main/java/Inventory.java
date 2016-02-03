public class Inventory {

    private final Store storeA = new Store("A", 100, 50);
    private final Store storeB = new Store("B", 100, 100);

    public String placeOrder(String orderData) {
        try {
            Order order = new InputParser().parse(orderData);
            float minimumCost = getMinimumCost(order);
            return String.format("%d:%d:%d", (int)minimumCost, storeB.getItemCount(), storeA.getItemCount());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return "";
    }

    private float getMinimumCost(Order order) throws Exception {
        float minimumCost = (storeA.getOrderCost(order) < storeB.getOrderCost(order))
            ? storeA.getOrderCost(order) : storeB.getOrderCost(order);

        if(storeA.getOrderCost(order) < storeB.getOrderCost(order)) {
            storeA.reduceItemCount(order.getOrderQuantity());
        } else {
            storeB.reduceItemCount(order.getOrderQuantity());
        }

        return minimumCost;
    }
}
