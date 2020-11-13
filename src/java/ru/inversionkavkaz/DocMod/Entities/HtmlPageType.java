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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DMITRY
 */
@Entity
@Table(name = "html_page_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HtmlPageType.findAll", query = "SELECT h FROM HtmlPageType h")
    , @NamedQuery(name = "HtmlPageType.findByHtmlTypeId", query = "SELECT h FROM HtmlPageType h WHERE h.htmlTypeId = :htmlTypeId")
    , @NamedQuery(name = "HtmlPageType.findByHtmlTypeName", query = "SELECT h FROM HtmlPageType h WHERE h.htmlTypeName = :htmlTypeName")})
public class HtmlPageType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "html_type_id")
    private Integer htmlTypeId;
    @Size(max = 50)
    @Column(name = "html_type_name")
    private String htmlTypeName;

    public HtmlPageType() {
    }

    public HtmlPageType(Integer htmlTypeId) {
        this.htmlTypeId = htmlTypeId;
    }

    public Integer getHtmlTypeId() {
        return htmlTypeId;
    }

    public void setHtmlTypeId(Integer htmlTypeId) {
        this.htmlTypeId = htmlTypeId;
    }

    public String getHtmlTypeName() {
        return htmlTypeName;
    }

    public void setHtmlTypeName(String htmlTypeName) {
        this.htmlTypeName = htmlTypeName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (htmlTypeId != null ? htmlTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HtmlPageType)) {
            return false;
        }
        HtmlPageType other = (HtmlPageType) object;
        if ((this.htmlTypeId == null && other.htmlTypeId != null) || (this.htmlTypeId != null && !this.htmlTypeId.equals(other.htmlTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+ htmlTypeId;
    }
    
}
