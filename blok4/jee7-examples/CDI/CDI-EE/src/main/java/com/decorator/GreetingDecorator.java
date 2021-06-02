package com.decorator;

import com.decorator.any.Greeting;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

//Also defined in the beans.xml
@Decorator
public class GreetingDecorator implements Greeting {

    // @Inject Logger log;
    @Inject @Delegate Greeting greeting;

    @Override
    public String greet(String name) {
        // log.info("GreetingDecorator called");
        return greeting.greet(name + " from GreetingDecorator");
    }

}
