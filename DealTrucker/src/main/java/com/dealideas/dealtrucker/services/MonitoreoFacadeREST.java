/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dealideas.dealtrucker.services;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import com.dealideas.dealtrucker.entities.Monitoreo;
import com.dealideas.dealtrucker.entities.MonitoreoPK;
import com.dealideas.dealtrucker.entities.Persona;
import com.google.gson.Gson;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author Jonathan Muñoz
 */
@Stateless
@Path("monitoreo")
public class MonitoreoFacadeREST extends AbstractFacade<Monitoreo> {
    
    private static final Logger LOGGER = Logger.getLogger(MonitoreoFacadeREST.class.getName());

    @PersistenceContext(unitName = "DealPU")
    private EntityManager em;

    public MonitoreoFacadeREST() {
        super(Monitoreo.class);
    }

    @POST
    @Override
    @Consumes({APPLICATION_JSON})
    public void create(Monitoreo entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Monitoreo entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        MonitoreoPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({APPLICATION_JSON})
    public Monitoreo find(@PathParam("id") PathSegment id) {
        MonitoreoPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({APPLICATION_JSON})
    public List<Monitoreo> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({APPLICATION_JSON})
    public List<Monitoreo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
   
    @POST
    @Path("crear")
    @Consumes({APPLICATION_JSON})
    @Produces({APPLICATION_JSON})
    public Map crear(String parametros) {
        LOGGER.log(Level.INFO, "Registrando monitoreo...");
        LOGGER.log(Level.INFO, "Parametros: {0}", parametros);
        
        Map<String, String> map = new HashMap<String, String>();
        Properties properties = new Gson().fromJson(parametros, Properties.class);
        
        try {
            String idServicio = properties.getProperty("idServicio");
            
            if (idServicio == null)
                throw new IllegalArgumentException("No se ha especificado el id del servicio");
            else
                LOGGER.log(Level.INFO, "Id del servicio: {0}", idServicio);
            
            String usuario = properties.getProperty("usuario");
            
            if (usuario == null)
                throw new IllegalArgumentException("No se ha especificado el nombre del usuario");
            
            Persona persona = em.find(Persona.class, usuario);
            
            if (persona == null) 
                throw new IllegalArgumentException("El nombre de usuario especificado no existe");
            else
                LOGGER.log(Level.INFO, "Persona: {0}", persona);
            
            String latitud = properties.getProperty("latitud");
            
            if (latitud == null) 
                throw new IllegalArgumentException("No se ha especificado la latitud");
            else
                LOGGER.log(Level.INFO, "Latitud: {0}", latitud);
            
            String longitud = properties.getProperty("longitud");
            
            if (longitud == null) 
                throw new IllegalArgumentException("No se ha especificado la longitud");
            else
                LOGGER.log(Level.INFO, "Longitud: {0}", longitud);
            
            Monitoreo monitoreo = new Monitoreo(Long.parseLong(idServicio), 0);
            monitoreo.setPersona(persona);
            monitoreo.setLatitud(new BigDecimal(latitud));
            monitoreo.setLongitud(new BigDecimal(longitud));
            monitoreo.setPhonekey(properties.getProperty("key"));
            
            super.create(monitoreo);
            
            map.put("estado", "success");
            map.put("mensaje", "Se ha conseguido registrar el monitoreo de manera satisfactoria.");
        } catch (RuntimeException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
            map.put("estado", "warning");
            map.put("mensaje", e.getMessage());
        }
        
        return map;
    }

    @GET
    @Path("obtener")
    @Consumes({APPLICATION_JSON})
    @Produces({APPLICATION_JSON})
    public Monitoreo obtener(String parametros) {
        LOGGER.log(Level.INFO, "Obteniendo monitoreo...");
        LOGGER.log(Level.INFO, "Parametros: {0}", parametros);
        
        Properties properties = new Gson().fromJson(parametros, Properties.class);
        String idServicio = properties.getProperty("idServicio");
        String item = properties.getProperty("item");

        if (idServicio != null)
            LOGGER.log(Level.INFO, "Id de servicio: {0}", idServicio);
        else
            LOGGER.log(Level.WARNING, "No se ha especificado el id del servicio.");

        if (item != null) 
            LOGGER.log(Level.INFO, "Item: {0}", item);
        else
            LOGGER.log(Level.WARNING, "No se ha especificado el item del monitoreo.");
        
        MonitoreoPK key = new MonitoreoPK(Long.parseLong(idServicio), Integer.parseInt(item));
        Monitoreo monitoreo = super.find(key);
        
        if (monitoreo != null) 
            LOGGER.log(Level.INFO, "Monitoreo encontrado: {0}", monitoreo);
        else
            LOGGER.log(Level.WARNING, "No se ha conseguido encontrar el monitoreo buscado.");
        
        return monitoreo;
    }
    
    @GET
    @Path("obtenerxServicio")
    @Consumes({APPLICATION_JSON})
    @Produces({APPLICATION_JSON})
    public List<Monitoreo> obtenerxServicio(String parametros) {
        LOGGER.log(Level.INFO, "Obteniendo los monitoreos de un servicio...");
        LOGGER.log(Level.INFO, "Parametros: {0}", parametros);
        
        Properties properties = new Gson().fromJson(parametros, Properties.class);
        String idServicio = properties.getProperty("idServicio");

        if (idServicio != null)
            LOGGER.log(Level.INFO, "Id de servicio: {0}", idServicio);
        else
            LOGGER.log(Level.WARNING, "No se ha especificado el id del servicio.");

        Query query = em.createNamedQuery("Monitoreo.findByIdServicio");
        query.setParameter("idServicio", Long.parseLong(idServicio));
        
        List<Monitoreo> monitoreos = query.getResultList();
        LOGGER.log(Level.INFO, "Monitoreos encontrados: {0}", monitoreos.size());
        return monitoreos;
    }
    
    /**
     * pathSemgent represents a URI path segment and any associated matrix parameters.
     * URI path part is supposed to be in form of 'somePath;idservicio=idservicioValue;item=itemValue'.
     * Here 'somePath' is a result of getPath() method invocation and
     * it is ignored in the following code.
     * Matrix parameters are used as field names to build a primary key instance.
     */
    private MonitoreoPK getPrimaryKey(PathSegment pathSegment) {
        MonitoreoPK key = new MonitoreoPK();
        MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        List<String> idservicio = map.get("idservicio");
        
        if (idservicio != null && !idservicio.isEmpty()) {
            key.setIdServicio(new Long(idservicio.get(0)));
        }
        
        java.util.List<String> item = map.get("item");
        
        if (item != null && !item.isEmpty()) {
            key.setItem(new Integer(item.get(0)));
        }
        
        return key;
    }
    
}
