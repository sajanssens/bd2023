package com.example;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.net.URL;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(Arquillian.class)
public class StudentsResourceIT {

    @ArquillianResource private URL deploymentURL;
    private String studentsResource;

    @Before
    public void setup() {
        studentsResource = deploymentURL + "resources/students";
    }

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(StudentsResource.class.getPackage())
                .addAsLibraries(apieeCore());
    }

    private static File[] apieeCore() {
        return Maven.resolver()
                .loadPomFromFile("pom.xml")
                .resolve("com.github.phillip-kruger:apiee-core")
                .withTransitivity()
                .asFile();
    }

    @Test
    public void getGreeterReturnsCorrectMessage() {
        String message = ClientBuilder.newClient()
                .target(studentsResource + "/greeter")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);

        assertEquals("Goedemorgen in Utrecht.", message);
    }

    @Test
    public void getSpecialReturnsSpecialStudent() {
        String message = ClientBuilder.newClient()
                .target(studentsResource + "/special")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);

        assertThat(message, containsString("Ferry"));
        assertThat(message, containsString("Special"));
    }

    @Test
    public void getDateReturnsCorrectMessage() {
        String message = ClientBuilder.newClient()
                .target(studentsResource + "/date")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);

        assertThat(message, containsString("the time is"));
    }

    @Test(expected = Exception.class)
    public void getPlainReturnsError() {
        ClientBuilder.newClient()
                .target(studentsResource + "/plain")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
    }

    @Test
    public void getStudentReturnsStudentUsingSubresource() {
        String message = ClientBuilder.newClient()
                .target(studentsResource + "/1")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);

        assertThat(message, containsString("Student(firstname=MyId=1, lastname=Subresource, yearOfBirth=2000)"));
    }

    @Test
    public void getXmlReturnsStudentContainerXml() {
        String message = ClientBuilder.newClient()
                .target(studentsResource + "/xml")
                .request(MediaType.APPLICATION_XML)
                .get(String.class);

        assertThat(message, containsString("<?xml version="));
        assertThat(message, containsString("<studentContainer>"));
    }

    @Test
    public void getJsonReturnsStudentContainerJson() {
        String message = ClientBuilder.newClient()
                .target(studentsResource + "/json")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);

        assertThat(message, is("{\"students\":[{\"firstname\":\"Wim\",\"lastname\":\"Janssen\",\"yearOfBirth\":1982},{\"firstname\":\"Ann\",\"lastname\":\"Smit\",\"yearOfBirth\":1981},{\"firstname\":\"Chloe\",\"lastname\":\"Pieters\",\"yearOfBirth\":1988},{\"firstname\":\"Peter\",\"lastname\":\"Klaassen\",\"yearOfBirth\":1978}]}"));
    }

}
