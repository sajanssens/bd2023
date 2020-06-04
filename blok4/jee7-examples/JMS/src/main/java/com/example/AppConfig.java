package com.example;

import javax.enterprise.context.Dependent;
import javax.jms.JMSDestinationDefinition;

@Dependent // to enable this class as a bean
@JMSDestinationDefinition( // define and create a Queue
        name = "java:app/testQueue", // JNDI name of the destination resource being defined.
        interfaceName = "javax.jms.Queue",
        destinationName = "testQueue")
public class AppConfig {}
