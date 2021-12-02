package com.example;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MessageHandlerUntestable implements MessageHandler {

    @Override
    public void handleMessage(String text) {
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
