/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.inversionkavkaz.DocMod.Entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DMITRY
 */
@Embeddable
public class PersonIllnessPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idperson")
    private BigInteger idperson;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "idmkb")
    private String idmkb;

    public PersonIllnessPK() {
    }

    public PersonIllnessPK(BigInteger idperson, String idmkb) {
        this.idperson = idperson;
        this.idmkb = idmkb;
    }

    public BigInteger getIdperson() {
        return idperson;
    }

    public void setIdperson(BigInteger idperson) {
        this.idperson = idperson;
    }

    public String getIdmkb() {
        return idmkb;
    }

    public void setIdmkb(String idmkb) {
        this.idmkb = idmkb;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperson != null ? idperson.hashCode() : 0);
        hash += (idmkb != null ? idmkb.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonIllnessPK)) {
            return false;
        }
        PersonIllnessPK other = (PersonIllnessPK) object;
        if ((this.idperson == null && other.idperson != null) || (this.idperson != null && !this.idperson.equals(other.idperson))) {
            return false;
        }
        if ((this.idmkb == null && other.idmkb != null) || (this.idmkb != null && !this.idmkb.equals(other.idmkb))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.inversionkavkaz.DocMod.Entities.PersonIllnessPK[ idperson=" + idperson + ", idmkb=" + idmkb + " ]";
    }
    
}
