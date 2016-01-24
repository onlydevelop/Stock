import spock.lang.Specification
import spock.lang.Unroll

class InputParserSpec extends Specification{

    InputParser inputParser;

    def setup() {
        inputParser = new InputParser()
    }

    @Unroll
    def "parse the input with #value returns Order object with #storeName and #orderQuantity"(value, storeName, orderQuantity) {

        setup:
            Order order = inputParser.parse("B:5")

        expect:
            storeName == order.storeName
            orderQuantity == order.orderQuantity

        where:
            value   | storeName | orderQuantity
            "B:5"   | "B"       | 5
    }

    @Unroll
    def "parsing the input with #value throws #exception saying #exceptionMessage"(value, exception, exceptionMessage) {

        setup:
            def e = getException(inputParser.&parse, value)

        expect:
            exception == e?.class
            exceptionMessage == e?.message

        where:
            value           | exception    | exceptionMessage
            null            | Exception    | "Input cannot be null or empty"
            ""              | Exception    | "Input cannot be null or empty"
            "invalid:data"  | Exception    | "Input data is invalid"
    }

    Exception getException(closure, ...args){
        try{
            closure.call(args)
            return null
        } catch(any) {
            return any
        }
    }

    def cleanup() {
        inputParser = null
    }
}
