package com.example;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.DeliveryMode;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import java.time.LocalTime;

@Stateless
public class Producer {

    @Inject // enabled by Config.testQueue() producer method
    private Queue queue;

    @Inject
    private JMSContext context;

    @Schedule(hour = "*", minute = "*", second = "*/3", persistent = false)
    public void automaticallySendMessages() {
        String message = "test message " + LocalTime.now();
        System.out.println("About to send message: " + message);
        JMSProducer producer = context.createProducer();
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        producer.setTimeToLive(2000);
        producer.send(queue, message);
    }
}