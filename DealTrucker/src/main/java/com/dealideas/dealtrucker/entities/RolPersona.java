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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "rol_persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolPersona.findAll", query = "SELECT r FROM RolPersona r"), 
    @NamedQuery(name = "RolPersona.findByIdRol", query = "SELECT r FROM RolPersona r WHERE r.idRol = :idRol"), 
    @NamedQuery(name = "RolPersona.findByNombre", query = "SELECT r FROM RolPersona r WHERE r.nombre = :nombre")
})
public class RolPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idrol")
    private Integer idRol;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol")
    private Collection<Persona> personas;

    public RolPersona() {
    }

    public RolPersona(Integer idrol) {
        this.idRol = idrol;
    }

    public RolPersona(Integer idrol, String nombre) {
        this.idRol = idrol;
        this.nombre = nombre;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(Collection<Persona> personas) {
        this.personas = personas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRol != null ? idRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolPersona)) {
            return false;
        }
        RolPersona other = (RolPersona) object;
        if ((this.idRol == null && other.idRol != null) || (this.idRol != null && !this.idRol.equals(other.idRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dealideas.dealtrucker.entities.RolPersona[ idrol=" + idRol + " ]";
    }
    
}
