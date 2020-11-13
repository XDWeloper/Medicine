/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.inversionkavkaz.DocMod.Entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DMITRY
 */
@Entity
@Table(name = "allergy_person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AllergyPerson.findAll", query = "SELECT a FROM AllergyPerson a")
    , @NamedQuery(name = "AllergyPerson.findByIdperson", query = "SELECT a FROM AllergyPerson a WHERE a.allergyPersonPK.idperson = :idperson")
    , @NamedQuery(name = "AllergyPerson.findByAllergyReaction", query = "SELECT a FROM AllergyPerson a WHERE a.allergyPersonPK.allergyReaction = :allergyReaction")})
public class AllergyPerson implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AllergyPersonPK allergyPersonPK;
    @JoinColumn(name = "idperson", referencedColumnName = "idperson", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persons persons;

    public AllergyPerson() {
    }

    public AllergyPerson(AllergyPersonPK allergyPersonPK) {
        this.allergyPersonPK = allergyPersonPK;
    }

    public AllergyPerson(BigInteger idperson, String allergyReaction) {
        this.allergyPersonPK = new AllergyPersonPK(idperson, allergyReaction);
    }

    public AllergyPersonPK getAllergyPersonPK() {
        return allergyPersonPK;
    }

    public void setAllergyPersonPK(AllergyPersonPK allergyPersonPK) {
        this.allergyPersonPK = allergyPersonPK;
    }

    public Persons getPersons() {
        return persons;
    }

    public void setPersons(Persons persons) {
        this.persons = persons;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (allergyPersonPK != null ? allergyPersonPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AllergyPerson)) {
            return false;
        }
        AllergyPerson other = (AllergyPerson) object;
        if ((this.allergyPersonPK == null && other.allergyPersonPK != null) || (this.allergyPersonPK != null && !this.allergyPersonPK.equals(other.allergyPersonPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.inversionkavkaz.DocMod.Entities.AllergyPerson[ allergyPersonPK=" + allergyPersonPK + " ]";
    }
    
}
