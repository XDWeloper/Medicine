
package ru.inversionkavkaz.DocMod.Controllers;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;
import ru.inversionkavkaz.DocMod.Entities.HazRezult;
import ru.inversionkavkaz.DocMod.Entities.Hazard;
import ru.inversionkavkaz.DocMod.Entities.Mkb10;
import ru.inversionkavkaz.DocMod.Entities.MkbRezult;
import ru.inversionkavkaz.DocMod.Session.HazRezultFacade;
import ru.inversionkavkaz.DocMod.Session.HazardFacade;
import ru.inversionkavkaz.DocMod.Session.Mkb10Facade;
import ru.inversionkavkaz.DocMod.Session.MkbRezultFacade;

@Named(value = "footerController")
@ViewScoped
public class FooterController implements Serializable{

    private String mkbOpenType;
    private String[] SellectedosmotrRez;
    private String[] SellectedContraindication;
    private String[] SellectedhealthGroup;

    private String recomendation;
    private Set<Mkb10> MkbSellected;
    
    private Set<Mkb10> diagnosMkbSellected;
    private List<Mkb10> sellectedDiagnosRemove;

    private Set<Mkb10> surveyMkbSellected;
    private List<Mkb10> sellectedSurveyRemove;

    private Set<Mkb10> centerSurveyMkbSellected;
    private List<Mkb10> sellectedCenterSurveyRemove;

    private Set<Mkb10> ambulanceTreatmentMkbSellected;
    private List<Mkb10> sellectedAmbulanceTreatmentRemove;

    private Set<Mkb10> sanatoriumTreatmentMkbSellected;
    private List<Mkb10> sellectedSanatoriumTreatmentRemove;

    private Set<Mkb10> holdTreatmentMkbSellected;
    private List<Mkb10> sellectedHoldTreatmentRemove;

    private Set<Mkb10> dispensaryLookingMkbSellected;
    private List<Mkb10> sellectedDispensaryLookingRemove;
    
    private Set<Hazard> hazSellected;
    private List<Hazard> hazSellForRemove;
    
    @EJB  private MkbRezultFacade mkbRezultFacade;
    @EJB  private HazRezultFacade hazRezultFacade;
    @EJB  private Mkb10Facade mkb10Facade;
    @EJB private HazardFacade hazardFacade;
    @Inject DoctorsPagesController doctorController;


    
    public FooterController() {
    }
    
        @PostConstruct void Init(){
        this.MkbSellected   = new HashSet<>();
        this.diagnosMkbSellected = new HashSet<>();
        this.surveyMkbSellected = new HashSet<>();
        this.centerSurveyMkbSellected = new HashSet<>();
        this.ambulanceTreatmentMkbSellected = new HashSet<>();
        this.sanatoriumTreatmentMkbSellected = new HashSet<>();
        this.holdTreatmentMkbSellected = new HashSet<>();
        this.dispensaryLookingMkbSellected = new HashSet<>();
        this.hazSellected = new HashSet<>();
        int rez_id = doctorController.getRez_id();
        if(rez_id != 0) initData(rez_id);
    }
    
    public void lisen(){
    int i = 0;
    }
    
