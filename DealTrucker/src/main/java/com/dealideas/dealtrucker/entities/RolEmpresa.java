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
@Table(name = "rol_empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolEmpresa.findAll", query = "SELECT r FROM RolEmpresa r"), 
    @NamedQuery(name = "RolEmpresa.findByIdrol", query = "SELECT r FROM RolEmpresa r WHERE r.idrol = :idrol"), 
    @NamedQuery(name = "RolEmpresa.findByNombre", query = "SELECT r FROM RolEmpresa r WHERE r.nombre = :nombre")
})
public class RolEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idrol")
    private Integer idrol;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol")
    private Collection<Empresa> empresas;

    public RolEmpresa() {
    }

    public RolEmpresa(Integer idrol) {
        this.idrol = idrol;
    }

    public RolEmpresa(Integer idrol, String nombre) {
        this.idrol = idrol;
        this.nombre = nombre;
    }

    public Integer getIdrol() {
        return idrol;
    }

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Collection<Empresa> empresas) {
        this.empresas = empresas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrol != null ? idrol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolEmpresa)) {
            return false;
        }
        RolEmpresa other = (RolEmpresa) object;
        if ((this.idrol == null && other.idrol != null) || (this.idrol != null && !this.idrol.equals(other.idrol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dealideas.dealtrucker.entities.RolEmpresa[ idrol=" + idrol + " ]";
    }
    
}
