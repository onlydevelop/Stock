import spock.lang.Specification

class InventorySpec extends Specification{

    Inventory inventory

    def setup() {
        inventory = new Inventory()
    }
    
    def "instance is created for Inventory"() {
        expect:
            inventory != null
    }

    def "placing 5 items from StoreB"() {
        expect:
            inventory.placeOrder("B:5") == "5000:95:100"
    }

    def cleanup() {
        inventory = null
    }
}
