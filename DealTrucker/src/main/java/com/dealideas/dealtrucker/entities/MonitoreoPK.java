/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dealideas.dealtrucker.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jonathan Muñoz
 */
@Embeddable
public class MonitoreoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idservicio")
    private long idServicio;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "item")
    private int item;

    public MonitoreoPK() {
    }

    public MonitoreoPK(long idservicio, int item) {
        this.idServicio = idservicio;
        this.item = item;
    }

    public long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(long idServicio) {
        this.idServicio = idServicio;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idServicio;
        hash += (int) item;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MonitoreoPK)) {
            return false;
        }
        MonitoreoPK other = (MonitoreoPK) object;
        if (this.idServicio != other.idServicio) {
            return false;
        }
        if (this.item != other.item) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dealideas.dealtrucker.entities.MonitoreoPK[ idservicio=" + idServicio + ", item=" + item + " ]";
    }
    
}
