package com.example;

import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AsyncBeanMyself {

	@Inject
	AsyncBeanMyself myself;
	
	public long processWork(String data) throws InterruptedException {
		System.out.println("[1]");
		long currentTimeMillisBefore = System.currentTimeMillis();
		myself.doSomeAsyncThing(data);
		myself.doAnotherAsyncThing(data);
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
