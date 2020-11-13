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
@Table(name = "group_list")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GroupList.findAll", query = "SELECT g FROM GroupList g")
    , @NamedQuery(name = "GroupList.findByGroupLisetId", query = "SELECT g FROM GroupList g WHERE g.groupLisetId = :groupLisetId")
})
public class GroupList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "group_liset_id")
    private Integer groupLisetId;
    @JoinColumn(name = "doctor_id", referencedColumnName = "iddoctor")
    @ManyToOne
    private Doctors doctorId;
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    @ManyToOne
    private Group1 groupId;

    public GroupList() {
    }

    public GroupList(Integer groupLisetId) {
        this.groupLisetId = groupLisetId;
    }

    public Integer getGroupLisetId() {
        return groupLisetId;
    }

    public void setGroupLisetId(Integer groupLisetId) {
        this.groupLisetId = groupLisetId;
    }

    public Doctors getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Doctors doctorId) {
        this.doctorId = doctorId;
    }

    public Group1 getGroupId() {
        return groupId;
    }

    public void setGroupId(Group1 groupId) {
        this.groupId = groupId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupLisetId != null ? groupLisetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupList)) {
            return false;
        }
        GroupList other = (GroupList) object;
        if ((this.groupLisetId == null && other.groupLisetId != null) || (this.groupLisetId != null && !this.groupLisetId.equals(other.groupLisetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.inversionkavkaz.DocMod.Entities.GroupList[ groupLisetId=" + groupLisetId + " ]";
    }
    
}
