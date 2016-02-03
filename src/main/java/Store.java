public class Store {

    private static final int STOCK_TRANSFER_BLOCK_SIZE = 10;
    private static final int STOCK_TRANSFER_COST_PER_BLOCK = 400;

    private final String name;
    private int itemCount;
    private final float unitCost;

    public Store(String name, int itemCount, float unitCost) {
        this.name = name;
        this.itemCount = itemCount;
        this.unitCost = unitCost;
    }

    public String getName() {
        return name;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void reduceItemCount(int lessCount) throws Exception {
        if(this.itemCount - lessCount < 0) {
            throw new Exception("Insufficient items left in Store");
        }
        this.itemCount -= lessCount;
    }

    public float getOrderCost(Order order) {
        float minimumCost = this.unitCost * order.getOrderQuantity();
        if(!order.getStoreName().equals(this.name)) {
            minimumCost += Math.ceil((float)order.getOrderQuantity() / STOCK_TRANSFER_BLOCK_SIZE) * STOCK_TRANSFER_COST_PER_BLOCK;
        }
        return minimumCost;
    }

    public float getUnitCost() {
        return unitCost;
    }
}
