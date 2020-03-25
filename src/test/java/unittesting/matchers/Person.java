package unittesting.matchers;

public class Person {
    private int id;
    private String name;
    private String address;

    public Person(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.address = email;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj != null && getClass() == obj.getClass()) &&
                this.id == ((Person) obj).getId();
    }
}
