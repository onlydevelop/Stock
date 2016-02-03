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
            "A:30"      | "1500:100:70"
            "B:50"      | "4500:100:50"
    }



    @Unroll
    def "giving #input returns minimum cost as #minimumCost"(input, minimumCost) {
        setup:
        Inventory inventory = new Inventory()
        Order order = new InputParser().parse(input);

        expect:
        inventory.getMinimumCost(order) == (int)minimumCost
        where:
        input       | minimumCost
        "B:5"       | 500
        "A:30"      | 1500
        "B:50"      | 4500
    }
}
