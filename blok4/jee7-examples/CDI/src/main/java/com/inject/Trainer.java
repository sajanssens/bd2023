package com.inject;

// In Java 14:
// public record Trainer(long id, String name){}

public class Trainer {

    private long id;

    private String name;

    public Trainer(long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
