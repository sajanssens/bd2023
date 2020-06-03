package com.example;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

@Stateless
public class AsyncBean {

    public long processWork(String data) throws InterruptedException {
        System.out.println("[1]");
        long currentTimeMillisBefore = System.currentTimeMillis();
        doSomeAsyncThing(data);
        doAnotherAsyncThing(data);
        long currentTimeMillisAfter = System.currentTimeMillis();
        long elapsedMilliSeconds = currentTimeMillisAfter - currentTimeMillisBefore;
        System.out.println("[4] elapsed time in milliseconds: " + elapsedMilliSeconds);
        return elapsedMilliSeconds;
    }

    @Asynchronous
    public void doSomeAsyncThing(String data) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        System.out.println("[3] async " + data);
    }

    @Asynchronous
    public void doAnotherAsyncThing(String data) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        System.out.println("[2] another async " + data);
    }
}