        public void setFooterData(int rezultSeq){
       getDiagnosMkbSellected().stream().forEach(a -> {
            MkbRezult mkbRez = new MkbRezult(rezultSeq, a.getMkbId(),"DiagnosList");
            mkbRezultFacade.create(mkbRez);
        });
       getSurveyMkbSellected().stream().forEach(a -> {
            MkbRezult mkbRez = new MkbRezult(rezultSeq, a.getMkbId(),"Survey");
            mkbRezultFacade.create(mkbRez);
        });
       getCenterSurveyMkbSellected().stream().forEach(a -> {
            MkbRezult mkbRez = new MkbRezult(rezultSeq, a.getMkbId(),"CenterSurvey");
            mkbRezultFacade.create(mkbRez);
        });
       getAmbulanceTreatmentMkbSellected().stream().forEach(a -> {
            MkbRezult mkbRez = new MkbRezult(rezultSeq, a.getMkbId(),"AmbulanceTreatment");
            mkbRezultFacade.create(mkbRez);
        });
       getSanatoriumTreatmentMkbSellected().stream().forEach(a -> {
            MkbRezult mkbRez = new MkbRezult(rezultSeq, a.getMkbId(),"SanatoriumTreatment");
            mkbRezultFacade.create(mkbRez);
        });
       getHoldTreatmentMkbSellected().stream().forEach(a -> {
            MkbRezult mkbRez = new MkbRezult(rezultSeq, a.getMkbId(),"HoldTreatment");
            mkbRezultFacade.create(mkbRez);
        });
       getDispensaryLookingMkbSellected().stream().forEach(a -> {
            MkbRezult mkbRez = new MkbRezult(rezultSeq, a.getMkbId(),"DispensaryLooking");
            mkbRezultFacade.create(mkbRez);
        });
       
       getHazSellected().stream().forEach(a -> {
           HazRezult hazRez = new HazRezult(rezultSeq, a.getHazId());
           hazRezultFacade.create(hazRez);
       });
    }

        public void initData(int rez_id){
        Collection<MkbRezult> findByRezId = mkbRezultFacade.findByRezId(rez_id);
        findByRezId.stream().forEach(a -> {
            switch(a.getMkbRezultPK().getType()){
                case "DiagnosList":
                    getDiagnosMkbSellected().add(mkb10Facade.find(a.getMkbRezultPK().getMkbId()));
                    break;
                case "Survey":
                    getSurveyMkbSellected().add(mkb10Facade.find(a.getMkbRezultPK().getMkbId()));
                    break;
                case "CenterSurvey":
                    getCenterSurveyMkbSellected().add(mkb10Facade.find(a.getMkbRezultPK().getMkbId()));
                    break;
                case "AmbulanceTreatment":
                    getAmbulanceTreatmentMkbSellected().add(mkb10Facade.find(a.getMkbRezultPK().getMkbId()));
                    break;
                case "SanatoriumTreatment":
                    getSanatoriumTreatmentMkbSellected().add(mkb10Facade.find(a.getMkbRezultPK().getMkbId()));
                    break;
                case "HoldTreatment":
                    getHoldTreatmentMkbSellected().add(mkb10Facade.find(a.getMkbRezultPK().getMkbId()));
                    break;
                case "DispensaryLooking":
                    getDispensaryLookingMkbSellected().add(mkb10Facade.find(a.getMkbRezultPK().getMkbId()));
                    break;
            }
         });
        Collection<HazRezult> findByRezId1 = hazRezultFacade.findByRezId(rez_id);
        findByRezId1.stream().forEach(a -> {
            getHazSellected().add(hazardFacade.find(a.getHazRezultPK().getHazId()));
        });
        }
        
        public void setMkbSellected(List<Mkb10> mkbSellected) {
        switch(mkbOpenType) {
            case "diagnosis":
                diagnosMkbSellected.addAll(mkbSellected);
                RequestContext.getCurrentInstance(). update("DocForm:diagnosisField");
                    break;
            case "survey":
                surveyMkbSellected.addAll(mkbSellected);
                RequestContext.getCurrentInstance(). update("DocForm:SurveyField");
                    break;
            case "surveyprof":
                 centerSurveyMkbSellected .addAll(mkbSellected);
                RequestContext.getCurrentInstance(). update("DocForm:upSurveyField");
                    break;
            case "ambulanceTreatment":
                 ambulanceTreatmentMkbSellected.addAll(mkbSellected);
                RequestContext.getCurrentInstance(). update("DocForm:ambulanceTreatmentField");
                    break;
            case "holdTreatment":
                 holdTreatmentMkbSellected.addAll(mkbSellected);
                RequestContext.getCurrentInstance(). update("DocForm:holdTreatmentField");
                    break;
            case "sanatoriumTreatment":
                 sanatoriumTreatmentMkbSellected.addAll(mkbSellected);
                RequestContext.getCurrentInstance(). update("DocForm:sanatoriumTreatmentField");
                    break;
            case "dispensaryLooking":
                 dispensaryLookingMkbSellected.addAll(mkbSellected);
                RequestContext.getCurrentInstance(). update("DocForm:dispensaryLookingField");
                    break;
                    
                    }
        
    }
    
