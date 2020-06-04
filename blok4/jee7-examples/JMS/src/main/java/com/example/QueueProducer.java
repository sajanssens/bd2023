package com.example;

import javax.annotation.Resource;
import javax.enterprise.inject.Produces;
import javax.jms.Queue;

public class QueueProducer {

    @Resource(lookup = "java:app/testQueue") // the JNDI name from AppConfig
    private Queue testQueue;

    @Produces
    public Queue testQueue() { return testQueue; }

}
