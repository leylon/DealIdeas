/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dealideas.dealtrucker.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jonathan Muñoz
 */
@Entity
@Table(name = "servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicio.findAll", query = "SELECT s FROM Servicio s"), 
    @NamedQuery(name = "Servicio.findByIdServicio", query = "SELECT s FROM Servicio s WHERE s.idServicio = :idServicio"), 
    @NamedQuery(name = "Servicio.findByDireccionDestino", query = "SELECT s FROM Servicio s WHERE s.direccionDestino = :direccionDestino"), 
    @NamedQuery(name = "Servicio.findByFechaInicio", query = "SELECT s FROM Servicio s WHERE s.fechaInicio = :fechaInicio"), 
    @NamedQuery(name = "Servicio.findByFechaCita", query = "SELECT s FROM Servicio s WHERE s.fechaCita = :fechaCita"), 
    @NamedQuery(name = "Servicio.findByNroContenedor", query = "SELECT s FROM Servicio s WHERE s.nroContenedor = :nroContenedor")
})
public class Servicio implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idservicio")
    private Long idServicio;
    
    @Size(max = 255)
    @Column(name = "direccion_destino")
    private String direccionDestino;
    
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    
    @Column(name = "fecha_cita")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCita;
    
    @Size(max = 45)
    @Column(name = "nro_contenedor")
    private String nroContenedor;
    
    @JoinColumn(name = "placa_camion", referencedColumnName = "placa")
    @ManyToOne(optional = false)
    private Camion camion;
    
    @JoinColumn(name = "placa_tracto", referencedColumnName = "placa")
    @ManyToOne(optional = false)
    private Camion tracto;
    
    @JoinColumn(name = "id_chofer", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private Chofer chofer;
    
    @JoinColumn(name = "idestado", referencedColumnName = "idestado")
    @ManyToOne(optional = false)
    private EstadoServicio estado;
    
    @JoinColumn(name = "idtipo", referencedColumnName = "idtipo")
    @ManyToOne(optional = false)
    private TipoServicio tipo;
    
    @JoinColumn(name = "ubigeo_destino", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Ubigeo destino;
    
    @JoinColumn(name = "ubigeo_origen", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Ubigeo origen;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicio")
    private Collection<Monitoreo> monitoreos;

    public Servicio() {
    }

    public Servicio(Long idservicio) {
        this.idServicio = idservicio;
    }

    public Long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getNroContenedor() {
        return nroContenedor;
    }

    public void setNroContenedor(String nroContenedor) {
        this.nroContenedor = nroContenedor;
    }

    public Camion getCamion() {
        return camion;
    }

    public void setCamion(Camion camion) {
        this.camion = camion;
    }

    public Camion getTracto() {
        return tracto;
    }

    public void setTracto(Camion tracto) {
        this.tracto = tracto;
    }

    public Chofer getChofer() {
        return chofer;
    }

    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }

    public EstadoServicio getEstado() {
        return estado;
    }

    public void setEstado(EstadoServicio estado) {
        this.estado = estado;
    }

    public TipoServicio getTipo() {
        return tipo;
    }

    public void setTipo(TipoServicio tipo) {
        this.tipo = tipo;
    }

    public Ubigeo getDestino() {
        return destino;
    }

    public void setDestino(Ubigeo destino) {
        this.destino = destino;
    }

    public Ubigeo getOrigen() {
        return origen;
    }

    public void setOrigen(Ubigeo origen) {
        this.origen = origen;
    }

    @XmlTransient
    public Collection<Monitoreo> getMonitoreos() {
        return monitoreos;
    }

    public void setMonitoreos(Collection<Monitoreo> monitoreos) {
        this.monitoreos = monitoreos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicio != null ? idServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicio)) {
            return false;
        }
        Servicio other = (Servicio) object;
        if ((this.idServicio == null && other.idServicio != null) || (this.idServicio != null && !this.idServicio.equals(other.idServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dealideas.dealtrucker.entities.Servicio[ idservicio=" + idServicio + " ]";
    }
    
}
