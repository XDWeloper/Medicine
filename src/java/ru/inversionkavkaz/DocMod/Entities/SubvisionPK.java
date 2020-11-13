/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.inversionkavkaz.DocMod.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author DMITRY
 */
@Embeddable
public class SubvisionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "sub_id")
    private int subId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cus_id")
    private int cusId;

    public SubvisionPK() {
    }

    public SubvisionPK(int subId, int cusId) {
        this.subId = subId;
        this.cusId = cusId;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) subId;
        hash += (int) cusId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubvisionPK)) {
            return false;
        }
        SubvisionPK other = (SubvisionPK) object;
        if (this.subId != other.subId) {
            return false;
        }
        if (this.cusId != other.cusId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.inversionkavkaz.DocMod.Entities.SubvisionPK[ subId=" + subId + ", cusId=" + cusId + " ]";
    }
    
}
