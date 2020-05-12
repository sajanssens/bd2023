package com.example;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AsyncBeanClient {

	@EJB
	AsyncBeanService asyncBeanService;
	
	public long processWork(String data) throws InterruptedException {
		System.out.println("[1]");
		long currentTimeMillisBefore = System.currentTimeMillis();
		asyncBeanService.doSomeAsyncThing(data);
		asyncBeanService.doAnotherAsyncThing(data);
		long currentTimeMillisAfter = System.currentTimeMillis();
		long elapsedMilliSeconds = currentTimeMillisAfter - currentTimeMillisBefore;
		System.out.println("[4] elapsed time in milliseconds: " + elapsedMilliSeconds);
		return elapsedMilliSeconds;
	}
}
