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
@Table(name = "estado_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoServicio.findAll", query = "SELECT e FROM EstadoServicio e"), 
    @NamedQuery(name = "EstadoServicio.findByIdEstado", query = "SELECT e FROM EstadoServicio e WHERE e.idEstado = :idEstado"), 
    @NamedQuery(name = "EstadoServicio.findByNombre", query = "SELECT e FROM EstadoServicio e WHERE e.nombre = :nombre")
})
public class EstadoServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idestado")
    private Integer idEstado;
    
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estado")
    private Collection<Servicio> servicios;

    public EstadoServicio() {
    }

    public EstadoServicio(Integer idestado) {
        this.idEstado = idestado;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(Collection<Servicio> servicios) {
        this.servicios = servicios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoServicio)) {
            return false;
        }
        EstadoServicio other = (EstadoServicio) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dealideas.dealtrucker.entities.EstadoServicio[ idestado=" + idEstado + " ]";
    }
    
}
