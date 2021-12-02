package com.example;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

@RunWith(Arquillian.class)
public class JmsIT {

    @Deployment
    public static WebArchive createDeployment() {
        WebArchive archive = ShrinkWrap.create(WebArchive.class, "JMS.war")
                .addPackage(Consumer.class.getPackage())
                .addAsWebInfResource("beans-alternative.xml", "beans.xml");

        System.out.println(archive.toString(true));
        return archive;
    }

    @Inject
    private MessageHandler messageHandler;

    @Test
    public void testMessageInTopic() throws InterruptedException {
        MessageHandlerTestable testHandler = (MessageHandlerTestable) messageHandler;
        assertThat(testHandler.poll(10), containsString("test message"));
    }

}
