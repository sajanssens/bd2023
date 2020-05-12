package com.example;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

@Dependent @Default
public class MessageHandlerUntestable implements MessageHandler {

    @Override
    public void doSomething(String text) {
        System.out.println("ExampleMessageHandlerUntestable Text was: " + text);
        // doing a lot of work
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // irrelevant in this scenario
        }
        System.out.println("Handler execution complete.");
    }

}
