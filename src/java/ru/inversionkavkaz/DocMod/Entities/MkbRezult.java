/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.inversionkavkaz.DocMod.Entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DMITRY
 */
@Entity
@Table(name = "mkb_rezult")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MkbRezult.findAll", query = "SELECT m FROM MkbRezult m")
    , @NamedQuery(name = "MkbRezult.findByRezId", query = "SELECT m FROM MkbRezult m WHERE m.mkbRezultPK.rezId = :rezId")
    , @NamedQuery(name = "MkbRezult.findByMkbId", query = "SELECT m FROM MkbRezult m WHERE m.mkbRezultPK.mkbId = :mkbId")
    , @NamedQuery(name = "MkbRezult.findByType", query = "SELECT m FROM MkbRezult m WHERE m.mkbRezultPK.type = :type")})
public class MkbRezult implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MkbRezultPK mkbRezultPK;

    public MkbRezult() {
    }

    public MkbRezult(MkbRezultPK mkbRezultPK) {
        this.mkbRezultPK = mkbRezultPK;
    }

    public MkbRezult(int rezId, String mkbId, String type) {
        this.mkbRezultPK = new MkbRezultPK(rezId, mkbId, type);
    }

    public MkbRezultPK getMkbRezultPK() {
        return mkbRezultPK;
    }

    public void setMkbRezultPK(MkbRezultPK mkbRezultPK) {
        this.mkbRezultPK = mkbRezultPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mkbRezultPK != null ? mkbRezultPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MkbRezult)) {
            return false;
        }
        MkbRezult other = (MkbRezult) object;
        if ((this.mkbRezultPK == null && other.mkbRezultPK != null) || (this.mkbRezultPK != null && !this.mkbRezultPK.equals(other.mkbRezultPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.inversionkavkaz.DocMod.Entities.MkbRezult[ mkbRezultPK=" + mkbRezultPK + " ]";
    }
    
}
