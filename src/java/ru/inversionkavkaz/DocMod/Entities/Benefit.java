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
@Table(name = "benefit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Benefit.findAll", query = "SELECT b FROM Benefit b")
    , @NamedQuery(name = "Benefit.findByBenefitCode", query = "SELECT b FROM Benefit b WHERE b.benefitCode = :benefitCode")
    , @NamedQuery(name = "Benefit.findByBenefitName", query = "SELECT b FROM Benefit b WHERE b.benefitName = :benefitName")})
public class Benefit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "benefit_code")
    private String benefitCode;
    @Size(max = 200)
    @Column(name = "benefit_name")
    private String benefitName;

    public Benefit() {
    }

    public Benefit(String benefitCode) {
        this.benefitCode = benefitCode;
    }

    public String getBenefitCode() {
        return benefitCode;
    }

    public void setBenefitCode(String benefitCode) {
        this.benefitCode = benefitCode;
    }

    public String getBenefitName() {
        return benefitName;
    }

    public void setBenefitName(String benefitName) {
        this.benefitName = benefitName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (benefitCode != null ? benefitCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Benefit)) {
            return false;
        }
        Benefit other = (Benefit) object;
        if ((this.benefitCode == null && other.benefitCode != null) || (this.benefitCode != null && !this.benefitCode.equals(other.benefitCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.inversionkavkaz.DocMod.Entities.Benefit[ benefitCode=" + benefitCode + " ]";
    }
    
}
