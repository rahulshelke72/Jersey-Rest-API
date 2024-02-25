package com.rahul;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;



@Path("aliens")
public class AlienResource
{

    AlienRepository repo = new AlienRepository();
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Alien> getAliens()
    {
        System.out.println("getAlien called...");
        return repo.getAliens();
    }

    @GET
    @Path("alien/{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Alien getAlien(@PathParam("id") int id){
        return repo.getAlien(id);
    }


    @POST
    @Path("alien")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Alien createAlien(Alien a1){

        System.out.println(a1);
        repo.create(a1);
        return a1;
    }

    @PUT
    @Path("alien")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Alien updateAlien(Alien a1){

        System.out.println(a1);
        if(repo.getAlien(a1.getId()).getId() == 0){
            repo.create(a1);
        }else{
            repo.update(a1);
        }

        return a1;
    }

    @DELETE
    @Path("alien/{id}")
    public Alien deleteAlien(@PathParam("id") int id){
        Alien a = repo.getAlien(id);
        if(a.getId() != 0){
            repo.deleteAlien(id);
        }
       return a;
    }












}