        public void removeDiagnos(){
    if(diagnosMkbSellected != null) diagnosMkbSellected.removeAll(sellectedDiagnosRemove);
    }
    public void removeSurvey(){
    if(surveyMkbSellected != null) surveyMkbSellected.removeAll(sellectedSurveyRemove);
    }
    public void removeCenterSurvey(){
    if(centerSurveyMkbSellected != null) centerSurveyMkbSellected.removeAll(sellectedCenterSurveyRemove);
    }
    public void removeAmbulanceTreatment(){
    if(ambulanceTreatmentMkbSellected != null) ambulanceTreatmentMkbSellected.removeAll(sellectedAmbulanceTreatmentRemove);
    }
    public void removeSanatoriumTreatment(){
    if(sanatoriumTreatmentMkbSellected != null) sanatoriumTreatmentMkbSellected.removeAll(sellectedSanatoriumTreatmentRemove);
    }
    public void removeHoldTreatment(){
    if(holdTreatmentMkbSellected != null) holdTreatmentMkbSellected.removeAll(sellectedHoldTreatmentRemove);
    }
    public void removeDispensaryLooking(){
    if(dispensaryLookingMkbSellected != null) dispensaryLookingMkbSellected.removeAll(sellectedDispensaryLookingRemove);
    }

    public void removeHazard(){
    if(hazSellected != null) hazSellected.removeAll(hazSellForRemove);
    }    
        
        public void setFieldseType(String type){
        mkbOpenType = type;
    }

    public String getMkbOpenType() {
        return mkbOpenType;
    }

    public void setMkbOpenType(String mkbOpenType) {
        this.mkbOpenType = mkbOpenType;
    }

    public String[] getSellectedosmotrRez() {
        return SellectedosmotrRez;
    }

    public void setSellectedosmotrRez(String[] SellectedosmotrRez) {
        this.SellectedosmotrRez = SellectedosmotrRez;
    }

    public String[] getSellectedContraindication() {
        return SellectedContraindication;
    }

    public void setSellectedContraindication(String[] SellectedContraindication) {
        this.SellectedContraindication = SellectedContraindication;
    }

    public String[] getSellectedhealthGroup() {
        return SellectedhealthGroup;
    }

    public void setSellectedhealthGroup(String[] SellectedhealthGroup) {
        this.SellectedhealthGroup = SellectedhealthGroup;
    }

    public String getRecomendation() {
        return recomendation;
    }

    public void setRecomendation(String recomendation) {
        this.recomendation = recomendation;
    }
   
        public Set<Mkb10> getMkbSellected() {
        return MkbSellected;
    }

     public void setMkbSellected(Set<Mkb10> MkbSellected) {
        this.MkbSellected = MkbSellected;
    }

    public Set<Mkb10> getDiagnosMkbSellected() {
        return diagnosMkbSellected;
    }

    public void setDiagnosMkbSellected(Set<Mkb10> diagnosMkbSellected) {
        this.diagnosMkbSellected = diagnosMkbSellected;
    }

    public List<Mkb10> getSellectedDiagnosRemove() {
        return sellectedDiagnosRemove;
    }

    public void setSellectedDiagnosRemove(List<Mkb10> sellectedDiagnosRemove) {
        this.sellectedDiagnosRemove = sellectedDiagnosRemove;
    }

    public Set<Mkb10> getSurveyMkbSellected() {
        return surveyMkbSellected;
    }

    public void setSurveyMkbSellected(Set<Mkb10> surveyMkbSellected) {
        this.surveyMkbSellected = surveyMkbSellected;
    }

    public List<Mkb10> getSellectedSurveyRemove() {
        return sellectedSurveyRemove;
    }

