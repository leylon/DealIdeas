/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dealideas.dealtrucker.services;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import com.dealideas.dealtrucker.entities.Persona;
import com.dealideas.dealtrucker.util.PasswordStorage;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@Path("persona")
public class PersonaFacadeREST extends AbstractFacade<Persona> {
    
    private static final Logger LOGGER = Logger.getLogger(PersonaFacadeREST.class.getName());
    
    private static final String MSG_ERR = "Ha ocurrido un error al intentar validar la contraseña especificada";

    @PersistenceContext(unitName = "DealPU")
    private EntityManager em;

    public PersonaFacadeREST() {
        super(Persona.class);
    }

    @POST
    @Override
    @Consumes({APPLICATION_JSON})
    public void create(Persona entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Persona entity) {
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
    public Persona find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({APPLICATION_JSON})
    public List<Persona> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({APPLICATION_JSON})
    public List<Persona> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    /**
     * Autentica el nombre de usuario y contraseña especificados. Los parámetros
     * requeridos son los siguientes, en formato JSON:
     * 
     * - <code>username</code>: Nombre del usuario
     * - <code>password</code>: Contraseña del usuario
     * 
     * La respuesta contiene la siguiente información, también en formato JSON:
     * 
     * - <code>estado</code>: Puede ser success, warning o error
     * - <code>mensaje</code>: Mensaje que se mostrará al usuario
     * 
     * @param parametros Una cadena de texto que contiene los parámetros en formato JSON.
     * @return Una cadena de texto que contiene la respuesta en formato JSON.
     */
    @POST
    @Path("autenticar")
    @Consumes({APPLICATION_JSON})
    @Produces({APPLICATION_JSON})
    public Map autenticar(String parametros) {
        LOGGER.log(Level.INFO, "Autenticando usuario...");
        LOGGER.log(Level.INFO, "Parametros: {0}", parametros);
        
        Properties properties = new Gson().fromJson(parametros, Properties.class);
        String password = properties.getProperty("password");
        
        Map<String, String> rpta = new HashMap<String, String>();
        Persona persona = find(properties.getProperty("username"));
        
        if (persona == null) {
            LOGGER.log(Level.WARNING, "El nombre de usuario especificado no existe.");
            rpta.put("estado", "warning");
            rpta.put("mensaje", "El nombre de usuario especificado no existe.");
            return rpta;
        } else
            LOGGER.log(Level.INFO, "Persona: {0}", persona);
        
        try {
            if (PasswordStorage.verifyPassword(password, persona.getPassword())) {
                LOGGER.log(Level.INFO, "Se ha conseguido autenticar al usuario de manera satisfactoria.");
                rpta.put("estado", "success");
                rpta.put("mensaje", "Se ha conseguido autenticar al usuario de manera satisfactoria.");
            } else {
                LOGGER.log(Level.WARNING, "La contraseña especificada no coincide con la del usuario.");
                rpta.put("estado", "warning");
                rpta.put("mensaje", "La contraseña especificada no coincide con la del usuario.");
            }
        } catch (PasswordStorage.CannotPerformOperationException ex) {
            LOGGER.log(Level.SEVERE, MSG_ERR, ex);
            rpta.put("estado", "error");
            rpta.put("mensaje", MSG_ERR + ": " + ex.getMessage());
        } catch (PasswordStorage.InvalidHashException ex) {
            LOGGER.log(Level.SEVERE, MSG_ERR, ex);
            rpta.put("estado", "error");
            rpta.put("mensaje", MSG_ERR + ": " + ex.getMessage());
        }
        
        return rpta;
    }
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
