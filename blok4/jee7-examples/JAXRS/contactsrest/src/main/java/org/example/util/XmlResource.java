package org.example.util;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_XML;

@Produces(APPLICATION_XML)
@Consumes(APPLICATION_XML)
public interface XmlResource {
}
