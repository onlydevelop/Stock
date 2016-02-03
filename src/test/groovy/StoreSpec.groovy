import spock.lang.Specification
import spock.lang.Unroll

class StoreSpec extends Specification {

    def "creates a Store with name, number of items and unit cost"() {
        setup:
        Store store = new Store("A", 100, 50)

        expect:
        store.name == "A"
        store.itemCount == 100
        store.unitCost == 50
    }

    def "reduce items from a Store, reduces number of items"() {
        setup:
        Store store = new Store("A", 100, 50)

        when:
        store.reduceItemCount(5)

        then:
        store.name == "A"
        store.itemCount == 95
        store.unitCost == 50
    }

    def "reduce more item from a Stores itemCount, throws exception"() {
        setup:
        Store store = new Store("A", 100, 50)

        when:
        store.reduceItemCount(101)

        then:
        def e = thrown(Exception)
        e.message == "Insufficient items left in Store"
    }

    @Unroll
    def "giving order #input returns minimum cost as #orderCost"(input, orderCost) {
        setup:
        Store store = new Store("A", 100, 50)
        Order order = new InputParser().parse(input);

        expect:
        store.getOrderCost(order) == orderCost

        where:
        input       | orderCost
        "A:5"       | 250
        "B:5"       | 650
    }
}
