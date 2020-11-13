/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.inversionkavkaz.DocMod.Entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DMITRY
 */
@Entity
@Table(name = "adress")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adress.findAll", query = "SELECT a FROM Adress a"),
    @NamedQuery(name = "Adress.findByIdperson", query = "SELECT a FROM Adress a WHERE a.idperson = :idperson"),
    @NamedQuery(name = "Adress.findByRegion", query = "SELECT a FROM Adress a WHERE a.region = :region"),
    @NamedQuery(name = "Adress.findByArea", query = "SELECT a FROM Adress a WHERE a.area = :area"),
    @NamedQuery(name = "Adress.findByCity", query = "SELECT a FROM Adress a WHERE a.city = :city"),
    @NamedQuery(name = "Adress.findByLocality", query = "SELECT a FROM Adress a WHERE a.locality = :locality"),
    @NamedQuery(name = "Adress.findByStreet", query = "SELECT a FROM Adress a WHERE a.street = :street"),
    @NamedQuery(name = "Adress.findByHouse", query = "SELECT a FROM Adress a WHERE a.house = :house"),
    @NamedQuery(name = "Adress.findByFlat", query = "SELECT a FROM Adress a WHERE a.flat = :flat"),
    @NamedQuery(name = "Adress.findByPlace", query = "SELECT a FROM Adress a WHERE a.place = :place")})
public class Adress implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idperson")
    private BigDecimal idperson;
    @Size(max = 200)
    @Column(name = "region")
    private String region;
    @Size(max = 200)
    @Column(name = "area")
    private String area;
    @Size(max = 100)
    @Column(name = "city")
    private String city;
    @Size(max = 100)
    @Column(name = "locality")
    private String locality;
    @Size(max = 100)
    @Column(name = "street")
    private String street;
    @Size(max = 10)
    @Column(name = "house")
    private String house;
    @Size(max = 10)
    @Column(name = "flat")
    private String flat;
    @Size(max = 50)
    @Column(name = "place")
    private String place;
    @JoinColumn(name = "idperson", referencedColumnName = "idperson", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persons persons;

    public Adress() {
    }

    public Adress(BigDecimal idperson) {
        this.idperson = idperson;
    }

    public BigDecimal getIdperson() {
        return idperson;
    }

    public void setIdperson(BigDecimal idperson) {
        this.idperson = idperson;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Persons getPersons() {
        return persons;
    }

    public void setPersons(Persons persons) {
        this.persons = persons;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperson != null ? idperson.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adress)) {
            return false;
        }
        Adress other = (Adress) object;
        if ((this.idperson == null && other.idperson != null) || (this.idperson != null && !this.idperson.equals(other.idperson))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.inversionkavkaz.DocMod.Entities.Adress[ idperson=" + idperson + " ]";
    }
    
}
