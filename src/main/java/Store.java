public class Store {

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

    public float getUnitCost() {
        return unitCost;
    }
}
