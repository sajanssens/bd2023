package javabd.labs.h14_collections;

import java.util.*;

import static java.util.stream.Collectors.toMap;

public class CountChars {

    public static void main(String[] args) {
        oldStyle();
        streamingStyle();
    }

    private static void oldStyle() {
        String s = "Hello World";

        Map<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            map.put(c, getIndexes(s, c));
        }
        System.out.println(map);
    }

    private static List<Integer> getIndexes(String s, char c) {
        List<Integer> indexes = new ArrayList<>();
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == c) {
                indexes.add(j);
            }
        }
        return indexes;
    }

    private static void streamingStyle() {
        String input = "Hello World";

        String[] letters = input.split("");
        Map<String, List<Integer>> map =
                Arrays.stream(letters)
                        .distinct()
                        .filter(s -> !s.equals(" "))
                        .collect(toMap(s -> s, s -> getIndexes(input, toChar(s))));
        System.out.println(map);
    }

    private static char toChar(String c) {
        return c.charAt(0);
    }

}
