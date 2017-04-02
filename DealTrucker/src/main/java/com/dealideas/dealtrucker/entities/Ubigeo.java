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
@Table(name = "ubigeo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ubigeo.findAll", query = "SELECT u FROM Ubigeo u"), 
    @NamedQuery(name = "Ubigeo.findByCodigo", query = "SELECT u FROM Ubigeo u WHERE u.codigo = :codigo"), 
    @NamedQuery(name = "Ubigeo.findByDescripcion", query = "SELECT u FROM Ubigeo u WHERE u.descripcion = :descripcion"),
    @NamedQuery(name = "Ubigeo.findByProvincia", query = "SELECT u FROM Ubigeo u WHERE u.provincia.codigo = :codProvincia")
})
public class Ubigeo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "codigo")
    private String codigo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destino")
    private Collection<Servicio> serviciosDestino;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "origen")
    private Collection<Servicio> serviciosOrigen;
    
    @JoinColumn(name = "cod_provincia", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Provincia provincia;

    public Ubigeo() {
    }

    public Ubigeo(String codigo) {
        this.codigo = codigo;
    }

    public Ubigeo(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Servicio> getServiciosDestino() {
        return serviciosDestino;
    }

    public void setServiciosDestino(Collection<Servicio> serviciosDestino) {
        this.serviciosDestino = serviciosDestino;
    }

    @XmlTransient
    public Collection<Servicio> getServiciosOrigen() {
        return serviciosOrigen;
    }

    public void setServiciosOrigen(Collection<Servicio> serviciosOrigen) {
        this.serviciosOrigen = serviciosOrigen;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubigeo)) {
            return false;
        }
        Ubigeo other = (Ubigeo) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dealideas.dealtrucker.entities.Ubigeo[ codigo=" + codigo + " ]";
    }
    
}
