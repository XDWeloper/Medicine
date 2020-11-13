/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.inversionkavkaz.DocMod.Entities;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DMITRY
 */
@Entity
@Table(name = "person_illness")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonIllness.findAll", query = "SELECT p FROM PersonIllness p")
    , @NamedQuery(name = "PersonIllness.findByIdperson", query = "SELECT p FROM PersonIllness p WHERE p.personIllnessPK.idperson = :idperson")
    , @NamedQuery(name = "PersonIllness.findByIdmkb", query = "SELECT p FROM PersonIllness p WHERE p.personIllnessPK.idmkb = :idmkb")
    , @NamedQuery(name = "PersonIllness.findByLookStart", query = "SELECT p FROM PersonIllness p WHERE p.lookStart = :lookStart")
    , @NamedQuery(name = "PersonIllness.findByLookFinish", query = "SELECT p FROM PersonIllness p WHERE p.lookFinish = :lookFinish")
    , @NamedQuery(name = "PersonIllness.findByDoctor", query = "SELECT p FROM PersonIllness p WHERE p.doctor = :doctor")})
public class PersonIllness implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonIllnessPK personIllnessPK;
    @Column(name = "look_start")
    @Temporal(TemporalType.DATE)
    private Date lookStart;
    @Column(name = "look_finish")
    @Temporal(TemporalType.DATE)
    private Date lookFinish;
    @Size(max = 100)
    @Column(name = "doctor")
    private String doctor;
    @JoinColumn(name = "idperson", referencedColumnName = "idperson", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persons persons;

    public PersonIllness() {
    }

    public PersonIllness(PersonIllnessPK personIllnessPK) {
        this.personIllnessPK = personIllnessPK;
    }

    public PersonIllness(BigInteger idperson, String idmkb) {
        this.personIllnessPK = new PersonIllnessPK(idperson, idmkb);
    }

    public PersonIllnessPK getPersonIllnessPK() {
        return personIllnessPK;
    }

    public void setPersonIllnessPK(PersonIllnessPK personIllnessPK) {
        this.personIllnessPK = personIllnessPK;
    }

    public Date getLookStart() {
        return lookStart;
    }

    public void setLookStart(Date lookStart) {
        this.lookStart = lookStart;
    }

    public Date getLookFinish() {
        return lookFinish;
    }

    public void setLookFinish(Date lookFinish) {
        this.lookFinish = lookFinish;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
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
        hash += (personIllnessPK != null ? personIllnessPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonIllness)) {
            return false;
        }
        PersonIllness other = (PersonIllness) object;
        if ((this.personIllnessPK == null && other.personIllnessPK != null) || (this.personIllnessPK != null && !this.personIllnessPK.equals(other.personIllnessPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.inversionkavkaz.DocMod.Entities.PersonIllness[ personIllnessPK=" + personIllnessPK + " ]";
    }
    
}
