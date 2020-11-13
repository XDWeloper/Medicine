/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.inversionkavkaz.DocMod.Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "reports")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reports.findAll", query = "SELECT r FROM Reports r")
    , @NamedQuery(name = "Reports.findByReportId", query = "SELECT r FROM Reports r WHERE r.reportId = :reportId")
    , @NamedQuery(name = "Reports.findByReportName", query = "SELECT r FROM Reports r WHERE r.reportName = :reportName")
    , @NamedQuery(name = "Reports.findByReportFile", query = "SELECT r FROM Reports r WHERE r.reportFile = :reportFile")})
public class Reports implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "report_id")
    private Integer reportId;
    @Size(max = 50)
    @Column(name = "report_name")
    private String reportName;
    @Size(max = 50)
    @Column(name = "report_file")
    private String reportFile;
    @OneToMany(mappedBy = "reportId")
    private Collection<RoleAccess> roleAccessCollection;

    public Reports() {
    }

    public Reports(Integer reportId) {
        this.reportId = reportId;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportFile() {
        return reportFile;
    }

    public void setReportFile(String reportFile) {
        this.reportFile = reportFile;
    }

    @XmlTransient
    public Collection<RoleAccess> getRoleAccessCollection() {
        return roleAccessCollection;
    }

    public void setRoleAccessCollection(Collection<RoleAccess> roleAccessCollection) {
        this.roleAccessCollection = roleAccessCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportId != null ? reportId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reports)) {
            return false;
        }
        Reports other = (Reports) object;
        if ((this.reportId == null && other.reportId != null) || (this.reportId != null && !this.reportId.equals(other.reportId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.inversionkavkaz.DocMod.Entities.Reports[ reportId=" + reportId + " ]";
    }
    
}
