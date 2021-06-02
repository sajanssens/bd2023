package com.producer;

import com.alternative.CoderMock;
import com.decorator.GreetingService;
import com.inject.Trainer;
import com.interceptor.CourseRepository;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.naming.NamingException;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class TrainerServiceProducerIT {
    @Inject
    private TrainerServiceProducer trainerServiceProducer;

    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive archive = ShrinkWrap.create(JavaArchive.class)
                .addPackage(TrainerServiceProducer.class.getPackage())
                .addPackage(Trainer.class.getPackage())
                .addAsManifestResource("META-INF/beans.xml", "beans.xml")
                .addPackages(true, GreetingService.class.getPackage()) // because class is mentioned in beans.xml
                .addPackage(CoderMock.class.getPackage()) // because class is mentioned in beans.xml
                .addPackage(CourseRepository.class.getPackage()); // because class is mentioned in beans.xml

        // The following works as well instead of addAsManifestResource and addPackage's
        // Scans for all classes not just the ones with an annotation (which is the default)
        //.addAsManifestResource(newBeansDescriptor("all"), "beans.xml");

        System.out.println(archive.toString(true));
        return archive;
    }

    private static StringAsset newBeansDescriptor(String mode) {
        return new StringAsset("<beans bean-discovery-mode=\"" + mode + "\" version=\"1.1\"/>");
    }

    @Test
    public void retrieveTrainers() throws NamingException {
        assertEquals(trainerServiceProducer.retrieveTrainers().size(), 3);
    }
}