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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DMITRY
 */
@Entity
@Table(name = "mkb10_classes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mkb10Classes.findAll", query = "SELECT m FROM Mkb10Classes m")
    , @NamedQuery(name = "Mkb10Classes.findByMkbClassId", query = "SELECT m FROM Mkb10Classes m WHERE m.mkbClassId = :mkbClassId")
    , @NamedQuery(name = "Mkb10Classes.findByMkbClassCode", query = "SELECT m FROM Mkb10Classes m WHERE m.mkbClassCode = :mkbClassCode")
    , @NamedQuery(name = "Mkb10Classes.findByMkbClassParentCode", query = "SELECT m FROM Mkb10Classes m WHERE m.mkbClassParentCode = :mkbClassParentCode")
    , @NamedQuery(name = "Mkb10Classes.findByMkbClassName", query = "SELECT m FROM Mkb10Classes m WHERE m.mkbClassName = :mkbClassName")
    , @NamedQuery(name = "Mkb10Classes.findByMkbClassHazChild", query = "SELECT m FROM Mkb10Classes m WHERE m.mkbClassHazChild = :mkbClassHazChild")
    , @NamedQuery(name = "Mkb10Classes.findByMkbClassMin", query = "SELECT m FROM Mkb10Classes m WHERE m.mkbClassMin = :mkbClassMin")
    , @NamedQuery(name = "Mkb10Classes.findByMkbClassMax", query = "SELECT m FROM Mkb10Classes m WHERE m.mkbClassMax = :mkbClassMax")})
public class Mkb10Classes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "\"MKB_CLASS_ID\"")
    private String mkbClassId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "\"MKB_CLASS_CODE\"")
    private int mkbClassCode;
    @Column(name = "\"MKB_CLASS_PARENT_CODE\"")
    private Integer mkbClassParentCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "\"MKB_CLASS_NAME\"")
    private String mkbClassName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "\"MKB_CLASS_HAZ_CHILD\"")
    private int mkbClassHazChild;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "\"MKB_CLASS_MIN\"")
    private String mkbClassMin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "\"MKB_CLASS_MAX\"")
    private String mkbClassMax;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mkbClassId")
    private Collection<Mkb10> mkb10Collection;

    public Mkb10Classes() {
    }

    public Mkb10Classes(String mkbClassId) {
        this.mkbClassId = mkbClassId;
    }

    public Mkb10Classes(String mkbClassId, int mkbClassCode, String mkbClassName, int mkbClassHazChild, String mkbClassMin, String mkbClassMax) {
        this.mkbClassId = mkbClassId;
        this.mkbClassCode = mkbClassCode;
        this.mkbClassName = mkbClassName;
        this.mkbClassHazChild = mkbClassHazChild;
        this.mkbClassMin = mkbClassMin;
        this.mkbClassMax = mkbClassMax;
    }

    public String getMkbClassId() {
        return mkbClassId;
    }

    public void setMkbClassId(String mkbClassId) {
        this.mkbClassId = mkbClassId;
    }

    public int getMkbClassCode() {
        return mkbClassCode;
    }

    public void setMkbClassCode(int mkbClassCode) {
        this.mkbClassCode = mkbClassCode;
    }

    public Integer getMkbClassParentCode() {
        return mkbClassParentCode;
    }

    public void setMkbClassParentCode(Integer mkbClassParentCode) {
        this.mkbClassParentCode = mkbClassParentCode;
    }

    public String getMkbClassName() {
        return mkbClassName;
    }

    public void setMkbClassName(String mkbClassName) {
        this.mkbClassName = mkbClassName;
    }

    public int getMkbClassHazChild() {
        return mkbClassHazChild;
    }

    public void setMkbClassHazChild(int mkbClassHazChild) {
        this.mkbClassHazChild = mkbClassHazChild;
    }

    public String getMkbClassMin() {
        return mkbClassMin;
    }

    public void setMkbClassMin(String mkbClassMin) {
        this.mkbClassMin = mkbClassMin;
    }

    public String getMkbClassMax() {
        return mkbClassMax;
    }

    public void setMkbClassMax(String mkbClassMax) {
        this.mkbClassMax = mkbClassMax;
    }

    @XmlTransient
    public Collection<Mkb10> getMkb10Collection() {
        return mkb10Collection;
    }

    public void setMkb10Collection(Collection<Mkb10> mkb10Collection) {
        this.mkb10Collection = mkb10Collection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mkbClassId != null ? mkbClassId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mkb10Classes)) {
            return false;
        }
        Mkb10Classes other = (Mkb10Classes) object;
        if ((this.mkbClassId == null && other.mkbClassId != null) || (this.mkbClassId != null && !this.mkbClassId.equals(other.mkbClassId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getMkbClassName();
    }
    
}
