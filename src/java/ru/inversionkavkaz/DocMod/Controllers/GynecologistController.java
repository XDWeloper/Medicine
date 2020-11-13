
package ru.inversionkavkaz.DocMod.Controllers;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "gynecologistController")
@ViewScoped
public class GynecologistController implements Serializable{

    private String complaints;
    private String menstruationFrom;
    private Map<Integer,String> menstruationFromList = new TreeMap<>();
    private String menstruationAcross;
    private Map<Integer,String> menstruationAcrossList = new TreeMap<>();
    private String menstruationFo;
    private Map<Integer,String> menstruationFoList = new TreeMap<>();
    private String menstruationStay;
    private Date lastMaenstruationDate;
    private Date bornedDate;
    private Date abortionDate;
    private String genitaDiseases;
    private String mammaryGland ;
    private String lymphNodes;
    private String lymphNodesField;
    private String genitalStatus;
    private String vagina;
    private String gervixField;
    private String[] gervix;
    private String uterus1;
    private String uterus2;
    private String uterus3;
    private String[] uterus;
    
    private String lefTadnexa;
    private String righTadnexa;
    private String vaulting;
    private String release;
    
    private String traccion;
    private String traccionField;
    
    
    
    
    public GynecologistController() {
    }
     @PostConstruct void Init(){
         int i =17;
         while(i-- >= 10) menstruationFromList.put(i, ""+i);
         i = 50;
         while(i-- >= 10) menstruationAcrossList.put(i, ""+i);
         i = 15;
         while(i-- >= 5) menstruationFoList.put(i, ""+i);
     }
    public void save(){
        int i = 0;
    }
    
    public void lisener(){}

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }

    public String getTraccionField() {
        return traccionField;
    }

    public void setTraccionField(String traccionField) {
        this.traccionField = traccionField;
    }

    public String getGervixField() {
        return gervixField;
    }

    public String[] getUterus() {
        return uterus;
    }

    public void setUterus(String[] uterus) {
        this.uterus = uterus;
    }

    public void setGervixField(String gervixField) {
        this.gervixField = gervixField;
    }

    public String[] getGervix() {
        return gervix;
    }

    public void setGervix(String[] gervix) {
        this.gervix = gervix;
    }

    
    public String getLymphNodesField() {
        return lymphNodesField;
    }

    public void setLymphNodesField(String lymphNodesField) {
        this.lymphNodesField = lymphNodesField;
    }

    public String getComplaints() {
        return complaints;
    }

    public void setComplaints(String complaints) {
        this.complaints = complaints;
    }

    public Map<Integer, String> getMenstruationFromList() {
        return menstruationFromList;
    }

    public void setMenstruationFromList(Map<Integer, String> menstruationFromList) {
        this.menstruationFromList = menstruationFromList;
    }

    public Map<Integer, String> getMenstruationAcrossList() {
        return menstruationAcrossList;
    }

    public void setMenstruationAcrossList(Map<Integer, String> menstruationAcrossList) {
        this.menstruationAcrossList = menstruationAcrossList;
    }

    public Map<Integer, String> getMenstruationFoList() {
        return menstruationFoList;
    }

    public void setMenstruationFoList(Map<Integer, String> menstruationFoList) {
        this.menstruationFoList = menstruationFoList;
    }

    public String getMenstruationFrom() {
        return menstruationFrom;
    }

    public void setMenstruationFrom(String menstruationFrom) {
        this.menstruationFrom = menstruationFrom;
    }

    public String getMenstruationAcross() {
        return menstruationAcross;
    }

    public void setMenstruationAcross(String menstruationAcross) {
        this.menstruationAcross = menstruationAcross;
    }

    public String getMenstruationFo() {
        return menstruationFo;
    }

    public void setMenstruationFo(String menstruationFo) {
        this.menstruationFo = menstruationFo;
    }

    public String getMenstruationStay() {
        return menstruationStay;
    }

    public void setMenstruationStay(String menstruationStay) {
        this.menstruationStay = menstruationStay;
    }

    public Date getLastMaenstruationDate() {
        return lastMaenstruationDate;
    }

    public void setLastMaenstruationDate(Date lastMaenstruationDate) {
        this.lastMaenstruationDate = lastMaenstruationDate;
    }

    public Date getBornedDate() {
        return bornedDate;
    }

    public void setBornedDate(Date bornedDate) {
        this.bornedDate = bornedDate;
    }

    public Date getAbortionDate() {
        return abortionDate;
    }

    public void setAbortionDate(Date abortionDate) {
        this.abortionDate = abortionDate;
    }

    public String getGenitaDiseases() {
        return genitaDiseases;
    }

    public void setGenitaDiseases(String genitaDiseases) {
        this.genitaDiseases = genitaDiseases;
    }

    public String getMammaryGland() {
        return mammaryGland;
    }

    public void setMammaryGland(String mammaryGland) {
        this.mammaryGland = mammaryGland;
    }

    public String getLymphNodes() {
        return lymphNodes;
    }

    public void setLymphNodes(String lymphNodes) {
        this.lymphNodes = lymphNodes;
    }

    public String getGenitalStatus() {
        return genitalStatus;
    }

    public void setGenitalStatus(String genitalStatus) {
        this.genitalStatus = genitalStatus;
    }

    public String getVagina() {
        return vagina;
    }

    public void setVagina(String vagina) {
        this.vagina = vagina;
    }

    public String getUterus1() {
        return uterus1;
    }

    public void setUterus1(String uterus1) {
        this.uterus1 = uterus1;
    }

    public String getUterus2() {
        return uterus2;
    }

    public void setUterus2(String uterus2) {
        this.uterus2 = uterus2;
    }

    public String getUterus3() {
        return uterus3;
    }

    public void setUterus3(String uterus3) {
        this.uterus3 = uterus3;
    }

    public String getLefTadnexa() {
        return lefTadnexa;
    }

    public void setLefTadnexa(String lefTadnexa) {
        this.lefTadnexa = lefTadnexa;
    }

    public String getRighTadnexa() {
        return righTadnexa;
    }

    public void setRighTadnexa(String righTadnexa) {
        this.righTadnexa = righTadnexa;
    }

    public String getVaulting() {
        return vaulting;
    }

    public void setVaulting(String vaulting) {
        this.vaulting = vaulting;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }
    
}
