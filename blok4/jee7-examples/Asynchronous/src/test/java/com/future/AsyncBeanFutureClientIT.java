package com.future;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.naming.NamingException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
public class AsyncBeanFutureClientIT {

    @Inject
    private AsyncBeanFutureClient asyncBeanFutureClient;

    private AsyncBeanFutureService asyncBeanFutureService;

    @Deployment
    public static WebArchive createDeployment() {
        WebArchive archive = ShrinkWrap.create(WebArchive.class)
                .addPackage(AsyncBeanFutureClient.class.getPackage());
        System.out.println(archive.toString(true));
        return archive;
    }

    @Before
    public void setUp() throws NamingException {
        asyncBeanFutureService = asyncBeanFutureClient.getAsyncBeanFutureService();
    }

    @Test
    public void processWork() throws InterruptedException, ExecutionException {
        System.out.println("[1]");
        long currentTimeMillisBefore = System.currentTimeMillis();
        Future<String> someAsyncThingFuture = asyncBeanFutureService.doSomeAsyncThing();
        Future<String> anotherAsyncThingFuture = asyncBeanFutureService.doAnotherAsyncThing();
        System.out.println("[5] client code");

        String someAsyncThing = someAsyncThingFuture.get();
        String anotherAsyncThing = anotherAsyncThingFuture.get();
        System.out.println(someAsyncThing);

        long timeUntilAnotherAsyncPrint = System.currentTimeMillis() - currentTimeMillisBefore;
        assertTrue(timeUntilAnotherAsyncPrint >= 2000);
        System.out.println("[6] Time until another async is printed: " + timeUntilAnotherAsyncPrint);
        System.out.println(anotherAsyncThing);

        long currentTimeMillisAfter = System.currentTimeMillis();
        long elapsedMilliSeconds = currentTimeMillisAfter - currentTimeMillisBefore;
        System.out.println("[4] elapsed time in milliseconds: " + elapsedMilliSeconds);
        assertTrue(elapsedMilliSeconds <= 2100);
    }

    @Test
    public void processWorkEfficient() throws InterruptedException, ExecutionException {
        System.out.println("[1]");
        long currentTimeMillisBefore = System.currentTimeMillis();
        Future<String> someAsyncThingFuture = asyncBeanFutureService.doSomeAsyncThing();
        Future<String> anotherAsyncThingFuture = asyncBeanFutureService.doAnotherAsyncThing();
        System.out.println("[5] client code");

        String anotherAsyncThing = anotherAsyncThingFuture.get();
        System.out.println(anotherAsyncThing);

        long timeUntilAnotherAsyncPrint = System.currentTimeMillis() - currentTimeMillisBefore;
        assertTrue(timeUntilAnotherAsyncPrint < 1100);
        System.out.println("[6] Time until another async is printed: " + timeUntilAnotherAsyncPrint);

        String someAsyncThing = someAsyncThingFuture.get();
        System.out.println(someAsyncThing);

        long currentTimeMillisAfter = System.currentTimeMillis();
        long elapsedMilliSeconds = currentTimeMillisAfter - currentTimeMillisBefore;
        System.out.println("[4] elapsed time in milliseconds: " + elapsedMilliSeconds);
        assertTrue(elapsedMilliSeconds < 2100);
    }

}
