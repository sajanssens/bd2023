package com.decorator;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class GreetingServiceIT {
    @Inject
    private GreetingService greetingService;

    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive archive = ShrinkWrap.create(JavaArchive.class)
                .addPackages(true, GreetingService.class.getPackage())
                .addAsManifestResource(new StringAsset("<decorators><class>com.decorator.GreetingDecorator</class></decorators>"), "beans.xml");

        System.out.println(archive.toString(true));
        return archive;
    }

    @Test
    public void testDecorator() {
        assertEquals("Hello Martijn from GreetingDecorator", greetingService.greet("Martijn"));
        assertEquals("Hello Bram from GreetingDecorator", greetingService.greet2("Bram"));
    }
}
