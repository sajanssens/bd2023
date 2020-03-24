package unittesting.lab1.stringadder;

public class StringAdder {

    // labs 1, 2 and 3.
    public int add(String numbersAsString) {
        if (numbersAsString.isEmpty()) {
            return 0;
        } else {
            try {
                if (!containsStringComma(numbersAsString)) {
                    return convertToInt(numbersAsString);
                } else {
                    int positionComma = positionOfCommaInString(numbersAsString);
                    String firstPart = extractSubstringFromBeginning(numbersAsString, positionComma);
                    String secondPart = extractSubstringFromPositionCommaToEnd(numbersAsString, positionComma);

                    return convertStringIncludingEmptyStringToInt(firstPart)
                            + add(secondPart); // recursion
                }
            } catch (Exception c) {
                // If hit then I haven't thought about it
                throw new NotYetImplementedException("not yet implemented", c);
            }
        }
    }

    private int convertStringIncludingEmptyStringToInt(String numberAsString) {
        if (numberAsString.isEmpty()) {
            return 0;
        } else {
            return convertToInt(numberAsString);
        }
    }

    private int positionOfCommaInString(String numbersAsString) {
        return numbersAsString.indexOf(",");
    }

    private boolean containsStringComma(String numbersAsString) {
        return numbersAsString.contains(",");
    }

    private String extractSubstringFromPositionCommaToEnd(String numbersAsString, int positionComma) {
        return numbersAsString.substring(positionComma + 1);
    }

    private String extractSubstringFromBeginning(String numbersAsString, int positionComma) {
        return numbersAsString.substring(0, positionComma);
    }

    private int convertToInt(String numbersAsString) {
        return Integer.parseInt(numbersAsString);
    }
}
