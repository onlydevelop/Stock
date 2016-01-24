public class InputParser {

    Order parse(String inputData) {
        String[] inputTokens = inputData.split(":");
        return new Order(inputTokens[0], Integer.parseInt(inputTokens[1]));
    }
}
