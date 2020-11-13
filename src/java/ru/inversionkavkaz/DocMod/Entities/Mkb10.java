/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.inversionkavkaz.DocMod.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DMITRY
 */
@Entity
@Table(name = "mkb10")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mkb10.findAll", query = "SELECT m FROM Mkb10 m")
    , @NamedQuery(name = "Mkb10.findByMkbId", query = "SELECT m FROM Mkb10 m WHERE m.mkbId = :mkbId")
    , @NamedQuery(name = "Mkb10.findByMkbName", query = "SELECT m FROM Mkb10 m WHERE m.mkbName = :mkbName")})
public class Mkb10 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "\"MKB_ID\"")
    private String mkbId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "\"MKB_NAME\"")
    private String mkbName;
    @JoinColumn(name = "\"MKB_CLASS_ID\"", referencedColumnName = "\"MKB_CLASS_ID\"")
    @ManyToOne(optional = false)
    private Mkb10Classes mkbClassId;

    public Mkb10() {
    }

    public Mkb10(String mkbId) {
        this.mkbId = mkbId;
    }

    public Mkb10(String mkbId, String mkbName) {
        this.mkbId = mkbId;
        this.mkbName = mkbName;
    }

    public String getMkbId() {
        return mkbId;
    }

    public void setMkbId(String mkbId) {
        this.mkbId = mkbId;
    }

    public String getMkbName() {
        return mkbName;
    }

    public void setMkbName(String mkbName) {
        this.mkbName = mkbName;
    }

    public Mkb10Classes getMkbClassId() {
        return mkbClassId;
    }

    public void setMkbClassId(Mkb10Classes mkbClassId) {
        this.mkbClassId = mkbClassId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mkbId != null ? mkbId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mkb10)) {
            return false;
        }
        Mkb10 other = (Mkb10) object;
        if ((this.mkbId == null && other.mkbId != null) || (this.mkbId != null && !this.mkbId.equals(other.mkbId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.inversionkavkaz.DocMod.Entities.Mkb10[ mkbId=" + mkbId + " ]";
    }
    
}
