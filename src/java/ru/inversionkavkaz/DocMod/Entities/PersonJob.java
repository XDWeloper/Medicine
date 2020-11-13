/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.inversionkavkaz.DocMod.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "person_job")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonJob.findAll", query = "SELECT p FROM PersonJob p")
    , @NamedQuery(name = "PersonJob.findByIcusnum", query = "SELECT p FROM PersonJob p WHERE p.icusnum = :icusnum")
    , @NamedQuery(name = "PersonJob.findByStartDate", query = "SELECT p FROM PersonJob p WHERE p.startDate = :startDate")
    , @NamedQuery(name = "PersonJob.findByEndDate", query = "SELECT p FROM PersonJob p WHERE p.endDate = :endDate")
    , @NamedQuery(name = "PersonJob.findByProfId", query = "SELECT p FROM PersonJob p WHERE p.profId = :profId")
    , @NamedQuery(name = "PersonJob.findByHazJobId", query = "SELECT p FROM PersonJob p WHERE p.hazJobId = :hazJobId")
    , @NamedQuery(name = "PersonJob.findByHazId", query = "SELECT p FROM PersonJob p WHERE p.hazId = :hazId")
    , @NamedQuery(name = "PersonJob.findBySubvision", query = "SELECT p FROM PersonJob p WHERE p.subvision = :subvision")
    , @NamedQuery(name = "PersonJob.findById", query = "SELECT p FROM PersonJob p WHERE p.id = :id")})
public class PersonJob implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "icusnum")
    private Integer icusnum;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "prof_id")
    private Integer profId;
    @Column(name = "haz_job_id")
    private Integer hazJobId;
    @Column(name = "haz_id")
    private Integer hazId;
    @Column(name = "subvision")
    private Integer subvision;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "person_id", referencedColumnName = "idperson")
    @ManyToOne(optional = false)
    private Persons personId;

    public PersonJob() {
    }

    public PersonJob(Integer id) {
        this.id = id;
    }

    public Integer getIcusnum() {
        return icusnum;
    }

    public void setIcusnum(Integer icusnum) {
        this.icusnum = icusnum;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getProfId() {
        return profId;
    }

    public void setProfId(Integer profId) {
        this.profId = profId;
    }

    public Integer getHazJobId() {
        return hazJobId;
    }

    public void setHazJobId(Integer hazJobId) {
        this.hazJobId = hazJobId;
    }

    public Integer getHazId() {
        return hazId;
    }

    public void setHazId(Integer hazId) {
        this.hazId = hazId;
    }

    public Integer getSubvision() {
        return subvision;
    }

    public void setSubvision(Integer subvision) {
        this.subvision = subvision;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Persons getPersonId() {
        return personId;
    }

    public void setPersonId(Persons personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonJob)) {
            return false;
        }
        PersonJob other = (PersonJob) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.inversionkavkaz.DocMod.Entities.PersonJob[ id=" + id + " ]";
    }
    
}
