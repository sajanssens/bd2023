package unittesting.lab1.stringadder;

public class StringAdderRefactored {

    // labs 1, 2 and 3 refactored
    public int add(String nums) {
        try {
            if (!hasComma(nums)) {
                return toInt(nums);
            } else {
                int p = positionOfFirstComma(nums);
                String beforeComma = beforeComma(nums, p);
                String afterComma = afterComma(nums, p);

                return add(beforeComma) + add(afterComma);
            }
        } catch (Exception c) {
            throw new NotYetImplementedException("TODO", c);
        }
    }

    private int toInt(String numberAsString) {
        if (numberAsString.isEmpty()) {
            return 0;
        } else {
            return parse(numberAsString);
        }
    }

    private int positionOfFirstComma(String numbersAsString) {
        return numbersAsString.indexOf(",");
    }

    private boolean hasComma(String numbersAsString) {
        return numbersAsString.contains(",");
    }

    private String afterComma(String numbersAsString, int positionComma) {
        return numbersAsString.substring(positionComma + 1);
    }

    private String beforeComma(String numbersAsString, int positionComma) {
        return numbersAsString.substring(0, positionComma);
    }

    private int parse(String numbersAsString) {
        return Integer.parseInt(numbersAsString);
    }
}
