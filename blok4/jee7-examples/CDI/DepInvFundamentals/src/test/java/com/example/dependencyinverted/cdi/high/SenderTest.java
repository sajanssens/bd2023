package com.example.dependencyinverted.cdi.high;

import com.example.dependencyinverted.cdi.low.Email;
import com.example.dependencyinverted.cdi.util.LoggerProducer;
import org.jboss.weld.junit5.auto.AddBeanClasses;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@EnableAutoWeld
@AddBeanClasses(Sender.class)
@AddBeanClasses(Email.class)
@AddBeanClasses(LoggerProducer.class)
class SenderTest {

    // See src/main/resources/img/DependencyInversion.png

    @Inject private Logger log;
    @Inject private Sender sender;

    @Test
    void hello() { log.info("Hello!"); }

    @Test
    void go() {
        String s = sender.sendAll();
        assertThat(s).contains("sent!");

        String s1 = sender.sendAllBeans();
        assertThat(s1).contains("sent!");
    }
}
