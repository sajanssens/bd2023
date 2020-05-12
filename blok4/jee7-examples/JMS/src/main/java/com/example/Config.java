package com.example;

import javax.annotation.Resource;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.jms.JMSDestinationDefinition;
import javax.jms.Queue;

@Dependent // to enable this class as a bean
@JMSDestinationDefinition(
        name = "java:app/testQueue",
        interfaceName = "javax.jms.Queue",
        destinationName = "testQueue")
public class Config {

    @Resource(lookup = "java:app/testQueue")
    private Queue testQueue;

    @Produces
    public Queue testQueue() { return testQueue; }

}
