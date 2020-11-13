
package ru.inversionkavkaz.DocMod.Controllers;

import java.io.Serializable;
import java.util.Date;
import javax.inject.Named;
import javax.faces.view.ViewScoped;


@Named(value = "neurologistController")
@ViewScoped

public class NeurologistController implements Serializable{
    private Date today;
    private String complaints;
    private String history;
    private String neurologicalStatus;
    private String dryReflectionStatus;
    private String upperLimbReflection;
    private String kneeReflection;
    private String achilessReflection;
    private String rombergPosition;
    private String patologicalSign;
    private String pnp;
    private String lordoz;
    private String[] lumbarSubvision1;
    private String[] lumbarSubvision2;
    private String lumbarSubvisionField1;
    private String lumbarSubvisionField2;
    private String[] brush1;
    private String[] brush2;
    private String brushField1;
    private String brushField2;
    private String sensitivity;
    private String[] sensitivityCheck;
    private String c128;
    
    
    
    
    public NeurologistController() {
    }
    
    public void save(){
        int i = 0;
    }
    
    public String[] getBrush1() {
        return brush1;
    }

    public void setBrush1(String[] brush1) {
        this.brush1 = brush1;
    }

    public String[] getBrush2() {
        return brush2;
    }

    public void setBrush2(String[] brush2) {
        this.brush2 = brush2;
    }

    public String getBrushField1() {
        return brushField1;
    }

    public void setBrushField1(String brushField1) {
        this.brushField1 = brushField1;
    }


    public String getBrushField2() {
        return brushField2;
    }

    public void setBrushField2(String brushField2) {
        this.brushField2 = brushField2;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
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

    public String getC128() {
        return c128;
    }

    public void setC128(String c128) {
        this.c128 = c128;
    }

    public String getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(String sensitivity) {
        this.sensitivity = sensitivity;
    }

    public String[] getSensitivityCheck() {
        return sensitivityCheck;
    }

    public void setSensitivityCheck(String[] sensitivityCheck) {
        this.sensitivityCheck = sensitivityCheck;
    }

    public String getLumbarSubvisionField2() {
        return lumbarSubvisionField2;
    }

    public void setLumbarSubvisionField2(String lumbarSubvisionField2) {
        this.lumbarSubvisionField2 = lumbarSubvisionField2;
    }

    public String[] getLumbarSubvision2() {
        return lumbarSubvision2;
    }

    public void setLumbarSubvision2(String[] lumbarSubvision2) {
        this.lumbarSubvision2 = lumbarSubvision2;
    }

    public String getLumbarSubvisionField1() {
        return lumbarSubvisionField1;
    }

    public void setLumbarSubvisionField1(String lumbarSubvisionField) {
        this.lumbarSubvisionField1 = lumbarSubvisionField;
    }

    public String[] getLumbarSubvision1() {
        return lumbarSubvision1;
    }

    public void setLumbarSubvision1(String[] lumbarSubvision) {
        this.lumbarSubvision1 = lumbarSubvision;
    }

    public String getLordoz() {
        return lordoz;
    }

    public void setLordoz(String lordoz) {
        this.lordoz = lordoz;
    }

    public String getPnp() {
        return pnp;
    }

    public void setPnp(String pnp) {
        this.pnp = pnp;
    }

    public String getPatologicalSign() {
        return patologicalSign;
    }

    public void setPatologicalSign(String patologicalSign) {
        this.patologicalSign = patologicalSign;
    }

    public String getRombergPosition() {
        return rombergPosition;
    }

    public void setRombergPosition(String rombergPosition) {
        this.rombergPosition = rombergPosition;
    }

    public void lisener(){
    int i = 0;
    i=1;
    }
    
    public String getKneeReflection() {
        return kneeReflection;
    }

    public void setKneeReflection(String kneeReflection) {
        this.kneeReflection = kneeReflection;
    }

    public String getAchilessReflection() {
        return achilessReflection;
    }

    public void setAchilessReflection(String achilessReflection) {
        this.achilessReflection = achilessReflection;
    }

    public String getDryReflectionStatus() {
        return dryReflectionStatus;
    }

    public void setDryReflectionStatus(String dryReflectionStatus) {
        this.dryReflectionStatus = dryReflectionStatus;
    }

    public String getUpperLimbReflection() {
        return upperLimbReflection;
    }

    public void setUpperLimbReflection(String upperLimbReflection) {
        this.upperLimbReflection = upperLimbReflection;
    }

    public String getNeurologicalStatus() {
        return neurologicalStatus;
    }

    public void setNeurologicalStatus(String neurologicalStatus) {
        this.neurologicalStatus = neurologicalStatus;
    }

}
