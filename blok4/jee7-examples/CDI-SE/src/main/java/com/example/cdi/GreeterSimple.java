package com.example.cdi;

import com.example.cdi.greetings.IGreeting;

import javax.inject.Inject;

public class GreeterSimple {

    @Inject IGreeting iGreeting;

    public String hi() { return iGreeting.greet("Bram"); }

}
