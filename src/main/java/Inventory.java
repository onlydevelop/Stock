public class Inventory {

    private final Store storeA = new Store("A", 100, 50);
    private final Store storeB = new Store("B", 100, 100);

    public String placeOrder(String orderData) {
        try {
            Order order = new InputParser().parse(orderData);
            float minimumCost = getMinimumCostStore(order).getOrderCost(order);
            getMinimumCostStore(order).reduceItemCount(order.getOrderQuantity());
            return String.format("%d:%d:%d", (int)minimumCost, storeB.getItemCount(), storeA.getItemCount());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return "";
    }

    private Store getMinimumCostStore(Order order) {
        return storeA.getOrderCost(order) < storeB.getOrderCost(order) ? storeA : storeB;
    }
}
