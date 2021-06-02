package com.decorator.any;

@EN
public class ENGreeting implements Greeting {

    @Override
    public String greet(String name) {
        return "Hello " + name;
    }

}