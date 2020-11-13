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
public class PersonHazardPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idperson")
    private long idperson;
    @Basic(optional = false)
    @NotNull
    @Column(name = "haz_id")
    private int hazId;

    public PersonHazardPK() {
    }

    public PersonHazardPK(long idperson, int hazId) {
        this.idperson = idperson;
        this.hazId = hazId;
    }

    public long getIdperson() {
        return idperson;
    }

    public void setIdperson(long idperson) {
        this.idperson = idperson;
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
        hash += (int) idperson;
        hash += (int) hazId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonHazardPK)) {
            return false;
        }
        PersonHazardPK other = (PersonHazardPK) object;
        if (this.idperson != other.idperson) {
            return false;
        }
        if (this.hazId != other.hazId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.inversionkavkaz.DocMod.Entities.PersonHazardPK[ idperson=" + idperson + ", hazId=" + hazId + " ]";
    }
    
}
