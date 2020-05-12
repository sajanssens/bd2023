package com.decorator.any;

@NL
public class NLGreeting implements MultiGreeting {

    @Override
    public String greet(String name) {
        return "Goeiedag " + name;
    }

}