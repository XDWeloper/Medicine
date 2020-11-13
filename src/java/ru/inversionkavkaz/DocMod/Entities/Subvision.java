/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.inversionkavkaz.DocMod.Entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DMITRY
 */
@Entity
@Table(name = "subvision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subvision.findAll", query = "SELECT s FROM Subvision s")
    , @NamedQuery(name = "Subvision.findBySubId", query = "SELECT s FROM Subvision s WHERE s.subvisionPK.subId = :subId")
    , @NamedQuery(name = "Subvision.findBySubName", query = "SELECT s FROM Subvision s WHERE s.subName = :subName")
    , @NamedQuery(name = "Subvision.findByCusId", query = "SELECT s FROM Subvision s WHERE s.subvisionPK.cusId = :cusId")})
public class Subvision implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SubvisionPK subvisionPK;
    @Size(max = 200)
    @Column(name = "sub_name")
    private String subName;

    public Subvision() {
    }

    public Subvision(SubvisionPK subvisionPK) {
        this.subvisionPK = subvisionPK;
    }

    public Subvision(int subId, int cusId) {
        this.subvisionPK = new SubvisionPK(subId, cusId);
    }

    public SubvisionPK getSubvisionPK() {
        return subvisionPK;
    }

    public void setSubvisionPK(SubvisionPK subvisionPK) {
        this.subvisionPK = subvisionPK;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subvisionPK != null ? subvisionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subvision)) {
            return false;
        }
        Subvision other = (Subvision) object;
        if ((this.subvisionPK == null && other.subvisionPK != null) || (this.subvisionPK != null && !this.subvisionPK.equals(other.subvisionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.inversionkavkaz.DocMod.Entities.Subvision[ subvisionPK=" + subvisionPK + " ]";
    }
    
}
