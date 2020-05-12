package com.example.cdi.greetings;

import com.example.cdi.greeters.qualifiers.NL;

import javax.enterprise.context.Dependent;

@NL
@Dependent
public class NLGreeting implements IGreeting {
    @Override public String greet(String name) {
        return "Goeiedag " + name;
    }
}