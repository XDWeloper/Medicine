/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.inversionkavkaz.DocMod.Entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DMITRY
 */
@Entity
@Table(name = "persons_rezults")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonsRezults.findAll", query = "SELECT p FROM PersonsRezults p")
    , @NamedQuery(name = "PersonsRezults.findByRezId", query = "SELECT p FROM PersonsRezults p WHERE p.rezId = :rezId")
    , @NamedQuery(name = "PersonsRezults.findByPersonId", query = "SELECT p FROM PersonsRezults p WHERE p.personId = :personId")
    , @NamedQuery(name = "PersonsRezults.findBySpecId", query = "SELECT p FROM PersonsRezults p WHERE p.specId = :specId")
    , @NamedQuery(name = "PersonsRezults.findByDoctorId", query = "SELECT p FROM PersonsRezults p WHERE p.doctorId = :doctorId")
    , @NamedQuery(name = "PersonsRezults.findByRezDate", query = "SELECT p FROM PersonsRezults p WHERE p.rezDate = :rezDate")
    , @NamedQuery(name = "PersonsRezults.findByComplaints", query = "SELECT p FROM PersonsRezults p WHERE p.complaints = :complaints")
    , @NamedQuery(name = "PersonsRezults.findByHistory", query = "SELECT p FROM PersonsRezults p WHERE p.history = :history")
    , @NamedQuery(name = "PersonsRezults.findBySelectedSkinIntegument", query = "SELECT p FROM PersonsRezults p WHERE p.selectedSkinIntegument = :selectedSkinIntegument")
    , @NamedQuery(name = "PersonsRezults.findBySkinIntegument", query = "SELECT p FROM PersonsRezults p WHERE p.skinIntegument = :skinIntegument")
    , @NamedQuery(name = "PersonsRezults.findBySelectedlymphNodes", query = "SELECT p FROM PersonsRezults p WHERE p.selectedlymphNodes = :selectedlymphNodes")
    , @NamedQuery(name = "PersonsRezults.findByLymphNodes", query = "SELECT p FROM PersonsRezults p WHERE p.lymphNodes = :lymphNodes")
    , @NamedQuery(name = "PersonsRezults.findBySelectedthyroidGland", query = "SELECT p FROM PersonsRezults p WHERE p.selectedthyroidGland = :selectedthyroidGland")
    , @NamedQuery(name = "PersonsRezults.findByThyroidGland", query = "SELECT p FROM PersonsRezults p WHERE p.thyroidGland = :thyroidGland")
    , @NamedQuery(name = "PersonsRezults.findBySelectedwheezing", query = "SELECT p FROM PersonsRezults p WHERE p.selectedwheezing = :selectedwheezing")
    , @NamedQuery(name = "PersonsRezults.findByWheezing", query = "SELECT p FROM PersonsRezults p WHERE p.wheezing = :wheezing")
    , @NamedQuery(name = "PersonsRezults.findBySelectedwheezing1", query = "SELECT p FROM PersonsRezults p WHERE p.selectedwheezing1 = :selectedwheezing1")
    , @NamedQuery(name = "PersonsRezults.findBySelectedwheezing2", query = "SELECT p FROM PersonsRezults p WHERE p.selectedwheezing2 = :selectedwheezing2")
    , @NamedQuery(name = "PersonsRezults.findBySelectedbrife", query = "SELECT p FROM PersonsRezults p WHERE p.selectedbrife = :selectedbrife")
    , @NamedQuery(name = "PersonsRezults.findBySelectedheartTones", query = "SELECT p FROM PersonsRezults p WHERE p.selectedheartTones = :selectedheartTones")
    , @NamedQuery(name = "PersonsRezults.findByHeartTones", query = "SELECT p FROM PersonsRezults p WHERE p.heartTones = :heartTones")
    , @NamedQuery(name = "PersonsRezults.findBySelectedarterPuls", query = "SELECT p FROM PersonsRezults p WHERE p.selectedarterPuls = :selectedarterPuls")
    , @NamedQuery(name = "PersonsRezults.findByArterPuls", query = "SELECT p FROM PersonsRezults p WHERE p.arterPuls = :arterPuls")
    , @NamedQuery(name = "PersonsRezults.findByChss", query = "SELECT p FROM PersonsRezults p WHERE p.chss = :chss")
    , @NamedQuery(name = "PersonsRezults.findByArteryOpress", query = "SELECT p FROM PersonsRezults p WHERE p.arteryOpress = :arteryOpress")
    , @NamedQuery(name = "PersonsRezults.findBySelectedLang", query = "SELECT p FROM PersonsRezults p WHERE p.selectedLang = :selectedLang")
    , @NamedQuery(name = "PersonsRezults.findByLang", query = "SELECT p FROM PersonsRezults p WHERE p.lang = :lang")
    , @NamedQuery(name = "PersonsRezults.findBySelectedLiver", query = "SELECT p FROM PersonsRezults p WHERE p.selectedLiver = :selectedLiver")
    , @NamedQuery(name = "PersonsRezults.findByLiver", query = "SELECT p FROM PersonsRezults p WHERE p.liver = :liver")
    , @NamedQuery(name = "PersonsRezults.findBySelectedBelly", query = "SELECT p FROM PersonsRezults p WHERE p.selectedBelly = :selectedBelly")
    , @NamedQuery(name = "PersonsRezults.findByBelly", query = "SELECT p FROM PersonsRezults p WHERE p.belly = :belly")
    , @NamedQuery(name = "PersonsRezults.findBySelectedSpleen", query = "SELECT p FROM PersonsRezults p WHERE p.selectedSpleen = :selectedSpleen")
    , @NamedQuery(name = "PersonsRezults.findBySpleen", query = "SELECT p FROM PersonsRezults p WHERE p.spleen = :spleen")
    , @NamedQuery(name = "PersonsRezults.findBySelectedKidney", query = "SELECT p FROM PersonsRezults p WHERE p.selectedKidney = :selectedKidney")
    , @NamedQuery(name = "PersonsRezults.findByKidney", query = "SELECT p FROM PersonsRezults p WHERE p.kidney = :kidney")
    , @NamedQuery(name = "PersonsRezults.findBySelectedPerefOtek", query = "SELECT p FROM PersonsRezults p WHERE p.selectedPerefOtek = :selectedPerefOtek")
    , @NamedQuery(name = "PersonsRezults.findByPerefOtek", query = "SELECT p FROM PersonsRezults p WHERE p.perefOtek = :perefOtek")
    , @NamedQuery(name = "PersonsRezults.findBySellectedosmotrRez", query = "SELECT p FROM PersonsRezults p WHERE p.sellectedosmotrRez = :sellectedosmotrRez")
    , @NamedQuery(name = "PersonsRezults.findBySellectedContraindication", query = "SELECT p FROM PersonsRezults p WHERE p.sellectedContraindication = :sellectedContraindication")
    , @NamedQuery(name = "PersonsRezults.findBySellectedhealthGroup", query = "SELECT p FROM PersonsRezults p WHERE p.sellectedhealthGroup = :sellectedhealthGroup")
    , @NamedQuery(name = "PersonsRezults.findByRecomendation", query = "SELECT p FROM PersonsRezults p WHERE p.recomendation = :recomendation")})
