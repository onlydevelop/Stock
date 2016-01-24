import spock.lang.Specification

class InputParserSpec extends Specification{

    InputParser inputParser;

    def setup() {
        inputParser = new InputParser()
    }

    def "parse the input returning an Order object"() {

        when:
        Order order = inputParser.parse("B:5")

        then:
        order.getStoreName() == "B"
        order.getOrderQuantity() == 5
    }

    def "throw exception if the input is null"() {

        when:
        Order order = inputParser.parse(null)

        then:
        def e = thrown(Exception)
        e.message == "Input cannot be null or empty"
    }

    def "throw exception if the input is empty"() {

        when:
        Order order = inputParser.parse("")

        then:
        def e = thrown(Exception)
        e.message == "Input cannot be null or empty"
    }

    def "throw exception if the input is invalid"() {

        when:
        Order order = inputParser.parse("invalid:data")

        then:
        def e = thrown(Exception)
        e.message == "Input data is invalid"
    }

    def cleanup() {
        inputParser = null
    }
}
