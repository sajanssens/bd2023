package com.example.cdi;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

public class EventFirer {

    // example of injecting event
    @Inject @Any Event<Person> personEvent;

    public void fireEvent() {
        personEvent.fire(new Person("I'm fired!"));
    }

}
