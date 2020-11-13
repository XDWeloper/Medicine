
package ru.inversionkavkaz.DocMod.Controllers;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "ophthalmologistController")
@ViewScoped
public class OphthalmologistController implements Serializable{

    public OphthalmologistController() {}

    private String complaints;
    private String visus_OD;
    private String visus_OS;
    private String vgd_OD;
    private String vgd_OS;
    private String natureViewField;
    private String[] natureView;
    private String colorPerception;
    private String sight;
    private String siascopy;
    private String anteriorSegment_OS;
    private String anteriorSegment_OD;
    private String lens_OS;
    private String lens_OD;
    private String ocularFundus_OS;
    private String ocularFundus_OD;
    
    
    public void lisener(){}
     
    public void save(){}

    public String getSiascopy() {
        return siascopy;
    }

    public void setSiascopy(String siascopy) {
        this.siascopy = siascopy;
    }

    public String getComplaints() {
        return complaints;
    }

    public void setComplaints(String complaints) {
        this.complaints = complaints;
    }

    public String getVisus_OD() {
        return visus_OD;
    }

    public void setVisus_OD(String visus_OD) {
        this.visus_OD = visus_OD;
    }

    public String getVisus_OS() {
        return visus_OS;
    }

    public void setVisus_OS(String visus_OS) {
        this.visus_OS = visus_OS;
    }

    public String getVgd_OD() {
        return vgd_OD;
    }

    public void setVgd_OD(String vgd_OD) {
        this.vgd_OD = vgd_OD;
    }

    public String getVgd_OS() {
        return vgd_OS;
    }

    public void setVgd_OS(String vgd_OS) {
        this.vgd_OS = vgd_OS;
    }

    public String getNatureViewField() {
        return natureViewField;
    }

    public void setNatureViewField(String natureViewField) {
        this.natureViewField = natureViewField;
    }

    public String[] getNatureView() {
        return natureView;
    }

    public void setNatureView(String[] natureView) {
        this.natureView = natureView;
    }

    public String getColorPerception() {
        return colorPerception;
    }

    public void setColorPerception(String colorPerception) {
        this.colorPerception = colorPerception;
    }

    public String getSight() {
        return sight;
    }

    public void setSight(String sight) {
        this.sight = sight;
    }

    public String getAnteriorSegment_OS() {
        return anteriorSegment_OS;
    }

    public void setAnteriorSegment_OS(String anteriorSegment_OS) {
        this.anteriorSegment_OS = anteriorSegment_OS;
    }

    public String getAnteriorSegment_OD() {
        return anteriorSegment_OD;
    }

    public void setAnteriorSegment_OD(String anteriorSegment_OD) {
        this.anteriorSegment_OD = anteriorSegment_OD;
    }

    public String getLens_OS() {
        return lens_OS;
    }

    public void setLens_OS(String lens_OS) {
        this.lens_OS = lens_OS;
    }

    public String getLens_OD() {
        return lens_OD;
    }

    public void setLens_OD(String lens_OD) {
        this.lens_OD = lens_OD;
    }

    public String getOcularFundus_OS() {
        return ocularFundus_OS;
    }

    public void setOcularFundus_OS(String ocularFundus_OS) {
        this.ocularFundus_OS = ocularFundus_OS;
    }

    public String getOcularFundus_OD() {
        return ocularFundus_OD;
    }

    public void setOcularFundus_OD(String ocularFundus_OD) {
        this.ocularFundus_OD = ocularFundus_OD;
    }

    
}
