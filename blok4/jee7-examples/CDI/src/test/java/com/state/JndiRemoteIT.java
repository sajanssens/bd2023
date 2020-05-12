package com.state;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(Arquillian.class)
public class JndiRemoteIT {

    @Deployment
    public static Archive createDeployment() {
        Archive archive = ShrinkWrap.create(WebArchive.class, "stateapp.war")
                .addPackage(StatefulBean.class.getPackage());

        System.out.println(archive.toString(true));

        return archive;
    }

    @Test
    public void testJNDIGlobal() throws NamingException {
        InitialContext context = new InitialContext();

        // java:global[/<app-name>]/<module-name>/<ejb-name>
        // Application names are required only if the application is packaged within an EAR

        // should be two different instances
        Object stateful1 = context.lookup("java:global/stateapp/StatefulBean!com.state.StatefulBean");
        Object stateful2 = context.lookup("java:global/stateapp/StatefulBean"); // shorter version

        // should be the same instance
        Object stateless1 = context.lookup("java:global/stateapp/MyStatelessBean"); // explicitly named
        Object stateless2 = context.lookup("java:global/stateapp/MyStatelessBean");

        assertNotEquals(stateful1, stateful2);
        assertEquals(stateless1, stateless2);
    }

    @Test
    public void testJNDIApp() throws NamingException {
        InitialContext context = new InitialContext();

        // java:app/<module-name>/<ejb-name>

        // should be two different instances
        Object stateful1 = context.lookup("java:app/stateapp/StatefulBean"); // shorter version
        Object stateful2 = context.lookup("java:app/stateapp/StatefulBean!com.state.StatefulBean");

        assertNotEquals(stateful1, stateful2);
    }

    @Test
    public void testJNDIModule() throws NamingException {
        InitialContext context = new InitialContext();

        // java:module/<ejb-name>

        Object stateful1 = context.lookup("java:module/StatefulBean"); // shorter version
        Object stateful2 = context.lookup("java:module/StatefulBean!com.state.StatefulBean");

        assertNotEquals(stateful1, stateful2);
    }
}
