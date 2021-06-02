package com.example.cdi;

import com.example.cdi.producers.LoggerProducer;
import org.jboss.weld.junit5.auto.AddBeanClasses;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@EnableAutoWeld // CDI container, not for EJB's.
@AddBeanClasses(EventFirer.class)
@AddBeanClasses(PersonListener.class)
@AddBeanClasses(LoggerProducer.class)
class EventFirerIT {

    @Inject private EventFirer target;

    @Test
    void fireEvent() {
        target.fireEvent();
    }
}
