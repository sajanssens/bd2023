package javabd.labs.h14_collections;

public class IterateThroughPersonHistory {

    public static void main(String[] args) {
        Person p1 = new Person("Jan", 45); // implements Iterable<HistoryRecord>

        p1.addHistory("Born");
        p1.addHistory("Went to school");
        p1.addHistory("Got a job");
        p1.addHistory("Got married");

        for (Person.HistoryRecord historyRecord : p1) {
            System.out.println(historyRecord);
        }

    }
}
