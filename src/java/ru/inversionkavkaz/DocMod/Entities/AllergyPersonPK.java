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
public class AllergyPersonPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idperson")
    private BigInteger idperson;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "allergy_reaction")
    private String allergyReaction;

    public AllergyPersonPK() {
    }

    public AllergyPersonPK(BigInteger idperson, String allergyReaction) {
        this.idperson = idperson;
        this.allergyReaction = allergyReaction;
    }

    public BigInteger getIdperson() {
        return idperson;
    }

    public void setIdperson(BigInteger idperson) {
        this.idperson = idperson;
    }

    public String getAllergyReaction() {
        return allergyReaction;
    }

    public void setAllergyReaction(String allergyReaction) {
        this.allergyReaction = allergyReaction;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperson != null ? idperson.hashCode() : 0);
        hash += (allergyReaction != null ? allergyReaction.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AllergyPersonPK)) {
            return false;
        }
        AllergyPersonPK other = (AllergyPersonPK) object;
        if ((this.idperson == null && other.idperson != null) || (this.idperson != null && !this.idperson.equals(other.idperson))) {
            return false;
        }
        if ((this.allergyReaction == null && other.allergyReaction != null) || (this.allergyReaction != null && !this.allergyReaction.equals(other.allergyReaction))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.inversionkavkaz.DocMod.Entities.AllergyPersonPK[ idperson=" + idperson + ", allergyReaction=" + allergyReaction + " ]";
    }
    
}
