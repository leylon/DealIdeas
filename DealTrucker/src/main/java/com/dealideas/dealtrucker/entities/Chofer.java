/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dealideas.dealtrucker.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jonathan Muñoz
 */
@Entity
@Table(name = "chofer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chofer.findAll", query = "SELECT c FROM Chofer c"), 
    @NamedQuery(name = "Chofer.findByUsername", query = "SELECT c FROM Chofer c WHERE c.username = :username"), 
    @NamedQuery(name = "Chofer.findByNrolicencia", query = "SELECT c FROM Chofer c WHERE c.nrolicencia = :nrolicencia")
})
public class Chofer implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nrolicencia")
    private String nrolicencia;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chofer")
    private Collection<Servicio> servicios;
    
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;

    public Chofer() {
    }

    public Chofer(String username) {
        this.username = username;
    }

    public Chofer(String username, String nrolicencia) {
        this.username = username;
        this.nrolicencia = nrolicencia;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNrolicencia() {
        return nrolicencia;
    }

    public void setNrolicencia(String nrolicencia) {
        this.nrolicencia = nrolicencia;
    }

    @XmlTransient
    public Collection<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(Collection<Servicio> servicios) {
        this.servicios = servicios;
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
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chofer)) {
            return false;
        }
        Chofer other = (Chofer) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dealideas.dealtrucker.entities.Chofer[ username=" + username + " ]";
    }
    
}
