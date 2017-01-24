package org.swagger.test;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.swagger.test.filter.CORSFilter;
import org.swagger.test.rest.HelloWorldApplication;
import org.swagger.test.rest.HelloWorldEndpoint;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;
import org.wildfly.swarm.swagger.SwaggerArchive;

public class Main {

    public static void main(String[] args) throws Exception {
        Swarm swarm = new Swarm();

        JAXRSArchive archive = ShrinkWrap.create(JAXRSArchive.class);
        archive.addResource(HelloWorldApplication.class);
        archive.addResource(HelloWorldEndpoint.class);
        archive.addResource(CORSFilter.class);

        SwaggerArchive swaggerArchive = archive.as(SwaggerArchive.class);
        swaggerArchive.setContextRoot("/context");
        swaggerArchive.setPrettyPrint(true);

        swarm.start();
        swarm.deploy(archive);
    }
}
