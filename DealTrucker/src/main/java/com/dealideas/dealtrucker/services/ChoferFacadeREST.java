/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dealideas.dealtrucker.services;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import com.dealideas.dealtrucker.entities.Chofer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Jonathan Muñoz
 */
@Stateless
@Path("chofer")
public class ChoferFacadeREST extends AbstractFacade<Chofer> {

    @PersistenceContext(unitName = "DealPU")
    private EntityManager em;

    public ChoferFacadeREST() {
        super(Chofer.class);
    }

    @POST
    @Override
    @Consumes({APPLICATION_JSON})
    public void create(Chofer entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Chofer entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({APPLICATION_JSON})
    public Chofer find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({APPLICATION_JSON})
    public List<Chofer> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({APPLICATION_JSON})
    public List<Chofer> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
