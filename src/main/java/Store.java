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

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public float getUnitCost() {
        return unitCost;
    }
}
