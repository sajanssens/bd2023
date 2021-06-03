package com.example;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@Alternative
@ApplicationScoped
public class MessageHandlerTestable implements MessageHandler {

    private BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public void doSomething(String text) {
        System.out.println("ExampleMessageHandlerTestable Text was: " + text);
        queue.add(text);
    }

    public String poll(int secondsUntilInterrupt) throws InterruptedException {
        return queue.poll(secondsUntilInterrupt, TimeUnit.SECONDS);
    }

}
