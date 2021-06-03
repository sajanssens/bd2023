package com.example;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;
import javax.jms.JMSDestinationDefinition;
import javax.jms.Queue;

@JMSDestinationDefinition( // lookup the queue, defined in server.xml
        name = "java:app/testQueue", // JNDI name of the destination resource being defined.
        interfaceName = "javax.jms.Queue",
        destinationName = "testQueue")
@Singleton
public class AppConfig {

    @Resource(lookup = "java:app/testQueue") // the JNDI name from JMSDestinationDefinition
    private Queue testQueue;

    @Produces
    public Queue testQueue() { return testQueue; }

}
