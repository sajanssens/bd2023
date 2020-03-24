package unittesting.lab1.stringadder;

public class StringAdderComplete {

    // labs 1 tm 7.1 refactored
    public int add(String nums) {
        checkEnding(nums);

        String delimiter = getDelimiter(nums);
        String numsFiltered = filter(nums, delimiter);

        checkNegative(numsFiltered, delimiter);

        try {
            if (!hasDelimiter(numsFiltered, delimiter)) {
                return toInt(numsFiltered);
            } else {
                int p = positionOfFirstDelimiter(numsFiltered, delimiter);
                String beforeDelimiter = beforeDelimiter(numsFiltered, p);
                String afterDelimiter = afterDelimiter(numsFiltered, p);

                return add(beforeDelimiter) + add(afterDelimiter); // recursion
            }
        } catch (Exception c) {
            throw new NotYetImplementedException("TODO", c);
        }
    }

    private void checkEnding(String nums) {
        if (nums.endsWith("\n")) throw new IllegalArgumentException("Argument should not end with \\n.");
    }

    private String getDelimiter(String nums) {
        String delimiter = ",";
        if (hasNewDelimiter(nums)) {
            delimiter = nums.substring(2, 3);
            if ("-".equals(delimiter)) throw new IllegalArgumentException("Delimiter may not be '-'.");
        }
        return delimiter;
    }

    private boolean hasNewDelimiter(String nums) {
        return nums.startsWith("//") && "\n".equals(nums.substring(3, 4));
    }

    private String filter(String nums, String delimiter) {
        String numsFiltered = filterDelimiterLeader(nums);
        numsFiltered = replaceNewlinesWithDelimiter(numsFiltered, delimiter);
        return numsFiltered;
    }

    private String filterDelimiterLeader(String nums) {
        if (hasNewDelimiter(nums)) {
            return nums.substring(4);
        }
        return nums;
    }

    private String replaceNewlinesWithDelimiter(String nums, String delimiter) {
        return nums.replaceAll("\\n", delimiter);
    }

    private void checkNegative(String numsFiltered, String delimiter) {
        if (numsFiltered.contains("-")) {
            StringBuilder s = extractTheNegativeNumbers(numsFiltered, delimiter);
            throw new IllegalArgumentException("Numbers may not be negative: " + s);
        }
    }

    private StringBuilder extractTheNegativeNumbers(String numsFiltered, String delimiter) {
        StringBuilder s = new StringBuilder();
        while (true) {
            int i = numsFiltered.indexOf("-");
            if (i == -1) break;
            int j = numsFiltered.indexOf(delimiter, i);
            s.append(numsFiltered, i, j).append(" ");
            numsFiltered = numsFiltered.substring(j + delimiter.length());
        }
        return s;
    }

    private int toInt(String numberAsString) {
        if (numberAsString.isEmpty()) {
            return 0;
        } else {
            int num = parse(numberAsString);
            if (num > 1000) return 0;
            return num;
        }
    }

    private int positionOfFirstDelimiter(String numbersAsString, String delimiter) {
        return numbersAsString.indexOf(delimiter);
    }

    private boolean hasDelimiter(String numbersAsString, String delimiter) {
        return numbersAsString.contains(delimiter);
    }

    private String afterDelimiter(String numbersAsString, int positionComma) {
        return numbersAsString.substring(positionComma + 1);
    }

    private String beforeDelimiter(String numbersAsString, int positionComma) {
        return numbersAsString.substring(0, positionComma);
    }

    private int parse(String numberAsString) {
        return Integer.parseInt(numberAsString);
    }
}
