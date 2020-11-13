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
@Table(name = "start_page")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StartPage.findAll", query = "SELECT s FROM StartPage s")
    , @NamedQuery(name = "StartPage.findByStartPageId", query = "SELECT s FROM StartPage s WHERE s.startPageId = :startPageId")
    , @NamedQuery(name = "StartPage.findByStartPageName", query = "SELECT s FROM StartPage s WHERE s.startPageName = :startPageName")})
public class StartPage implements Serializable {

    @Size(max = 50)
    @Column(name = "start_page_file")
    private String startPageFile;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "start_page_id")
    private Integer startPageId;
    @Size(max = 50)
    @Column(name = "start_page_name")
    private String startPageName;

    public StartPage() {
    }

    public StartPage(Integer startPageId) {
        this.startPageId = startPageId;
    }

    public Integer getStartPageId() {
        return startPageId;
    }

    public void setStartPageId(Integer startPageId) {
        this.startPageId = startPageId;
    }

    public String getStartPageName() {
        return startPageName;
    }

    public void setStartPageName(String startPageName) {
        this.startPageName = startPageName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (startPageId != null ? startPageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StartPage)) {
            return false;
        }
        StartPage other = (StartPage) object;
        if ((this.startPageId == null && other.startPageId != null) || (this.startPageId != null && !this.startPageId.equals(other.startPageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.inversionkavkaz.DocMod.Entities.StartPage[ startPageId=" + startPageId + " ]";
    }

    public String getStartPageFile() {
        return startPageFile;
    }

    public void setStartPageFile(String startPageFile) {
        this.startPageFile = startPageFile;
    }
    
}
