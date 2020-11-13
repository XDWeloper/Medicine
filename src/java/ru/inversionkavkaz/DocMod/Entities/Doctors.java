/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.inversionkavkaz.DocMod.Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "doctors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doctors.findAll", query = "SELECT d FROM Doctors d")
    , @NamedQuery(name = "Doctors.findByIddoctor", query = "SELECT d FROM Doctors d WHERE d.iddoctor = :iddoctor")
    , @NamedQuery(name = "Doctors.findByFirstname", query = "SELECT d FROM Doctors d WHERE d.firstname = :firstname")
    , @NamedQuery(name = "Doctors.findByLastname", query = "SELECT d FROM Doctors d WHERE d.lastname = :lastname")
    , @NamedQuery(name = "Doctors.findByMiddlename", query = "SELECT d FROM Doctors d WHERE d.middlename = :middlename")
    , @NamedQuery(name = "Doctors.findByIdmedorg", query = "SELECT d FROM Doctors d WHERE d.idmedorg = :idmedorg")
    , @NamedQuery(name = "Doctors.findByPosition", query = "SELECT d FROM Doctors d WHERE d.position = :position")
    , @NamedQuery(name = "Doctors.findByCvalId", query = "SELECT d FROM Doctors d WHERE d.cvalId = :cvalId")
    , @NamedQuery(name = "Doctors.findByStageId", query = "SELECT d FROM Doctors d WHERE d.stageId = :stageId")
    , @NamedQuery(name = "Doctors.findByPhone", query = "SELECT d FROM Doctors d WHERE d.phone = :phone")
    , @NamedQuery(name = "Doctors.findByContactInf", query = "SELECT d FROM Doctors d WHERE d.contactInf = :contactInf")
    , @NamedQuery(name = "Doctors.findByRoleId", query = "SELECT d FROM Doctors d WHERE d.roleId = :roleId")
    , @NamedQuery(name = "Doctors.findByGroupId", query = "SELECT d FROM Doctors d WHERE d.groupId = :groupId")})
public class Doctors implements Serializable {

    @OneToMany(mappedBy = "doctorId")
    private Collection<GroupList> groupListCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddoctor")
    private Long iddoctor;
    @Size(max = 500)
    @Column(name = "firstname")
    private String firstname;
    @Size(max = 500)
    @Column(name = "lastname")
    private String lastname;
    @Size(max = 500)
    @Column(name = "middlename")
    private String middlename;
    @Column(name = "idmedorg")
    private Integer idmedorg;
    @Size(max = 200)
    @Column(name = "position")
    private String position;
    @Column(name = "cval_id")
    private Integer cvalId;
    @Column(name = "stage_id")
    private Integer stageId;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Недопустимый формат номера телефона/факса (должен иметь формат xxx-xxx-xxxx)")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 200)
    @Column(name = "phone")
    private String phone;
    @Size(max = 1000)
    @Column(name = "contact_inf")
    private String contactInf;
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "group_id")
    private Integer groupId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddoctor")
    private Collection<DocSpec> docSpecCollection;

    public Doctors() {
    }

    public Doctors(Long iddoctor) {
        this.iddoctor = iddoctor;
    }

    public Long getIddoctor() {
        return iddoctor;
    }

    public void setIddoctor(Long iddoctor) {
        this.iddoctor = iddoctor;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public Integer getIdmedorg() {
        return idmedorg;
    }

    public void setIdmedorg(Integer idmedorg) {
        this.idmedorg = idmedorg;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getCvalId() {
        return cvalId;
    }

    public void setCvalId(Integer cvalId) {
        this.cvalId = cvalId;
    }

    public Integer getStageId() {
        return stageId;
    }

    public void setStageId(Integer stageId) {
        this.stageId = stageId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContactInf() {
        return contactInf;
    }

    public void setContactInf(String contactInf) {
        this.contactInf = contactInf;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @XmlTransient
    public Collection<DocSpec> getDocSpecCollection() {
        return docSpecCollection;
    }

    public void setDocSpecCollection(Collection<DocSpec> docSpecCollection) {
        this.docSpecCollection = docSpecCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddoctor != null ? iddoctor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doctors)) {
            return false;
        }
        Doctors other = (Doctors) object;
        if ((this.iddoctor == null && other.iddoctor != null) || (this.iddoctor != null && !this.iddoctor.equals(other.iddoctor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.inversionkavkaz.DocMod.Entities.Doctors[ iddoctor=" + iddoctor + " ]";
    }

    @XmlTransient
    public Collection<GroupList> getGroupListCollection() {
        return groupListCollection;
    }

    public void setGroupListCollection(Collection<GroupList> groupListCollection) {
        this.groupListCollection = groupListCollection;
    }
    
}
