public class Order {

    public Order(String storeName, int orderQuantity) {
        this.storeName = storeName;
        this.orderQuantity = orderQuantity;
    }

    public String getStoreName() {
        return storeName;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    private String storeName = "B";
    private int orderQuantity = 5;
}
