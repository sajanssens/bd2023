package com.example;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

@Stateless
public class AsyncBeanService {

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
