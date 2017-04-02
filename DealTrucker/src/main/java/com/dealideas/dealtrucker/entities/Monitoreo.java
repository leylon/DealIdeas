/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dealideas.dealtrucker.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonathan Muñoz
 */
@Entity
@Table(name = "monitoreo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Monitoreo.findAll", query = "SELECT m FROM Monitoreo m"),
    @NamedQuery(name = "Monitoreo.findByIdServicio", query = "SELECT m FROM Monitoreo m WHERE m.pk.idServicio = :idServicio"), 
    @NamedQuery(name = "Monitoreo.findByItem", query = "SELECT m FROM Monitoreo m WHERE m.pk.item = :item"), 
    @NamedQuery(name = "Monitoreo.findByFechaHora", query = "SELECT m FROM Monitoreo m WHERE m.fechaHora = :fechaHora"),
    @NamedQuery(name = "Monitoreo.findByLatitud", query = "SELECT m FROM Monitoreo m WHERE m.latitud = :latitud"), 
    @NamedQuery(name = "Monitoreo.findByLongitud", query = "SELECT m FROM Monitoreo m WHERE m.longitud = :longitud"),
    @NamedQuery(name = "Monitoreo.findByKey", query = "SELECT m FROM Monitoreo m WHERE m.phonekey = :phonekey")
})
public class Monitoreo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected MonitoreoPK pk;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechahora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitud")
    private BigDecimal latitud;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitud")
    private BigDecimal longitud;
    
    @Size(max = 256)
    @Column(name = "phonekey")
    private String phonekey;
    
    @JoinColumn(name = "idservicio", referencedColumnName = "idservicio", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Servicio servicio;
    
    @JoinColumn(name = "persona", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private Persona persona;

    public Monitoreo() {
    }

    /**
     * 
     * @param pk 
     */
    public Monitoreo(MonitoreoPK pk) {
        this.pk = pk;
    }

    public Monitoreo(MonitoreoPK pk, Date fechaHora, BigDecimal latitud, BigDecimal longitud, String phonekey) {
        this.pk = pk;
        this.fechaHora = fechaHora;
        this.latitud = latitud;
        this.longitud = longitud;
        this.phonekey = phonekey;
    }

    public Monitoreo(long idServicio, int item) {
        this.pk = new MonitoreoPK(idServicio, item);
        this.fechaHora = new Date();
    }

    public MonitoreoPK getPk() {
        return pk;
    }

    public void setPk(MonitoreoPK pk) {
        this.pk = pk;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public String getPhonekey() {
        return phonekey;
    }

    public void setPhonekey(String phonekey) {
        this.phonekey = phonekey;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pk != null ? pk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Monitoreo)) {
            return false;
        }
        Monitoreo other = (Monitoreo) object;
        if ((this.pk == null && other.pk != null) || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dealideas.dealtrucker.entities.Monitoreo[ monitoreoPK=" + pk + " ]";
    }
    
}
