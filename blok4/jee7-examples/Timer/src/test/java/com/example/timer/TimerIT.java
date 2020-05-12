package com.example.timer;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
public class TimerIT {

    @Deployment
    public static WebArchive createDeployment() {
        WebArchive archive = ShrinkWrap.create(WebArchive.class)
                .addPackage(AutomaticTimer.class.getPackage());
        System.out.println(archive.toString(true));
        return archive;
    }

    @EJB ProgrammaticTimer timer;

    @Test
    public void testTimers() throws Exception {
        Thread.sleep(11000);
        assertTrue(timer.getTicks() > 0);
    }

}