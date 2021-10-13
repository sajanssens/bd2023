package javabd.labs.h14_collections;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toMap;

public class Sorting {

    private static final List<Person> people = Arrays.asList(
            new Person("Bram", 42),
            new Person("Jimmy3", 29),
            new Person("Amber", 23),
            new Person("Jimmy2", 29),
            new Person("Jimmy", 29),
            new Person("Anton", 42));

    public static void main(String[] args) {
        // To be able to sort persons, we need to implement Comparable<Person> in Person.
        sortedUtil();
        sortedSet();
        sortedMap();
    }

    private static void sortedUtil() {
        System.out.println("sortedUtil");
        Collections.shuffle(people);
        Collections.sort(people); // sort on natural ordering, i.e. age
        System.out.println(people);

        Collections.shuffle(people);
        Collections.sort(people, comparing(Person::getName));  // sort on other ordering, i.e. name
        System.out.println(people);
    }

    private static void sortedSet() {
        System.out.println("sortedSet");

        Collections.shuffle(people);
        System.out.println(people);
        Set<Person> sortedSet = new TreeSet<>(people);
        System.out.println(sortedSet);
    }

    private static void sortedMap() {
        System.out.println("sortedMap");

        Collections.shuffle(people);
        System.out.println(people);

        Map<Integer, Person> sortedMap = new TreeMap<>();

        // create map from list, classic style:
        for (Person person : people) {
            sortedMap.put(person.getAge(), person);
        }

        // create map from list, streaming style:
        sortedMap = people.stream().collect(toMap(Person::getAge, p -> p));

        System.out.println(sortedMap);
    }

}
