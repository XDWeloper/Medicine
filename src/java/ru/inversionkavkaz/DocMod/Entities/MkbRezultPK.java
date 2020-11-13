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
import javax.validation.constraints.Size;

/**
 *
 * @author DMITRY
 */
@Embeddable
public class MkbRezultPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "rez_id")
    private int rezId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "mkb_id")
    private String mkbId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "type")
    private String type;

    public MkbRezultPK() {
    }

    public MkbRezultPK(int rezId, String mkbId, String type) {
        this.rezId = rezId;
        this.mkbId = mkbId;
        this.type = type;
    }

    public int getRezId() {
        return rezId;
    }

    public void setRezId(int rezId) {
        this.rezId = rezId;
    }

    public String getMkbId() {
        return mkbId;
    }

    public void setMkbId(String mkbId) {
        this.mkbId = mkbId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) rezId;
        hash += (mkbId != null ? mkbId.hashCode() : 0);
        hash += (type != null ? type.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MkbRezultPK)) {
            return false;
        }
        MkbRezultPK other = (MkbRezultPK) object;
        if (this.rezId != other.rezId) {
            return false;
        }
        if ((this.mkbId == null && other.mkbId != null) || (this.mkbId != null && !this.mkbId.equals(other.mkbId))) {
            return false;
        }
        if ((this.type == null && other.type != null) || (this.type != null && !this.type.equals(other.type))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.inversionkavkaz.DocMod.Entities.MkbRezultPK[ rezId=" + rezId + ", mkbId=" + mkbId + ", type=" + type + " ]";
    }
    
}
