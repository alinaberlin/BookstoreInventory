package com.github.alina;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args)  {
        //implement logic for server
        System.out.println("Hello world!");
        String BASE_URI = "http://localhost:8080/";
        ResourceConfig resourceConfig = new ResourceConfig(BookResource.class);
        GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), resourceConfig);
        //add connection for server

    }

}