package com.decorator.any;

import javax.ejb.Stateless;

@Stateless
public class DecoratorManager {

//    @Inject
    private MultiGreeting greeting;

    public MultiGreeting getGreeting() {
        return greeting;
    }
}
