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
@Table(name = "hazard")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hazard.findAll", query = "SELECT h FROM Hazard h")
    , @NamedQuery(name = "Hazard.findByHazId", query = "SELECT h FROM Hazard h WHERE h.hazId = :hazId")
    , @NamedQuery(name = "Hazard.findByHaztypeId", query = "SELECT h FROM Hazard h WHERE h.haztypeId = :haztypeId")
    , @NamedQuery(name = "Hazard.findByPeriodId", query = "SELECT h FROM Hazard h WHERE h.periodId = :periodId")
    , @NamedQuery(name = "Hazard.findByHazName", query = "SELECT h FROM Hazard h WHERE h.hazName = :hazName")
    , @NamedQuery(name = "Hazard.findByHazCode", query = "SELECT h FROM Hazard h WHERE h.hazCode = :hazCode")
    , @NamedQuery(name = "Hazard.findByHazGroupName", query = "SELECT h FROM Hazard h WHERE h.hazGroupName = :hazGroupName")
    , @NamedQuery(name = "Hazard.findByHazObsolete", query = "SELECT h FROM Hazard h WHERE h.hazObsolete = :hazObsolete")
    , @NamedQuery(name = "Hazard.findByHazShortName", query = "SELECT h FROM Hazard h WHERE h.hazShortName = :hazShortName")
    , @NamedQuery(name = "Hazard.findByHazKeyWords", query = "SELECT h FROM Hazard h WHERE h.hazKeyWords = :hazKeyWords")})
public class Hazard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "\"HAZ_ID\"")
    private Integer hazId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "\"HAZTYPE_ID\"")
    private int haztypeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "\"PERIOD_ID\"")
    private int periodId;
    @Size(max = 400)
    @Column(name = "\"HAZ_NAME\"")
    private String hazName;
    @Size(max = 10)
    @Column(name = "\"HAZ_CODE\"")
    private String hazCode;
    @Size(max = 100)
    @Column(name = "\"HAZ_GROUP_NAME\"")
    private String hazGroupName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "\"HAZ_OBSOLETE\"")
    private boolean hazObsolete;
    @Size(max = 60)
    @Column(name = "\"HAZ_SHORT_NAME\"")
    private String hazShortName;
    @Size(max = 1000)
    @Column(name = "\"HAZ_KEY_WORDS\"")
    private String hazKeyWords;

    public Hazard() {
    }

    public Hazard(Integer hazId) {
        this.hazId = hazId;
    }

    public Hazard(Integer hazId, int haztypeId, int periodId, boolean hazObsolete) {
        this.hazId = hazId;
        this.haztypeId = haztypeId;
        this.periodId = periodId;
        this.hazObsolete = hazObsolete;
    }

    public Integer getHazId() {
        return hazId;
    }

    public void setHazId(Integer hazId) {
        this.hazId = hazId;
    }

    public int getHaztypeId() {
        return haztypeId;
    }

    public void setHaztypeId(int haztypeId) {
        this.haztypeId = haztypeId;
    }

    public int getPeriodId() {
        return periodId;
    }

    public void setPeriodId(int periodId) {
        this.periodId = periodId;
    }

    public String getHazName() {
        return hazName;
    }

    public void setHazName(String hazName) {
        this.hazName = hazName;
    }

    public String getHazCode() {
        return hazCode;
    }

    public void setHazCode(String hazCode) {
        this.hazCode = hazCode;
    }

    public String getHazGroupName() {
        return hazGroupName;
    }

    public void setHazGroupName(String hazGroupName) {
        this.hazGroupName = hazGroupName;
    }

    public boolean getHazObsolete() {
        return hazObsolete;
    }

    public void setHazObsolete(boolean hazObsolete) {
        this.hazObsolete = hazObsolete;
    }

    public String getHazShortName() {
        return hazShortName;
    }

    public void setHazShortName(String hazShortName) {
        this.hazShortName = hazShortName;
    }

    public String getHazKeyWords() {
        return hazKeyWords;
    }

    public void setHazKeyWords(String hazKeyWords) {
        this.hazKeyWords = hazKeyWords;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hazId != null ? hazId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hazard)) {
            return false;
        }
        Hazard other = (Hazard) object;
        if ((this.hazId == null && other.hazId != null) || (this.hazId != null && !this.hazId.equals(other.hazId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.inversionkavkaz.DocMod.Entities.Hazard[ hazId=" + hazId + " ]";
    }
    
}
