package com.example.cdi;

import com.example.cdi.greetings.ENGreeting;
import org.jboss.weld.junit5.auto.AddBeanClasses;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@EnableAutoWeld
@AddBeanClasses(GreeterSimple.class)
@AddBeanClasses(ENGreeting.class)
class GreeterSimpleTest {

    @Inject private GreeterSimple target;

    @Test
    void hi() {
        String hi = target.hi();
        assertThat(hi, containsString("Hello"));
    }
}
