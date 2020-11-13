/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.inversionkavkaz.DocMod.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DMITRY
 */
@Entity
@Table(name = "person_hazard")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonHazard.findAll", query = "SELECT p FROM PersonHazard p")
    , @NamedQuery(name = "PersonHazard.findByIdperson", query = "SELECT p FROM PersonHazard p WHERE p.personHazardPK.idperson = :idperson")
    , @NamedQuery(name = "PersonHazard.findByHazId", query = "SELECT p FROM PersonHazard p WHERE p.personHazardPK.hazId = :hazId")
    , @NamedQuery(name = "PersonHazard.findByData", query = "SELECT p FROM PersonHazard p WHERE p.data = :data")})
public class PersonHazard implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonHazardPK personHazardPK;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @JoinColumn(name = "idperson", referencedColumnName = "idperson", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persons persons;

    public PersonHazard() {
    }

    public PersonHazard(PersonHazardPK personHazardPK) {
        this.personHazardPK = personHazardPK;
    }

    public PersonHazard(long idperson, int hazId) {
        this.personHazardPK = new PersonHazardPK(idperson, hazId);
    }

    public PersonHazardPK getPersonHazardPK() {
        return personHazardPK;
    }

    public void setPersonHazardPK(PersonHazardPK personHazardPK) {
        this.personHazardPK = personHazardPK;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
        hash += (personHazardPK != null ? personHazardPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonHazard)) {
            return false;
        }
        PersonHazard other = (PersonHazard) object;
        if ((this.personHazardPK == null && other.personHazardPK != null) || (this.personHazardPK != null && !this.personHazardPK.equals(other.personHazardPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.inversionkavkaz.DocMod.Entities.PersonHazard[ personHazardPK=" + personHazardPK + " ]";
    }
    
}
