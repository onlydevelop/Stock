import spock.lang.Specification

class OrderSpec extends Specification{

    def "creates an Order with store name and order quantity"() {
        setup:
            Order order = new Order("B", 5)
        expect:
            order.storeName == "B"
            order.orderQuantity == 5
    }
}
