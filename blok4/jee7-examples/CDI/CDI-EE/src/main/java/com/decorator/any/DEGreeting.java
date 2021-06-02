package com.decorator.any;

@DE
public class DEGreeting implements Greeting {
    @Override
    public String greet(String name) {
        return "Gutentag " + name;
    }
}