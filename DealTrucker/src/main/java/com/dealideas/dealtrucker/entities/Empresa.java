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
import javax.persistence.ManyToOne;
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
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"), 
    @NamedQuery(name = "Empresa.findByRuc", query = "SELECT e FROM Empresa e WHERE e.ruc = :ruc"), 
    @NamedQuery(name = "Empresa.findByRazonSocial", query = "SELECT e FROM Empresa e WHERE e.razonSocial = :razonSocial")
})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "ruc")
    private String ruc;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "razonsocial")
    private String razonSocial;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    private Collection<Camion> camiones;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    private Collection<Persona> personas;
    
    @JoinColumn(name = "idrol", referencedColumnName = "idrol")
    @ManyToOne(optional = false)
    private RolEmpresa rol;

    public Empresa() {
    }

    public Empresa(String ruc) {
        this.ruc = ruc;
    }

    public Empresa(String ruc, String razonsocial) {
        this.ruc = ruc;
        this.razonSocial = razonsocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    @XmlTransient
    public Collection<Camion> getCamiones() {
        return camiones;
    }

    public void setCamiones(Collection<Camion> camiones) {
        this.camiones = camiones;
    }

    @XmlTransient
    public Collection<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(Collection<Persona> personas) {
        this.personas = personas;
    }

    public RolEmpresa getRol() {
        return rol;
    }

    public void setRol(RolEmpresa rol) {
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ruc != null ? ruc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.ruc == null && other.ruc != null) || (this.ruc != null && !this.ruc.equals(other.ruc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dealideas.dealtrucker.entities.Empresa[ ruc=" + ruc + " ]";
    }
    
}
