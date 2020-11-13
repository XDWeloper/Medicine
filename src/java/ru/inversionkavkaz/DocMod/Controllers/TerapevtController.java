package ru.inversionkavkaz.DocMod.Controllers;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ru.inversionkavkaz.DocMod.Entities.PersonsRezults;
import ru.inversionkavkaz.DocMod.Interfaces.IDocController;
import ru.inversionkavkaz.DocMod.Session.PersonsRezultsFacade;
import ru.inversionkavkaz.DocMod.tools.Today;

@Named(value = "terapevtController")
@ViewScoped

public class TerapevtController  implements Serializable,IDocController{

    @EJB  private PersonsRezultsFacade personsRezultsFacade;
    
    @Inject IndexController indexController;
    @Inject FooterController footerController;
    @Inject DoctorsPagesController doctorController;
    
    private int person_id;
    private int doctor_id;
    private int spec_id;
    
    private Date today;
    private String complaints;
    private String history;
    private boolean openTogle;
    private String mkbOpenType;
    private String doctor;
    
    private String[] selectedSkinIntegument;
    private String   skinIntegument;
    
    private String[] selectedlymphNodes;
    private String   lymphNodes;

    private String[] selectedthyroidGland;
    private String   thyroidGland;

    private String[] selectedwheezing;
    private String   wheezing;
    private String[] selectedwheezing1;
    private String[] selectedwheezing2;

    private String[] selectedbrife;
        
    private String[] selectedheartTones;
    private String   heartTones;

    private String[] selectedarterPuls;
    private String   arterPuls;
    private String chss;
    private String arteryOpress;
    
    private String[] selectedLang;
    private String  lang;

    private String[] selectedLiver;
    private String  liver;
    
    private String[] selectedBelly;
    private String  belly;

    private String[] selectedSpleen;
    private String  spleen;

    private String[] selectedKidney;
    private String  kidney;

    private String[] selectedPerefOtek;
    private String  perefOtek;
    
    int rezultSeq;
    PersonsRezults editRezult;
    
  
    
    public TerapevtController() {
    }
    @PostConstruct void Init(){
        openTogle = true;
        if(!doctorController.getOpenType().equalsIgnoreCase("adminView")){
            person_id = indexController.getSellectedPersonId();
            doctor_id = indexController.getDoctor().getIddoctor().intValue();
            spec_id = indexController.getSelectSpec().getIdspec().getIdspec();
        if(!doctorController.getOpenType().equalsIgnoreCase("new")) initData();
        }
        doctorController.setDocController(this);
    }
    
    
    public String completeComplaintsArea(String query) {
        this.complaints += query;
        return complaints;
    }    

    public String completeHistoryArea(String query) {
        this.history += query;
        return history;
    }    
    
