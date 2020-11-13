/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.inversionkavkaz.DocMod.Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DMITRY
 */
@Entity
@Table(name = "doctor_specialty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DoctorSpecialty.findAll", query = "SELECT d FROM DoctorSpecialty d")
    , @NamedQuery(name = "DoctorSpecialty.findByIdspec", query = "SELECT d FROM DoctorSpecialty d WHERE d.idspec = :idspec")
    , @NamedQuery(name = "DoctorSpecialty.findBySpecname", query = "SELECT d FROM DoctorSpecialty d WHERE d.specname = :specname")})
public class DoctorSpecialty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idspec")
    private Integer idspec;
    @Size(max = 500)
    @Column(name = "specname")
    private String specname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idspec")
    private Collection<DocSpec> docSpecCollection;

    public DoctorSpecialty() {
    }

    public DoctorSpecialty(Integer idspec) {
        this.idspec = idspec;
    }

    public Integer getIdspec() {
        return idspec;
    }

    public void setIdspec(Integer idspec) {
        this.idspec = idspec;
    }

    public String getSpecname() {
        return specname;
    }

    public void setSpecname(String specname) {
        this.specname = specname;
    }

    @XmlTransient
    public Collection<DocSpec> getDocSpecCollection() {
        return docSpecCollection;
    }

    public void setDocSpecCollection(Collection<DocSpec> docSpecCollection) {
        this.docSpecCollection = docSpecCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idspec != null ? idspec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DoctorSpecialty)) {
            return false;
        }
        DoctorSpecialty other = (DoctorSpecialty) object;
        if ((this.idspec == null && other.idspec != null) || (this.idspec != null && !this.idspec.equals(other.idspec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.inversionkavkaz.DocMod.Entities.DoctorSpecialty[ idspec=" + idspec + " ]";
    }
    
}
