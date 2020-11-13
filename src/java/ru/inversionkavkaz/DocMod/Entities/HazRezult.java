/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.inversionkavkaz.DocMod.Entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DMITRY
 */
@Entity
@Table(name = "haz_rezult")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HazRezult.findAll", query = "SELECT h FROM HazRezult h")
    , @NamedQuery(name = "HazRezult.findByRezId", query = "SELECT h FROM HazRezult h WHERE h.hazRezultPK.rezId = :rezId")
    , @NamedQuery(name = "HazRezult.findByHazId", query = "SELECT h FROM HazRezult h WHERE h.hazRezultPK.hazId = :hazId")})
public class HazRezult implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HazRezultPK hazRezultPK;

    public HazRezult() {
    }

    public HazRezult(HazRezultPK hazRezultPK) {
        this.hazRezultPK = hazRezultPK;
    }

    public HazRezult(int rezId, int hazId) {
        this.hazRezultPK = new HazRezultPK(rezId, hazId);
    }

    public HazRezultPK getHazRezultPK() {
        return hazRezultPK;
    }

    public void setHazRezultPK(HazRezultPK hazRezultPK) {
        this.hazRezultPK = hazRezultPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hazRezultPK != null ? hazRezultPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HazRezult)) {
            return false;
        }
        HazRezult other = (HazRezult) object;
        if ((this.hazRezultPK == null && other.hazRezultPK != null) || (this.hazRezultPK != null && !this.hazRezultPK.equals(other.hazRezultPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.inversionkavkaz.DocMod.Entities.HazRezult[ hazRezultPK=" + hazRezultPK + " ]";
    }
    
}
