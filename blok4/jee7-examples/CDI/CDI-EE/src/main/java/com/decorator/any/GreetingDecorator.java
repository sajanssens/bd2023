package com.decorator.any;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

//Also defined in the beans.xml
@Decorator
public class GreetingDecorator implements Greeting {

    @Inject @Delegate @Any
    Greeting greeting;

    @Override
    public String greet(String name) {
        return greeting.greet(name + " from GreetingDecorator");
    }

}