package com.example;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AsyncBeanClient {

    @EJB // == @Inject
    AsyncBeanService asyncBeanService;

    public long processWork(String data) {
        System.out.println("[1]");
        long currentTimeMillisBefore = System.currentTimeMillis();
        asyncBeanService.doSomeAsyncThing(data); // na 2000 ms [3]
        asyncBeanService.doAnotherAsyncThing(data); // na 1000 ms [2]
        long currentTimeMillisAfter = System.currentTimeMillis();
        long elapsedMilliSeconds = currentTimeMillisAfter - currentTimeMillisBefore;
        System.out.println("[4] elapsed time in milliseconds: " + elapsedMilliSeconds);
        return elapsedMilliSeconds;
    }
}
