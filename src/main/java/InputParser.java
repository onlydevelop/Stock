public class InputParser {

    Order parse(String inputData) throws Exception {

        if(inputData == null || inputData == "") {
            throw new Exception("Input cannot be null or empty");
        }

        String[] inputTokens = inputData.split(":");
        int orderQuantity = 0;

        try {
            orderQuantity = Integer.parseInt(inputTokens[1]);
        } catch (NumberFormatException nfe) {
            throw new Exception("Input data is invalid");
        }

        return new Order(inputTokens[0], orderQuantity);
    }
}
