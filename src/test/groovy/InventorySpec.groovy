import spock.lang.Specification

class InventorySpec extends Specification{

    def "instance is created for Inventory"() {
        setup:
            Inventory inventory = new Inventory()

        expect:
            inventory != null
    }
}
