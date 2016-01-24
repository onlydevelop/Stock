import spock.lang.Specification

class InventorySpec extends Specification{

    def "instance is created for Inventory"() {
        setup:
            Inventory inventory = new Inventory()

        expect:
            inventory != null
    }

    def "placing 5 items from StoreB"() {
        setup:
            Inventory inventory = new Inventory()
        expect:
            inventory.placeOrder("B:5") == "5000:95:100"
    }
}
