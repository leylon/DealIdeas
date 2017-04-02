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
@Table(name = "camion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Camion.findAll", query = "SELECT c FROM Camion c"), 
    @NamedQuery(name = "Camion.findByPlaca", query = "SELECT c FROM Camion c WHERE c.placa = :placa"), 
    @NamedQuery(name = "Camion.findByDescripcion", query = "SELECT c FROM Camion c WHERE c.descripcion = :descripcion")
})
public class Camion implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "placa")
    private String placa;
    
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    
    @JoinColumn(name = "ruc_empresa", referencedColumnName = "ruc")
    @ManyToOne(optional = false)
    private Empresa empresa;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "camion")
    private Collection<Servicio> serviciosCamion;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tracto")
    private Collection<Servicio> serviciosTracto;

    public Camion() {
    }

    public Camion(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @XmlTransient
    public Collection<Servicio> getServiciosCamion() {
        return serviciosCamion;
    }

    public void setServiciosCamion(Collection<Servicio> serviciosCamion) {
        this.serviciosCamion = serviciosCamion;
    }

    @XmlTransient
    public Collection<Servicio> getServiciosTracto() {
        return serviciosTracto;
    }

    public void setServiciosTracto(Collection<Servicio> serviciosTracto) {
        this.serviciosTracto = serviciosTracto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placa != null ? placa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Camion)) {
            return false;
        }
        Camion other = (Camion) object;
        if ((this.placa == null && other.placa != null) || (this.placa != null && !this.placa.equals(other.placa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dealideas.dealtrucker.entities.Camion[ placa=" + placa + " ]";
    }
    
}
