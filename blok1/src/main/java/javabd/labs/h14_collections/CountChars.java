package javabd.labs.h14_collections;

import java.util.*;
import java.util.function.Predicate;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;

public class CountChars {

    public static void main(String[] args) {
        CountChars countChars = new CountChars();
        String hello_world = "Hello World";

        // the number of unique characters in the string.
        var count1 = countChars.countClassicStyle(hello_world);
        var count2 = countChars.countStreamingStyle(hello_world);
        System.out.println(count1);
        System.out.println(count2);

        // "concordance" of characters
        var concordance1 = countChars.concordanceClassicStyle(hello_world);
        var concordance2 = countChars.concordanceStreamingStyle(hello_world);
        System.out.println(concordance1);
        System.out.println(concordance2);
    }

    public long countClassicStyle(String hello_world) {
        Set<String> chars = new HashSet<>();
        for (String s : hello_world.split("")) {
            chars.add(s);
        }
        return chars.size();
    }

    public long countStreamingStyle(String hello_world) {
        return hello_world.chars().distinct().count();
    }

    public Map<Character, List<Integer>> concordanceClassicStyle(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            map.put(c, getIndexes(s, c));
        }
        return map;
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

    public Map<String, List<Integer>> concordanceStreamingStyle(String input) {
        return stream(input.split(""))
                .distinct()
                .filter(space())
                .collect(toMap(s -> s, s -> getIndexes(input, toChar(s))));
    }

    private Predicate<String> space() {
        return s -> !s.equals(" ");
    }

    private static char toChar(String c) {
        return c.charAt(0);
    }

}