    @Override public void save() {
        PersonsRezults newRezult =  editRezult;
        if(doctorController.getOpenType().equalsIgnoreCase("new")) {
            try {
                rezultSeq = ru.inversionkavkaz.DocMod.tools.Connection.getSeq("select nextval('ikmed.result_seq')");
                newRezult = new PersonsRezults(rezultSeq);
            } catch (SQLException ex) {
                Logger.getLogger(TerapevtController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        newRezult.setPersonId(person_id);
        newRezult.setDoctorId(doctor_id);
        newRezult.setSpecId(spec_id);
        newRezult.setArterPuls(arterPuls);
        newRezult.setArteryOpress(arteryOpress);
        newRezult.setBelly(belly);
        newRezult.setChss(chss);
        newRezult.setComplaints(complaints);
        newRezult.setHeartTones(heartTones);
        newRezult.setHistory(history);
        newRezult.setKidney(kidney);
        newRezult.setLang(lang);
        newRezult.setLiver(liver);
        newRezult.setLymphNodes(lymphNodes);
        newRezult.setPerefOtek(perefOtek);
        newRezult.setRecomendation(footerController.getRecomendation());
        newRezult.setRezDate(today);

        newRezult.setSelectedBelly(Arrays.toString(selectedBelly));
        newRezult.setSelectedKidney(Arrays.toString(selectedKidney));
        newRezult.setSelectedLang(Arrays.toString(selectedLang));
        newRezult.setSelectedLiver(Arrays.toString(selectedLiver));
        newRezult.setSelectedPerefOtek(Arrays.toString(selectedPerefOtek));
        newRezult.setSelectedSkinIntegument(Arrays.toString(selectedSkinIntegument));
        newRezult.setSelectedSpleen(Arrays.toString(selectedSpleen));
        newRezult.setSelectedarterPuls(Arrays.toString(selectedarterPuls));
        newRezult.setSelectedbrife(Arrays.toString(selectedbrife));
        newRezult.setSelectedheartTones(Arrays.toString(selectedheartTones));
        newRezult.setSelectedlymphNodes(Arrays.toString(selectedlymphNodes));
        newRezult.setSelectedthyroidGland(Arrays.toString(selectedthyroidGland));
        newRezult.setSelectedwheezing(Arrays.toString(selectedwheezing));
        newRezult.setSelectedwheezing1(Arrays.toString(selectedwheezing1));
        newRezult.setSelectedwheezing2(Arrays.toString(selectedwheezing2));
        
        newRezult.setSellectedContraindication(Arrays.toString(footerController.getSellectedContraindication()));
        newRezult.setSellectedhealthGroup(Arrays.toString(footerController.getSellectedhealthGroup()));
        newRezult.setSellectedosmotrRez(Arrays.toString(footerController.getSellectedosmotrRez()));
        if(doctorController.getOpenType().equalsIgnoreCase("new")) 
            personsRezultsFacade.create(newRezult);
        if(doctorController.getOpenType().equalsIgnoreCase("edit")) 
            personsRezultsFacade.edit(newRezult);
        
        footerController.setFooterData(rezultSeq);
    }
    
    
    private void initData(){
        rezultSeq = doctorController.getRez_id();
        editRezult= personsRezultsFacade.find(rezultSeq);
        PersonsRezults personResult = editRezult;

        person_id = personResult.getPersonId();
        doctor_id = personResult.getDoctorId();
        spec_id = personResult.getSpecId();
        arterPuls = personResult.getArterPuls();
        arteryOpress = personResult.getArteryOpress();
        belly = personResult.getBelly();
        chss = personResult.getChss();
        complaints = personResult.getComplaints();
        heartTones = personResult.getHeartTones();
        history = personResult.getHistory();
        kidney = personResult.getKidney();
        lang = personResult.getLang();
        liver = personResult.getLiver();
        lymphNodes = personResult.getLymphNodes();
        perefOtek = personResult.getPerefOtek();
        today = personResult.getRezDate();

        selectedBelly = personResult.getSelectedBelly().substring(1, personResult.getSelectedBelly().length()-1).split(",");
        selectedKidney = personResult.getSelectedKidney().substring(1, personResult.getSelectedKidney().length()-1).split(",");
        selectedLang = personResult.getSelectedLang().substring(1, personResult.getSelectedLang().length()-1).split(",");
        selectedLiver = personResult.getSelectedLiver().substring(1, personResult.getSelectedLiver().length()-1).split(",");
        selectedPerefOtek = personResult.getSelectedPerefOtek().substring(1, personResult.getSelectedPerefOtek().length()-1).split(",");
        selectedSkinIntegument = personResult.getSelectedSkinIntegument().substring(1, personResult.getSelectedSkinIntegument().length()-1).split(",");
        selectedSpleen = personResult.getSelectedSpleen().substring(1, personResult.getSelectedSpleen().length()-1).split(",");
        selectedarterPuls = personResult.getSelectedarterPuls().substring(1, personResult.getSelectedarterPuls().length()-1).split(",");
        selectedbrife = personResult.getSelectedbrife().substring(1, personResult.getSelectedbrife().length()-1).split(",");
        selectedheartTones = personResult.getSelectedheartTones().substring(1, personResult.getSelectedheartTones().length()-1).split(",");
        selectedlymphNodes = personResult.getSelectedlymphNodes().substring(1, personResult.getSelectedlymphNodes().length()-1).split(",");
        selectedthyroidGland = personResult.getSelectedthyroidGland().substring(1, personResult.getSelectedthyroidGland().length()-1).split(",");
        selectedwheezing = personResult.getSelectedwheezing().substring(1, personResult.getSelectedwheezing().length()-1).split(",");
        selectedwheezing1 = personResult.getSelectedwheezing1().substring(1, personResult.getSelectedwheezing1().length()-1).split(",");
        selectedwheezing2 = personResult.getSelectedwheezing2().substring(1, personResult.getSelectedwheezing2().length()-1).split(",");
        
        footerController.setRecomendation(personResult.getRecomendation());
        footerController.setSellectedContraindication(personResult.getSellectedContraindication().substring(1, personResult.getSellectedContraindication().length()-1).split(","));
        footerController.setSellectedhealthGroup(personResult.getSellectedhealthGroup().substring(1, personResult.getSellectedhealthGroup().length()-1).split(","));
        footerController.setSellectedosmotrRez(personResult.getSellectedosmotrRez().substring(1, personResult.getSellectedosmotrRez().length()-1).split(","));
        
        footerController.initData(rezultSeq);
        }
    
    public void lisen(){
    int i = 0;
    }
    
    public void changeTogle(){
        int i = 0;
    }

    public boolean isOpenTogle() {
        return openTogle;
    }

    public void setOpenTogle(boolean openTogle) {
        this.openTogle = openTogle;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String[] getSelectedKidney() {
        return selectedKidney;
    }

    public void setSelectedKidney(String[] selectedKidney) {
        this.selectedKidney = selectedKidney;
    }

    public String getKidney() {
        return kidney;
    }

    public void setKidney(String kidney) {
        this.kidney = kidney;
    }

    public String[] getSelectedPerefOtek() {
        return selectedPerefOtek;
    }

    public void setSelectedPerefOtek(String[] selectedPerefOtek) {
        this.selectedPerefOtek = selectedPerefOtek;
    }

    public String getPerefOtek() {
        return perefOtek;
    }

    public void setPerefOtek(String perefOtek) {
        this.perefOtek = perefOtek;
    }
    
    public void setFieldseType(String type){
    mkbOpenType = type;
    }
    
  
    public String[] getSelectedheartTones() {
        return selectedheartTones;
    }

    public void setSelectedheartTones(String[] selectedheartTones) {
        this.selectedheartTones = selectedheartTones;
    }

    public String getHeartTones() {
        return heartTones;
    }

    public void setHeartTones(String heartTones) {
        this.heartTones = heartTones;
    }

    public String[] getSelectedarterPuls() {
        return selectedarterPuls;
    }

    public void setSelectedarterPuls(String[] selectedarterPuls) {
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

    public String[] getSelectedLang() {
        return selectedLang;
    }

    public void setSelectedLang(String[] selectedLang) {
        this.selectedLang = selectedLang;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String[] getSelectedLiver() {
        return selectedLiver;
    }

    public void setSelectedLiver(String[] selectedLiver) {
        this.selectedLiver = selectedLiver;
    }

    public String getLiver() {
        return liver;
    }

    public void setLiver(String liver) {
        this.liver = liver;
    }

    public String[] getSelectedBelly() {
        return selectedBelly;
    }

    public void setSelectedBelly(String[] selectedBelly) {
        this.selectedBelly = selectedBelly;
    }

    public String getBelly() {
        return belly;
    }

    public void setBelly(String belly) {
        this.belly = belly;
    }

    public String[] getSelectedSpleen() {
        return selectedSpleen;
    }

    public void setSelectedSpleen(String[] selectedSpleen) {
        this.selectedSpleen = selectedSpleen;
    }

    public String getSpleen() {
        return spleen;
    }

    public void setSpleen(String spleen) {
        this.spleen = spleen;
    }

    
    
    
    public String[] getSelectedwheezing1() {
        return selectedwheezing1;
    }

    public void setSelectedwheezing1(String[] selectedwheezing1) {
        this.selectedwheezing1 = selectedwheezing1;
    }

    public String[] getSelectedwheezing2() {
        return selectedwheezing2;
    }

    public void setSelectedwheezing2(String[] selectedwheezing2) {
        this.selectedwheezing2 = selectedwheezing2;
    }

    public String[] getSelectedbrife() {
        return selectedbrife;
    }

    public void setSelectedbrife(String[] selectedbrife) {
        this.selectedbrife = selectedbrife;
    }

    public String[] getSelectedwheezing() {
        return selectedwheezing;
    }

    public void setSelectedwheezing(String[] selectedwheezing) {
        this.selectedwheezing = selectedwheezing;
    }

    public String getWheezing() {
        return wheezing;
    }

    public void setWheezing(String wheezing) {
        this.wheezing = wheezing;
    }

    
    public String getSkinIntegument() {
        return skinIntegument;
    }

    public void setSkinIntegument(String skinIntegument) {
        this.skinIntegument = skinIntegument;
    }

    public String[] getSelectedlymphNodes() {
        return selectedlymphNodes;
    }

    public void setSelectedlymphNodes(String[] selectedlymphNodes) {
        this.selectedlymphNodes = selectedlymphNodes;
    }

    public String getLymphNodes() {
        return lymphNodes;
    }

    public void setLymphNodes(String lymphNodes) {
        this.lymphNodes = lymphNodes;
    }

    public String[] getSelectedthyroidGland() {
        return selectedthyroidGland;
    }

    public void setSelectedthyroidGland(String[] selectedthyroidGland) {
        this.selectedthyroidGland = selectedthyroidGland;
    }

    public String getThyroidGland() {
        return thyroidGland;
    }

    public void setThyroidGland(String thyroidGland) {
        this.thyroidGland = thyroidGland;
    }


    
    public void setSelectedSkinIntegument(String[] selectedSkinIntegument) {
        this.selectedSkinIntegument = selectedSkinIntegument;}
    public String[] getSelectedSkinIntegument() {
        return selectedSkinIntegument;}

    public String getComplaints() {return complaints;}
    public void setComplaints(String complaints) {this.complaints = complaints;}
    public String getHistory() {return history;}
    public void setHistory(String history) {this.history = history;}

    
    
    public String getToday() throws ParseException {
        if(today == null)
            today = Today.getToday();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(today);
    }
   
    
}
