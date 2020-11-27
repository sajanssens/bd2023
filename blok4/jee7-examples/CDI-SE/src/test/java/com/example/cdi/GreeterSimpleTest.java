package com.example.cdi;

import com.example.cdi.greetings.ENGreeting;
import com.example.cdi.observer.Nieuwsbrief;
import org.jboss.weld.junit5.auto.AddBeanClasses;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@EnableAutoWeld
@AddBeanClasses(GreeterSimple.class)
@AddBeanClasses(ENGreeting.class)
public class GreeterSimpleTest {

    @Inject private GreeterSimple target;

    @Test
    public void hi() {
        String hi = target.hi();
        System.out.println(hi);
    }
}
