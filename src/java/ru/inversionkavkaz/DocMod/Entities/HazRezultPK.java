/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.inversionkavkaz.DocMod.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author DMITRY
 */
@Embeddable
public class HazRezultPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "rez_id")
    private int rezId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "haz_id")
    private int hazId;

    public HazRezultPK() {
    }

    public HazRezultPK(int rezId, int hazId) {
        this.rezId = rezId;
        this.hazId = hazId;
    }

    public int getRezId() {
        return rezId;
    }

    public void setRezId(int rezId) {
        this.rezId = rezId;
    }

    public int getHazId() {
        return hazId;
    }

    public void setHazId(int hazId) {
        this.hazId = hazId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) rezId;
        hash += (int) hazId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HazRezultPK)) {
            return false;
        }
        HazRezultPK other = (HazRezultPK) object;
        if (this.rezId != other.rezId) {
            return false;
        }
        if (this.hazId != other.hazId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.inversionkavkaz.DocMod.Entities.HazRezultPK[ rezId=" + rezId + ", hazId=" + hazId + " ]";
    }
    
}
