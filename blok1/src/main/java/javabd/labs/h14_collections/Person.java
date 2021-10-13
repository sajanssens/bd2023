package javabd.labs.h14_collections;

import javabd.labs.h10_inheritance.Human;
import javabd.labs.h7_objectorientation.Gender;
import javabd.labs.h7_objectorientation.PersonDiedException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Person extends Human implements Comparable<Person>, Iterable<Person.HistoryRecord> {
    public static final int numberOfPossibleGenders = 3;

    private String name;
    private int age;
    private Gender gender;
    private List<HistoryRecord> history = new ArrayList<>();

    public Person(String name, int age) {
        this(name, age, Gender.UNKNOWN);
    }

    public Person(String name, int age, Gender g) {
        this.name = name;
        this.age = age;
        this.gender = g;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void birthday() {
        if (this.age >= 130) throw new PersonDiedException();
        this.age++;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getName() {return name;}

    @Override
    public String toString() {
        return name + " (" + age + ") is " + gender;
    }

    // EQUALITY
    // Hier definiëren we de functionele sleutel van dit object.
    // Een persoon is uniek o.b.v. naam, leeftijd en geslacht.
    // Voor deze combinatie van velden moet ook een bijbehorende unieke hash worden gegeven in hashCode.
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) return false;

        Person other = (Person) obj;
        return this.name.equals(other.name) && this.age == other.age && this.gender == other.gender;
    }

    // IDENTITY
    @Override
    public int hashCode() {
        // When overriding equals, you MUST also override hashcode.
        // Otherwise, two equal objects still have different hashcodes (i.e. identities)
        // and therefore will be duplicated in a hashtable, such as a HashSet or HashMap.

        return name.hashCode() * age * gender.hashCode();
        // better hash function:
        // return Objects.hash(name, age, gender);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize called.");
        super.finalize();
    }

    @Override
    public String greet() {
        return "Hello, my name is " + name + ". Nice to meet you!";
    }

    public void addHistory(String descr) {
        this.history.add(new HistoryRecord(descr));
    }

    public void printHistory() {
        for (HistoryRecord historyRecord : history) {
            System.out.println(historyRecord);
        }
    }

    @Override
    public int compareTo(Person other) {
        // moet iets positiefs teruggeven als this>other
        // moet iets negatiefs teruggeven als o1<o2
        // moet nul teruggeven als gelijk

        // we sort persons by age
        if (this.age > other.age) return +1;
        if (this.age < other.age) return -1;
        return 0;
    }

    @Override
    public Iterator<HistoryRecord> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override public boolean hasNext() {
                return index < history.size();
            }

            @Override public HistoryRecord next() {
                return history.get(index++);
            }
        };
    }

    static class HistoryRecord {
        String description;

        public HistoryRecord(String descr) {
            this.description = descr;
        }

        @Override
        public String toString() {return description;}
    }

    public Human createSubHuman() {
        return new Human() {
            @Override
            public String greet() {return "Sub is the best.";}
        };
    }

}
