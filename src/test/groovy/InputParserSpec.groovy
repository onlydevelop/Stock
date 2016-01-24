import spock.lang.Specification

class InputParserSpec extends Specification{

    def parseInput() {

        setup:
        InputParser inputParser = new InputParser()

        when:
        Order order = inputParser.parse("B:5")

        then:
        order.getStoreName() == "B"
        order.getOrderQuantity() == 5
    }
}
