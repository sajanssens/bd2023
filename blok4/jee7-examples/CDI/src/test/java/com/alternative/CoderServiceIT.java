package com.alternative;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.naming.NamingException;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class CoderServiceIT {
    @Inject
    private CoderService coderService;

    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive archive = ShrinkWrap.create(JavaArchive.class)
                .addPackage(CoderService.class.getPackage())
                .addAsManifestResource(new StringAsset("<alternatives><class>com.alternative.CoderMock</class></alternatives>"), "beans.xml")
                // .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
                ;

        System.out.println(archive.toString(true));
        return archive;
    }

    @Test
    public void testAlternative() throws NamingException {
        assertEquals("I mock and I mock...", coderService.letTheCoderWork());
    }
}