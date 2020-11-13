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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DMITRY
 */
@Entity
@Table(name = "role_access")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoleAccess.findAll", query = "SELECT r FROM RoleAccess r")
    , @NamedQuery(name = "RoleAccess.findByRoleAccessId", query = "SELECT r FROM RoleAccess r WHERE r.roleAccessId = :roleAccessId")
    , @NamedQuery(name = "RoleAccess.findByCreateResult", query = "SELECT r FROM RoleAccess r WHERE r.createResult = :createResult")
    , @NamedQuery(name = "RoleAccess.findByEditResult", query = "SELECT r FROM RoleAccess r WHERE r.editResult = :editResult")
    , @NamedQuery(name = "RoleAccess.findByViewResult", query = "SELECT r FROM RoleAccess r WHERE r.viewResult = :viewResult")
    , @NamedQuery(name = "RoleAccess.findByDeleteResult", query = "SELECT r FROM RoleAccess r WHERE r.deleteResult = :deleteResult")})
public class RoleAccess implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "role_access_id")
    private Integer roleAccessId;
    @Column(name = "create_result")
    private Boolean createResult;
    @Column(name = "edit_result")
    private Boolean editResult;
    @Column(name = "view_result")
    private Boolean viewResult;
    @Column(name = "delete_result")
    private Boolean deleteResult;
    @JoinColumn(name = "html_page_id", referencedColumnName = "html_page_id")
    @ManyToOne
    private HtmlPages htmlPageId;
    @JoinColumn(name = "report_id", referencedColumnName = "report_id")
    @ManyToOne
    private Reports reportId;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne
    private Role roleId;

    public RoleAccess() {
    }

    public RoleAccess(Integer roleAccessId) {
        this.roleAccessId = roleAccessId;
    }

    public Integer getRoleAccessId() {
        return roleAccessId;
    }

    public void setRoleAccessId(Integer roleAccessId) {
        this.roleAccessId = roleAccessId;
    }

    public Boolean getCreateResult() {
        return createResult;
    }

    public void setCreateResult(Boolean createResult) {
        this.createResult = createResult;
    }

    public Boolean getEditResult() {
        return editResult;
    }

    public void setEditResult(Boolean editResult) {
        this.editResult = editResult;
    }

    public Boolean getViewResult() {
        return viewResult;
    }

    public void setViewResult(Boolean viewResult) {
        this.viewResult = viewResult;
    }

    public Boolean getDeleteResult() {
        return deleteResult;
    }

    public void setDeleteResult(Boolean deleteResult) {
        this.deleteResult = deleteResult;
    }

    public HtmlPages getHtmlPageId() {
        return htmlPageId;
    }

    public void setHtmlPageId(HtmlPages htmlPageId) {
        this.htmlPageId = htmlPageId;
    }

    public Reports getReportId() {
        return reportId;
    }

    public void setReportId(Reports reportId) {
        this.reportId = reportId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleAccessId != null ? roleAccessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleAccess)) {
            return false;
        }
        RoleAccess other = (RoleAccess) object;
        if ((this.roleAccessId == null && other.roleAccessId != null) || (this.roleAccessId != null && !this.roleAccessId.equals(other.roleAccessId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.inversionkavkaz.DocMod.Entities.RoleAccess[ roleAccessId=" + roleAccessId + " ]";
    }
    
}
