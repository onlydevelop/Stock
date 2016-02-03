import spock.lang.Specification

class StoreSpec extends Specification {

    def "creates a Store with name, number of items and unit cost"() {
        setup:
        Store store = new Store("A", 100, 50)

        expect:
        store.name == "A"
        store.itemCount == 100
        store.unitCost == 50
    }
}
