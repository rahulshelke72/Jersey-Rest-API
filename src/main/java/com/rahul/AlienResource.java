package com.rahul;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource
{

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Alien getALien()
    {
        System.out.println("getAlien called...");
        Alien a1 = new Alien();
        a1.setName("Rahul");
        a1.setPoints(60);
        return a1;
    }


}