public class PersonsRezults implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "rez_id")
    private Integer rezId;
    @Column(name = "person_id")
    private Integer personId;
    @Column(name = "spec_id")
    private Integer specId;
    @Column(name = "doctor_id")
    private Integer doctorId;
    @Column(name = "rez_date")
    @Temporal(TemporalType.DATE)
    private Date rezDate;
    @Size(max = 1000)
    @Column(name = "complaints")
    private String complaints;
    @Size(max = 1000)
    @Column(name = "history")
    private String history;
    @Size(max = 100)
    @Column(name = "\"selectedSkinIntegument\"")
    private String selectedSkinIntegument;
    @Size(max = 500)
    @Column(name = "\"skinIntegument\"")
    private String skinIntegument;
    @Size(max = 50)
    @Column(name = "\"selectedlymphNodes\"")
    private String selectedlymphNodes;
    @Size(max = 200)
    @Column(name = "\"lymphNodes\"")
    private String lymphNodes;
    @Size(max = 50)
    @Column(name = "\"selectedthyroidGland\"")
    private String selectedthyroidGland;
    @Size(max = 200)
    @Column(name = "\"thyroidGland\"")
    private String thyroidGland;
    @Size(max = 50)
    @Column(name = "selectedwheezing")
    private String selectedwheezing;
    @Size(max = 10)
    @Column(name = "wheezing")
    private String wheezing;
    @Size(max = 100)
    @Column(name = "selectedwheezing1")
    private String selectedwheezing1;
    @Size(max = 100)
    @Column(name = "selectedwheezing2")
    private String selectedwheezing2;
    @Size(max = 100)
    @Column(name = "selectedbrife")
    private String selectedbrife;
    @Size(max = 100)
    @Column(name = "\"selectedheartTones\"")
    private String selectedheartTones;
    @Size(max = 200)
    @Column(name = "\"heartTones\"")
    private String heartTones;
    @Size(max = 50)
    @Column(name = "\"selectedarterPuls\"")
    private String selectedarterPuls;
    @Size(max = 10)
    @Column(name = "\"arterPuls\"")
    private String arterPuls;
    @Size(max = 10)
    @Column(name = "chss")
    private String chss;
    @Size(max = 10)
    @Column(name = "\"arteryOpress\"")
    private String arteryOpress;
    @Size(max = 50)
    @Column(name = "\"selectedLang\"")
    private String selectedLang;
    @Size(max = 200)
    @Column(name = "lang")
    private String lang;
    @Size(max = 52)
    @Column(name = "\"selectedLiver\"")
    private String selectedLiver;
    @Size(max = 200)
    @Column(name = "liver")
    private String liver;
    @Size(max = 20)
    @Column(name = "\"selectedBelly\"")
    private String selectedBelly;
    @Size(max = 200)
    @Column(name = "belly")
    private String belly;
    @Size(max = 51)
    @Column(name = "\"selectedSpleen\"")
    private String selectedSpleen;
    @Size(max = 200)
    @Column(name = "spleen")
    private String spleen;
    @Size(max = 20)
    @Column(name = "\"selectedKidney\"")
    private String selectedKidney;
    @Size(max = 200)
    @Column(name = "kidney")
    private String kidney;
    @Size(max = 20)
    @Column(name = "\"selectedPerefOtek\"")
    private String selectedPerefOtek;
    @Size(max = 200)
    @Column(name = "\"perefOtek\"")
    private String perefOtek;
    @Size(max = 50)
    @Column(name = "\"SellectedosmotrRez\"")
    private String sellectedosmotrRez;
    @Size(max = 50)
    @Column(name = "\"SellectedContraindication\"")
    private String sellectedContraindication;
    @Size(max = 50)
    @Column(name = "\"SellectedhealthGroup\"")
    private String sellectedhealthGroup;
    @Size(max = 500)
    @Column(name = "recomendation")
    private String recomendation;

    public PersonsRezults() {
    }

    public PersonsRezults(Integer rezId) {
        this.rezId = rezId;
    }

    public Integer getRezId() {
        return rezId;
    }

    public void setRezId(Integer rezId) {
        this.rezId = rezId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Date getRezDate() {
        return rezDate;
    }

    public void setRezDate(Date rezDate) {
        this.rezDate = rezDate;
    }

    public String getComplaints() {
        return complaints;
    }

    public void setComplaints(String complaints) {
        this.complaints = complaints;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getSelectedSkinIntegument() {
        return selectedSkinIntegument;
    }

    public void setSelectedSkinIntegument(String selectedSkinIntegument) {
        this.selectedSkinIntegument = selectedSkinIntegument;
    }

    public String getSkinIntegument() {
        return skinIntegument;
    }

    public void setSkinIntegument(String skinIntegument) {
        this.skinIntegument = skinIntegument;
    }

    public String getSelectedlymphNodes() {
        return selectedlymphNodes;
    }

    public void setSelectedlymphNodes(String selectedlymphNodes) {
        this.selectedlymphNodes = selectedlymphNodes;
    }

    public String getLymphNodes() {
        return lymphNodes;
    }

    public void setLymphNodes(String lymphNodes) {
        this.lymphNodes = lymphNodes;
    }

    public String getSelectedthyroidGland() {
        return selectedthyroidGland;
    }

    public void setSelectedthyroidGland(String selectedthyroidGland) {
        this.selectedthyroidGland = selectedthyroidGland;
    }

    public String getThyroidGland() {
        return thyroidGland;
    }

    public void setThyroidGland(String thyroidGland) {
        this.thyroidGland = thyroidGland;
    }

    public String getSelectedwheezing() {
        return selectedwheezing;
    }

    public void setSelectedwheezing(String selectedwheezing) {
        this.selectedwheezing = selectedwheezing;
    }

    public String getWheezing() {
        return wheezing;
    }

    public void setWheezing(String wheezing) {
        this.wheezing = wheezing;
    }

    public String getSelectedwheezing1() {
        return selectedwheezing1;
    }

    public void setSelectedwheezing1(String selectedwheezing1) {
        this.selectedwheezing1 = selectedwheezing1;
    }

    public String getSelectedwheezing2() {
        return selectedwheezing2;
    }

    public void setSelectedwheezing2(String selectedwheezing2) {
        this.selectedwheezing2 = selectedwheezing2;
    }

    public String getSelectedbrife() {
        return selectedbrife;
    }

    public void setSelectedbrife(String selectedbrife) {
        this.selectedbrife = selectedbrife;
    }

    public String getSelectedheartTones() {
        return selectedheartTones;
    }

    public void setSelectedheartTones(String selectedheartTones) {
        this.selectedheartTones = selectedheartTones;
    }

    public String getHeartTones() {
        return heartTones;
    }

    public void setHeartTones(String heartTones) {
        this.heartTones = heartTones;
    }

    public String getSelectedarterPuls() {
        return selectedarterPuls;
    }

    public void setSelectedarterPuls(String selectedarterPuls) {
        this.selectedarterPuls = selectedarterPuls;
    }

    public String getArterPuls() {
        return arterPuls;
    }

    public void setArterPuls(String arterPuls) {
        this.arterPuls = arterPuls;
    }

    public String getChss() {
        return chss;
    }

    public void setChss(String chss) {
        this.chss = chss;
    }

    public String getArteryOpress() {
        return arteryOpress;
    }

    public void setArteryOpress(String arteryOpress) {
        this.arteryOpress = arteryOpress;
    }

    public String getSelectedLang() {
        return selectedLang;
    }

    public void setSelectedLang(String selectedLang) {
        this.selectedLang = selectedLang;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getSelectedLiver() {
        return selectedLiver;
    }

    public void setSelectedLiver(String selectedLiver) {
        this.selectedLiver = selectedLiver;
    }

    public String getLiver() {
        return liver;
    }

    public void setLiver(String liver) {
        this.liver = liver;
    }

    public String getSelectedBelly() {
        return selectedBelly;
    }

    public void setSelectedBelly(String selectedBelly) {
        this.selectedBelly = selectedBelly;
    }

    public String getBelly() {
        return belly;
    }

    public void setBelly(String belly) {
        this.belly = belly;
    }

    public String getSelectedSpleen() {
        return selectedSpleen;
    }

    public void setSelectedSpleen(String selectedSpleen) {
        this.selectedSpleen = selectedSpleen;
    }

    public String getSpleen() {
        return spleen;
    }

    public void setSpleen(String spleen) {
        this.spleen = spleen;
    }

    public String getSelectedKidney() {
        return selectedKidney;
    }

    public void setSelectedKidney(String selectedKidney) {
        this.selectedKidney = selectedKidney;
    }

    public String getKidney() {
        return kidney;
    }

    public void setKidney(String kidney) {
        this.kidney = kidney;
    }

    public String getSelectedPerefOtek() {
        return selectedPerefOtek;
    }

    public void setSelectedPerefOtek(String selectedPerefOtek) {
        this.selectedPerefOtek = selectedPerefOtek;
    }

    public String getPerefOtek() {
        return perefOtek;
    }

    public void setPerefOtek(String perefOtek) {
        this.perefOtek = perefOtek;
    }

    public String getSellectedosmotrRez() {
        return sellectedosmotrRez;
    }

    public void setSellectedosmotrRez(String sellectedosmotrRez) {
        this.sellectedosmotrRez = sellectedosmotrRez;
    }

    public String getSellectedContraindication() {
        return sellectedContraindication;
    }

    public void setSellectedContraindication(String sellectedContraindication) {
        this.sellectedContraindication = sellectedContraindication;
    }

    public String getSellectedhealthGroup() {
        return sellectedhealthGroup;
    }

    public void setSellectedhealthGroup(String sellectedhealthGroup) {
        this.sellectedhealthGroup = sellectedhealthGroup;
    }

    public String getRecomendation() {
        return recomendation;
    }

    public void setRecomendation(String recomendation) {
        this.recomendation = recomendation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rezId != null ? rezId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonsRezults)) {
            return false;
        }
        PersonsRezults other = (PersonsRezults) object;
        if ((this.rezId == null && other.rezId != null) || (this.rezId != null && !this.rezId.equals(other.rezId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
         SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY");
         String toUpperCase = simpleDateFormat.format(getRezDate()).toUpperCase();
        return toUpperCase;
    }
    
}
