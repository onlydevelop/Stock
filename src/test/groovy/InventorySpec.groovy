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
    def "giving #input returns minimum cost from #storeName as #minimumCost"(input, storeName, minimumCost) {
        setup:
        Inventory inventory = new Inventory()
        Order order = new InputParser().parse(input);

        expect:
        inventory.getMinimumCostFromStore(order, storeName) == (int)minimumCost
        where:
        input       | storeName | minimumCost
        "B:5"       | "A"       | 650
        "B:5"       | "B"       | 500
        "A:30"      | "A"       | 1500
        "A:30"      | "B"       | 4200
        "B:50"      | "A"       | 4500
        "B:50"      | "B"       | 5000
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