    public void setSellectedSurveyRemove(List<Mkb10> sellectedSurveyRemove) {
        this.sellectedSurveyRemove = sellectedSurveyRemove;
    }

    public Set<Mkb10> getCenterSurveyMkbSellected() {
        return centerSurveyMkbSellected;
    }

    public void setCenterSurveyMkbSellected(Set<Mkb10> centerSurveyMkbSellected) {
        this.centerSurveyMkbSellected = centerSurveyMkbSellected;
    }

    public List<Mkb10> getSellectedCenterSurveyRemove() {
        return sellectedCenterSurveyRemove;
    }

    public void setSellectedCenterSurveyRemove(List<Mkb10> sellectedCenterSurveyRemove) {
        this.sellectedCenterSurveyRemove = sellectedCenterSurveyRemove;
    }

    public Set<Mkb10> getAmbulanceTreatmentMkbSellected() {
        return ambulanceTreatmentMkbSellected;
    }

    public void setAmbulanceTreatmentMkbSellected(Set<Mkb10> ambulanceTreatmentMkbSellected) {
        this.ambulanceTreatmentMkbSellected = ambulanceTreatmentMkbSellected;
    }

    public List<Mkb10> getSellectedAmbulanceTreatmentRemove() {
        return sellectedAmbulanceTreatmentRemove;
    }

    public void setSellectedAmbulanceTreatmentRemove(List<Mkb10> sellectedAmbulanceTreatmentRemove) {
        this.sellectedAmbulanceTreatmentRemove = sellectedAmbulanceTreatmentRemove;
    }

    public Set<Mkb10> getSanatoriumTreatmentMkbSellected() {
        return sanatoriumTreatmentMkbSellected;
    }

    public void setSanatoriumTreatmentMkbSellected(Set<Mkb10> sanatoriumTreatmentMkbSellected) {
        this.sanatoriumTreatmentMkbSellected = sanatoriumTreatmentMkbSellected;
    }

    public List<Mkb10> getSellectedSanatoriumTreatmentRemove() {
        return sellectedSanatoriumTreatmentRemove;
    }

    public void setSellectedSanatoriumTreatmentRemove(List<Mkb10> sellectedSanatoriumTreatmentRemove) {
        this.sellectedSanatoriumTreatmentRemove = sellectedSanatoriumTreatmentRemove;
    }

    public Set<Mkb10> getHoldTreatmentMkbSellected() {
        return holdTreatmentMkbSellected;
    }

    public void setHoldTreatmentMkbSellected(Set<Mkb10> holdTreatmentMkbSellected) {
        this.holdTreatmentMkbSellected = holdTreatmentMkbSellected;
    }

    public List<Mkb10> getSellectedHoldTreatmentRemove() {
        return sellectedHoldTreatmentRemove;
    }

    public void setSellectedHoldTreatmentRemove(List<Mkb10> sellectedHoldTreatmentRemove) {
        this.sellectedHoldTreatmentRemove = sellectedHoldTreatmentRemove;
    }

    public Set<Mkb10> getDispensaryLookingMkbSellected() {
        return dispensaryLookingMkbSellected;
    }

    public void setDispensaryLookingMkbSellected(Set<Mkb10> dispensaryLookingMkbSellected) {
        this.dispensaryLookingMkbSellected = dispensaryLookingMkbSellected;
    }

    public List<Mkb10> getSellectedDispensaryLookingRemove() {
        return sellectedDispensaryLookingRemove;
    }

    public void setSellectedDispensaryLookingRemove(List<Mkb10> sellectedDispensaryLookingRemove) {
        this.sellectedDispensaryLookingRemove = sellectedDispensaryLookingRemove;
    }

    public Set<Hazard> getHazSellected() {
        return hazSellected;
    }

    public void setHazSellected(List<Hazard> hazSellected) {
        this.hazSellected.addAll(hazSellected);
    }

    public List<Hazard> getHazSellForRemove() {
        return hazSellForRemove;
    }

    public void setHazSellForRemove(List<Hazard> hazSellForRemove) {
        this.hazSellForRemove = hazSellForRemove;
    }
    
}
