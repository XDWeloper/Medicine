
package ru.inversionkavkaz.DocMod.Controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import ru.inversionkavkaz.DocMod.Entities.Doctors;
import ru.inversionkavkaz.DocMod.Entities.Reports;
import ru.inversionkavkaz.DocMod.Session.DoctorsFacade;
import ru.inversionkavkaz.DocMod.Session.ReportsFacade;

@Named(value = "counterController")
@SessionScoped
public class CounterController implements Serializable{

    @EJB private DoctorsFacade doctorsFacade;
    @EJB private ReportsFacade reportsFacade;
    @Inject private LoginController loginController;
    
    private Doctors doctor;
    private String docName;
    private List<Reports> reportList;
    private Reports sellectedReport;
    private List<Doctors> doctorsList;
    private Doctors sellectedDoctors;
    private boolean doctorListCollapse;
    
    public CounterController() {
    }

    @PostConstruct public void Init() {
        doctor = loginController.getDoctor();
        docName = doctor.getLastname() + " " + doctor.getFirstname() + " " + doctor.getMiddlename();
        reportList = reportsFacade.findAll();
        doctorsList = doctorsFacade.findAll();
        doctorListCollapse = true;
    }
    
    public void onReportSelect() throws IOException{
    int i = 0;
//    doctorListCollapse = false;
//    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//    ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());     
    }

    public void onDoctorSelect(){
    int i = 0;
    }
    
    
    
    public String logout(){
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            return "exit";
    }
    public String getDocName() {
        return docName;
    }

    public List<Reports> getReportList() {
        return reportList;
    }

    public void setSellectedReport(Reports sellectedReport) {
        this.sellectedReport = sellectedReport;
    }

    public Reports getSellectedReport() {
        return sellectedReport;
    }

    public List<Doctors> getDoctorsList() {
        return doctorsList;
    }

    public Doctors getSellectedDoctors() {
        return sellectedDoctors;
    }

    public void setSellectedDoctors(Doctors sellectedDoctors) {
        this.sellectedDoctors = sellectedDoctors;
    }

    public boolean isDoctorListCollapse() {
        return doctorListCollapse;
    }

    
}
