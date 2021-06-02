package com.events;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.naming.NamingException;

@RunWith(Arquillian.class)
public class WinkelWagenManagerIT {
    @Inject
    private WinkelwagenManager winkelWagenManager;

    @Deployment
    public static WebArchive createDeployment() {
        WebArchive archive = ShrinkWrap.create(WebArchive.class)
                .addPackage(WinkelwagenManager.class.getPackage());
        System.out.println(archive.toString(true));
        return archive;
    }


    @Test
    public void testWinkelwagen() throws NamingException {
        winkelWagenManager.addItem();
    }
}
