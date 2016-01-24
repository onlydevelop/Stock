import spock.lang.Specification
import spock.lang.Unroll

class InventorySpec extends Specification{

    def "instance is created for Inventory"() {
        setup:
            Inventory inventory = new Inventory()
        expect:
            inventory != null
    }

    @Unroll
    def "placing #input returns #result"(input, result) {
        setup:
            Inventory inventory = new Inventory()
        expect:
            inventory.placeOrder(input) == result
        where:
            input       | result
            "B:5"       | "500:95:100"
    }
}
