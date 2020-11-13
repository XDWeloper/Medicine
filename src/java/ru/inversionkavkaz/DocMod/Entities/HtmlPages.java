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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DMITRY
 */
@Entity
@Table(name = "html_pages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HtmlPages.findAll", query = "SELECT h FROM HtmlPages h")
    , @NamedQuery(name = "HtmlPages.findByHtmlPageId", query = "SELECT h FROM HtmlPages h WHERE h.htmlPageId = :htmlPageId")
    , @NamedQuery(name = "HtmlPages.findByHtmlTypeId", query = "SELECT h FROM HtmlPages h WHERE h.htmlTypeId = :htmlTypeId")
    , @NamedQuery(name = "HtmlPages.findByHtmlPageName", query = "SELECT h FROM HtmlPages h WHERE h.htmlPageName = :htmlPageName")
    , @NamedQuery(name = "HtmlPages.findByHtmlPageFileName", query = "SELECT h FROM HtmlPages h WHERE h.htmlPageFileName = :htmlPageFileName")})
public class HtmlPages implements Serializable {

    @OneToMany(mappedBy = "htmlPageId")
    private Collection<RoleAccess> roleAccessCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "html_page_id")
    private Integer htmlPageId;
    @Column(name = "html_type_id")
    private Integer htmlTypeId;
    @Size(max = 50)
    @Column(name = "html_page_name")
    private String htmlPageName;
    @Size(max = 50)
    @Column(name = "html_page_file_name")
    private String htmlPageFileName;

    public HtmlPages() {
    }

    public HtmlPages(Integer htmlPageId) {
        this.htmlPageId = htmlPageId;
    }

    public Integer getHtmlPageId() {
        return htmlPageId;
    }

    public void setHtmlPageId(Integer htmlPageId) {
        this.htmlPageId = htmlPageId;
    }

    public Integer getHtmlTypeId() {
        return htmlTypeId;
    }

    public void setHtmlTypeId(Integer htmlTypeId) {
        this.htmlTypeId = htmlTypeId;
    }

    public String getHtmlPageName() {
        return htmlPageName;
    }

    public void setHtmlPageName(String htmlPageName) {
        this.htmlPageName = htmlPageName;
    }

    public String getHtmlPageFileName() {
        return htmlPageFileName;
    }

    public void setHtmlPageFileName(String htmlPageFileName) {
        this.htmlPageFileName = htmlPageFileName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (htmlPageId != null ? htmlPageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HtmlPages)) {
            return false;
        }
        HtmlPages other = (HtmlPages) object;
        if ((this.htmlPageId == null && other.htmlPageId != null) || (this.htmlPageId != null && !this.htmlPageId.equals(other.htmlPageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return htmlPageName;
    }

    @XmlTransient
    public Collection<RoleAccess> getRoleAccessCollection() {
        return roleAccessCollection;
    }

    public void setRoleAccessCollection(Collection<RoleAccess> roleAccessCollection) {
        this.roleAccessCollection = roleAccessCollection;
    }
    
}
