package ru.inversionkavkaz.DocMod.Controllers;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import ru.inversionkavkaz.DocMod.Entities.DocSpec;
import ru.inversionkavkaz.DocMod.Interfaces.IDocController;
import ru.inversionkavkaz.DocMod.Session.HtmlPagesFacade;
import ru.inversionkavkaz.DocMod.tools.Messages;


@Named(value = "doctorsPagesController")
@SessionScoped
public class DoctorsPagesController implements Serializable{

    @EJB private HtmlPagesFacade htmlPagesFacade;
    
    @Inject TerapevtController terapevt;
    @Inject NeurologistController neurolog;
    @Inject OtolaryngologistController otorinolaringologist;
    @Inject GynecologistController gynecologist;
    @Inject SurgeonController surgeon;
    @Inject OphthalmologistController ophthalmologist;
    @Inject DermatovenerologController dermatovenerolog;
    @Inject PsychiatristController psychiatrist;
    @Inject NarcologyController narcology;
    @Inject DentistController dentist;
    
    
    @Inject IndexController indexController;
    private String htmlPageFileName;
    private String openType;
    private int rez_id;
    private IDocController docController;
    
    public DoctorsPagesController() {
    }

    public void openRezultView(String type,DocSpec selectSpec,int rez_id){
        Map<String,Object> options = new HashMap<>();
        options.put("modal", true);
        options.put("width", 1000);
        options.put("height", 700);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        options.put("maximizable", true);
        this.openType = type;
        this.rez_id = rez_id;

        htmlPageFileName = htmlPagesFacade.find(selectSpec.getHtmlPageId()) != null ? htmlPagesFacade.find(selectSpec.getHtmlPageId()).getHtmlPageFileName(): "";
        if(htmlPageFileName.isEmpty())   Messages.showMessage("Для врача данной специальности нет соответствующей страницы \n  обратитесь к администратору системы или разработчику! ", FacesMessage.SEVERITY_ERROR);
        else RequestContext.getCurrentInstance().openDialog("Pages/DoctorsPagesView/" + htmlPageFileName ,options,null);
    }
    
    public void exit(String type) throws SQLException{
        
        if(type.equals("save")) docController.save();
        RequestContext.getCurrentInstance().closeDialog("Pages/DoctorsPagesView/"+htmlPageFileName);
        
//        switch(specname.trim()){
//            case "терапевт":
//                if(type.equals("save")) terapevt.save();
//                RequestContext.getCurrentInstance().closeDialog("Pages/DoctorsPagesView/THERAPIST");
//                break;
//            case "невролог":
//                if(type.equals("save"))neurolog.save();
//                RequestContext.getCurrentInstance().closeDialog("Pages/DoctorsPagesView/NEUROLOGIST");
//                break;
//            case "оториноларинголог":
//                if(type.equals("save"))otorinolaringologist.save();
//                RequestContext.getCurrentInstance().closeDialog("Pages/DoctorsPagesView/OTORINOLARINGOLOGIST");
//                break;
//            case "акушер-гинеколог":
//                if(type.equals("save"))gynecologist.save();
//                RequestContext.getCurrentInstance().closeDialog("Pages/DoctorsPagesView/GINECOLOGIST");
//                break;
//            case "гинеколог":
//                if(type.equals("save"))gynecologist.save();
//                RequestContext.getCurrentInstance().closeDialog("Pages/DoctorsPagesView/GINECOLOGIST");
//                break;
//            case "хирург":
//                if(type.equals("save"))surgeon.save();
//                RequestContext.getCurrentInstance().closeDialog("Pages/DoctorsPagesView/SURGEON");
//                break;
//            case "офтальмолог":
//                if(type.equals("save"))ophthalmologist.save();
//                RequestContext.getCurrentInstance().closeDialog("Pages/DoctorsPagesView/OPHTHALMOLOGIST");
//                break;
//            case "дерматовенеролог":
//                if(type.equals("save"))dermatovenerolog.save();
//                RequestContext.getCurrentInstance().closeDialog("Pages/DoctorsPagesView/DERMATIVENEROLOG");
//                break;
//            case "психиатр":
//                if(type.equals("save"))dermatovenerolog.save();
//                RequestContext.getCurrentInstance().closeDialog("Pages/DoctorsPagesView/PSYCHIATRIST");
//                break;
//            case "психиатр-нарколог":
//                if(type.equals("save"))narcology.save();
//                RequestContext.getCurrentInstance().closeDialog("Pages/DoctorsPagesView/NARCOLOGY");
//                break;
//            case "нарколог":
//                if(type.equals("save"))narcology.save();
//                RequestContext.getCurrentInstance().closeDialog("Pages/DoctorsPagesView/NARCOLOGY");
//                break;
//            case "стоматолог":
//                if(type.equals("save"))dentist.save();
//                RequestContext.getCurrentInstance().closeDialog("Pages/DoctorsPagesView/DENTIST");
//                break;
//        }
    }

    public void setDocController(IDocController docController){
        this.docController = docController;
    }
    
    public String getOpenType() {
        return openType;
    }

    public int getRez_id() {
        return rez_id;
    }
    
}
