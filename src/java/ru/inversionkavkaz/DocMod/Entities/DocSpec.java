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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "doc_spec")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocSpec.findAll", query = "SELECT d FROM DocSpec d")
    , @NamedQuery(name = "DocSpec.findByRoom", query = "SELECT d FROM DocSpec d WHERE d.room = :room")
    , @NamedQuery(name = "DocSpec.findByDocSpecId", query = "SELECT d FROM DocSpec d WHERE d.docSpecId = :docSpecId")
    , @NamedQuery(name = "DocSpec.findByHtmlPageId", query = "SELECT d FROM DocSpec d WHERE d.htmlPageId = :htmlPageId")
    , @NamedQuery(name = "DocSpec.findByDoctor", query = "SELECT d FROM DocSpec d WHERE d.iddoctor = :iddoctor")
})
public class DocSpec implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 10)
    @Column(name = "room")
    private String room;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "doc_spec_id")
    private Integer docSpecId;
    @Column(name = "html_page_id")
    private Integer htmlPageId;
    @JoinColumn(name = "idspec", referencedColumnName = "idspec")
    @ManyToOne(optional = false)
    private DoctorSpecialty idspec;
    @JoinColumn(name = "iddoctor", referencedColumnName = "iddoctor")
    @ManyToOne(optional = false)
    private Doctors iddoctor;

    public DocSpec() {
    }

    public DocSpec(Integer docSpecId) {
        this.docSpecId = docSpecId;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Integer getDocSpecId() {
        return docSpecId;
    }

    public void setDocSpecId(Integer docSpecId) {
        this.docSpecId = docSpecId;
    }

    public Integer getHtmlPageId() {
        return htmlPageId;
    }

    public void setHtmlPageId(Integer htmlPageId) {
        this.htmlPageId = htmlPageId;
    }

    public DoctorSpecialty getIdspec() {
        return idspec;
    }

    public void setIdspec(DoctorSpecialty idspec) {
        this.idspec = idspec;
    }

    public Doctors getIddoctor() {
        return iddoctor;
    }

    public void setIddoctor(Doctors iddoctor) {
        this.iddoctor = iddoctor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (docSpecId != null ? docSpecId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocSpec)) {
            return false;
        }
        DocSpec other = (DocSpec) object;
        if ((this.docSpecId == null && other.docSpecId != null) || (this.docSpecId != null && !this.docSpecId.equals(other.docSpecId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.inversionkavkaz.DocMod.Entities.DocSpec[ docSpecId=" + docSpecId + " ]";
    }
    
}
