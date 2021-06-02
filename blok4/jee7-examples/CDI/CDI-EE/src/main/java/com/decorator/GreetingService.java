package com.decorator;

import com.decorator.any.Greeting;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class GreetingService {

    @Inject private Greeting greeting;

    @Inject private Greeting greeting2;

    public String greet(String name) { return greeting.greet(name); }

    public String greet2(String name) { return greeting2.greet(name); }

}
