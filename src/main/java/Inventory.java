public class Inventory {

    String placeOrder(String orderData) {

        int minimumCost = 5000;
        int itemLeftInStoreB = 95;
        int itemLeftInStoreA = 100;

        return String.format("%d:%d:%d", minimumCost, itemLeftInStoreB, itemLeftInStoreA);
    }
}
