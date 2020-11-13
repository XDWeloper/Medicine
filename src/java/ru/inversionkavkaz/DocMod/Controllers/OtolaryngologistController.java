
package ru.inversionkavkaz.DocMod.Controllers;

import java.io.Serializable;
import java.util.Date;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "otolaryngologistController")
@ViewScoped

public class OtolaryngologistController implements Serializable{

    private String complaints;
    private String nasalBreathing;
    private String mucous;
    private String nasalSeptum;
    private String pharynx;
    private String palatineTonsils;
    private String larynx;
    private String vocalFolds;
    private String otoscopy1;
    private String otoscopy2;
    private String audiometryData;
    private String audiometry;
    private Date  audiometryDate;
    private String vestibularApparatus;
    
    private String[] nasalBreathingCheck;
    private String[] mucousCheck;
    private String[] nasalSeptumCheck;
    private String[] pharynxCheck;
    private String[] palatineTonsilsCheck;
    private String[] larynxCheck;
    private String[] vocalFoldsCheck;
    private String[] otoscopyCheck1;
    private String[] otoscopyCheck2;
    private String[] audiometryDataCheck;
    private String[] audiometryCheck;
    private String[] vestibularApparatusCheck;
    
    

    public OtolaryngologistController() {
    }
    
    public void save(){
        int i = 0;
    }
    public void lisener(){
    }

    public Date getAudiometryDate() {
        return audiometryDate;
    }

    public void setAudiometryDate(Date audiometryDate) {
        this.audiometryDate = audiometryDate;
    }
    
    public String getComplaints() {
        return complaints;
    }

    public void setComplaints(String complaints) {
        this.complaints = complaints;
    }

    public String getNasalBreathing() {
        return nasalBreathing;
    }

    public void setNasalBreathing(String nasalBreathing) {
        this.nasalBreathing = nasalBreathing;
    }

    public String getMucous() {
        return mucous;
    }

    public void setMucous(String mucous) {
        this.mucous = mucous;
    }

    public String getNasalSeptum() {
        return nasalSeptum;
    }

    public void setNasalSeptum(String nasalSeptum) {
        this.nasalSeptum = nasalSeptum;
    }

    public String getPharynx() {
        return pharynx;
    }

    public void setPharynx(String pharynx) {
        this.pharynx = pharynx;
    }

    public String getPalatineTonsils() {
        return palatineTonsils;
    }

    public void setPalatineTonsils(String palatineTonsils) {
        this.palatineTonsils = palatineTonsils;
    }

    public String getLarynx() {
        return larynx;
    }

    public void setLarynx(String larynx) {
        this.larynx = larynx;
    }

    public String getVocalFolds() {
        return vocalFolds;
    }

    public void setVocalFolds(String vocalFolds) {
        this.vocalFolds = vocalFolds;
    }

    public String getOtoscopy1() {
        return otoscopy1;
    }

    public void setOtoscopy1(String otoscopy) {
        this.otoscopy1 = otoscopy;
    }
    public String getOtoscopy2() {
        return otoscopy2;
    }

    public void setOtoscopy2(String otoscopy) {
        this.otoscopy2 = otoscopy;
    }

    public String getAudiometryData() {
        return audiometryData;
    }

    public void setAudiometryData(String audiometryData) {
        this.audiometryData = audiometryData;
    }

    public String getAudiometry() {
        return audiometry;
    }

    public void setAudiometry(String audiometry) {
        this.audiometry = audiometry;
    }

    public String getVestibularApparatus() {
        return vestibularApparatus;
    }

    public void setVestibularApparatus(String vestibularApparatus) {
        this.vestibularApparatus = vestibularApparatus;
    }

    public String[] getNasalBreathingCheck() {
        return nasalBreathingCheck;
    }

    public void setNasalBreathingCheck(String[] nasalBreathingCheck) {
        this.nasalBreathingCheck = nasalBreathingCheck;
    }

    public String[] getMucousCheck() {
        return mucousCheck;
    }

    public void setMucousCheck(String[] mucousCheck) {
        this.mucousCheck = mucousCheck;
    }

    public String[] getNasalSeptumCheck() {
        return nasalSeptumCheck;
    }

    public void setNasalSeptumCheck(String[] nasalSeptumCheck) {
        this.nasalSeptumCheck = nasalSeptumCheck;
    }

    public String[] getPharynxCheck() {
        return pharynxCheck;
    }

    public void setPharynxCheck(String[] pharynxCheck) {
        this.pharynxCheck = pharynxCheck;
    }

    public String[] getPalatineTonsilsCheck() {
        return palatineTonsilsCheck;
    }

    public void setPalatineTonsilsCheck(String[] palatineTonsilsCheck) {
        this.palatineTonsilsCheck = palatineTonsilsCheck;
    }

    public String[] getLarynxCheck() {
        return larynxCheck;
    }

    public void setLarynxCheck(String[] larynxCheck) {
        this.larynxCheck = larynxCheck;
    }

    public String[] getVocalFoldsCheck() {
        return vocalFoldsCheck;
    }

    public void setVocalFoldsCheck(String[] vocalFoldsCheck) {
        this.vocalFoldsCheck = vocalFoldsCheck;
    }

    public String[] getOtoscopyCheck1() {
        return otoscopyCheck1;
    }

    public void setOtoscopyCheck1(String[] otoscopyCheck1) {
        this.otoscopyCheck1 = otoscopyCheck1;
    }

    public String[] getOtoscopyCheck2() {
        return otoscopyCheck2;
    }

    public void setOtoscopyCheck2(String[] otoscopyCheck2) {
        this.otoscopyCheck2 = otoscopyCheck2;
    }

    public String[] getAudiometryDataCheck() {
        return audiometryDataCheck;
    }

    public void setAudiometryDataCheck(String[] audiometryDataCheck) {
        this.audiometryDataCheck = audiometryDataCheck;
    }

    public String[] getAudiometryCheck() {
        return audiometryCheck;
    }

    public void setAudiometryCheck(String[] audiometryCheck) {
        this.audiometryCheck = audiometryCheck;
    }

    public String[] getVestibularApparatusCheck() {
        return vestibularApparatusCheck;
    }

    public void setVestibularApparatusCheck(String[] vestibularApparatusCheck) {
        this.vestibularApparatusCheck = vestibularApparatusCheck;
    }

}
