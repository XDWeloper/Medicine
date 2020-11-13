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
@Table(name = "cus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cus.findAll", query = "SELECT c FROM Cus c")
    , @NamedQuery(name = "Cus.findByIcusnum", query = "SELECT c FROM Cus c WHERE c.icusnum = :icusnum")
    , @NamedQuery(name = "Cus.findByCcusname", query = "SELECT c FROM Cus c WHERE c.ccusname = :ccusname")
    , @NamedQuery(name = "Cus.findByInn", query = "SELECT c FROM Cus c WHERE c.inn = :inn")
    , @NamedQuery(name = "Cus.findByOkpo", query = "SELECT c FROM Cus c WHERE c.okpo = :okpo")
    , @NamedQuery(name = "Cus.findByOgrn", query = "SELECT c FROM Cus c WHERE c.ogrn = :ogrn")
    , @NamedQuery(name = "Cus.findByBik", query = "SELECT c FROM Cus c WHERE c.bik = :bik")
    , @NamedQuery(name = "Cus.findByBank", query = "SELECT c FROM Cus c WHERE c.bank = :bank")
    , @NamedQuery(name = "Cus.findByCount", query = "SELECT c FROM Cus c WHERE c.count = :count")
    , @NamedQuery(name = "Cus.findByDiscount", query = "SELECT c FROM Cus c WHERE c.discount = :discount")
    , @NamedQuery(name = "Cus.findByDirector", query = "SELECT c FROM Cus c WHERE c.director = :director")
    , @NamedQuery(name = "Cus.findByDolgnost", query = "SELECT c FROM Cus c WHERE c.dolgnost = :dolgnost")
    , @NamedQuery(name = "Cus.findByCcussfullname", query = "SELECT c FROM Cus c WHERE c.ccussfullname = :ccussfullname")
    , @NamedQuery(name = "Cus.findByKpp", query = "SELECT c FROM Cus c WHERE c.kpp = :kpp")
    , @NamedQuery(name = "Cus.findByOkved", query = "SELECT c FROM Cus c WHERE c.okved = :okved")
    , @NamedQuery(name = "Cus.findByAdress", query = "SELECT c FROM Cus c WHERE c.adress = :adress")
    , @NamedQuery(name = "Cus.findByEmail", query = "SELECT c FROM Cus c WHERE c.email = :email")
    , @NamedQuery(name = "Cus.findBySmsphone", query = "SELECT c FROM Cus c WHERE c.smsphone = :smsphone")})
public class Cus implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "icusnum")
    private BigDecimal icusnum;
    @Size(max = 500)
    @Column(name = "ccusname")
    private String ccusname;
    @Size(max = 20)
    @Column(name = "inn")
    private String inn;
    @Size(max = 20)
    @Column(name = "okpo")
    private String okpo;
    @Size(max = 13)
    @Column(name = "ogrn")
    private String ogrn;
    @Size(max = 20)
    @Column(name = "bik")
    private String bik;
    @Size(max = 500)
    @Column(name = "bank")
    private String bank;
    @Size(max = 25)
    @Column(name = "count")
    private String count;
    @Column(name = "discount")
    private Integer discount;
    @Size(max = 100)
    @Column(name = "director")
    private String director;
    @Size(max = 100)
    @Column(name = "dolgnost")
    private String dolgnost;
    @Size(max = 500)
    @Column(name = "ccussfullname")
    private String ccussfullname;
    @Size(max = 20)
    @Column(name = "kpp")
    private String kpp;
    @Size(max = 20)
    @Column(name = "okved")
    private String okved;
    @Size(max = 500)
    @Column(name = "adress")
    private String adress;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Недопустимый адрес электронной почты")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 12)
    @Column(name = "smsphone")
    private String smsphone;

    public Cus() {
    }

    public Cus(BigDecimal icusnum) {
        this.icusnum = icusnum;
    }

    public BigDecimal getIcusnum() {
        return icusnum;
    }

    public void setIcusnum(BigDecimal icusnum) {
        this.icusnum = icusnum;
    }

    public String getCcusname() {
        return ccusname;
    }

    public void setCcusname(String ccusname) {
        this.ccusname = ccusname;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getOkpo() {
        return okpo;
    }

    public void setOkpo(String okpo) {
        this.okpo = okpo;
    }

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public String getBik() {
        return bik;
    }

    public void setBik(String bik) {
        this.bik = bik;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDolgnost() {
        return dolgnost;
    }

    public void setDolgnost(String dolgnost) {
        this.dolgnost = dolgnost;
    }

    public String getCcussfullname() {
        return ccussfullname;
    }

    public void setCcussfullname(String ccussfullname) {
        this.ccussfullname = ccussfullname;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getOkved() {
        return okved;
    }

    public void setOkved(String okved) {
        this.okved = okved;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSmsphone() {
        return smsphone;
    }

    public void setSmsphone(String smsphone) {
        this.smsphone = smsphone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (icusnum != null ? icusnum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cus)) {
            return false;
        }
        Cus other = (Cus) object;
        if ((this.icusnum == null && other.icusnum != null) || (this.icusnum != null && !this.icusnum.equals(other.icusnum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.inversionkavkaz.DocMod.Entities.Cus[ icusnum=" + icusnum + " ]";
    }
    
}
