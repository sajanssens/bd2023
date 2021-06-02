package com.state;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.naming.NamingException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(Arquillian.class)
public class StatefulVSStatelessIT {
    // should be two different instances
    @Inject private StatefulBean stateful1; // ----> @123 A PB, PC
    @Inject private StatefulBean stateful2; // ----> @456 B AP, AB

    // should be the same instance
    @Inject private StatelessBean stateless1; // ---> @789 C PB, PC, AP, AB
    @Inject private StatelessBean stateless2; // -|

    @Deployment
    public static WebArchive createDeployment() {
        WebArchive archive = ShrinkWrap.create(WebArchive.class, "stateapp.war")
                .addPackage(StatefulBean.class.getPackage());
        System.out.println(archive.toString(true));
        return archive;
    }

    @Test
    public void testWinkelwagen() throws NamingException {
        stateful1.addItem("User Piet: Bike");
        stateful1.addItem("User Piet: Car");
        stateful2.addItem("User Ann: Plane");
        stateful2.addItem("User Ann: Bicycle");

        stateless1.addItem("User Piet: Bike");
        stateless1.addItem("User Piet: Car");
        stateless2.addItem("User Ann: Plane");
        stateless2.addItem("User Ann: Bicycle");

        System.out.println(stateful1.info());
        System.out.println(stateful2.info());
        System.out.println(stateless1.info());
        System.out.println(stateless2.info());

        assertEquals(2, stateful1.getItems().size());
        assertEquals(2, stateful2.getItems().size());
        assertEquals(4, stateless1.getItems().size());
        assertEquals(4, stateless2.getItems().size());

        assertNotEquals(stateful1.objectId(), stateful2.objectId());
        assertEquals(stateless1.objectId(), stateless2.objectId());
    }

}
