package com.example;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Queue;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

@RunWith(Arquillian.class)
public class ProducerIT {

    @Deployment
    public static WebArchive createDeployment() {
        WebArchive archive = ShrinkWrap.create(WebArchive.class)
                .addPackages(true, Producer.class.getPackage())
                .addAsWebInfResource("beans-alternative.xml", "beans.xml");

        System.out.println(archive.toString(true));
        return archive;
    }

    @Resource(lookup = "java:app/testQueue")
    private Queue queue;

    @Inject
    private JMSContext context;

    @Test
    public void testMessageInTopic() {
        JMSConsumer consumer = context.createConsumer(queue);
        String message = consumer.receiveBody(String.class);
        System.out.println("Consumer received body: " + message);
        assertThat(message, containsString("test message"));
    }

}
