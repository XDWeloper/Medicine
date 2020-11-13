
package ru.inversionkavkaz.DocMod.Controllers;

import java.io.Serializable;
import static java.lang.Thread.sleep;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.primefaces.event.SelectEvent;
import ru.inversionkavkaz.DocMod.Entities.DocSpec;
import ru.inversionkavkaz.DocMod.Entities.Doctors;
import ru.inversionkavkaz.DocMod.Entities.Persons;
import ru.inversionkavkaz.DocMod.Interfaces.Ievent;
import ru.inversionkavkaz.DocMod.Session.PersonsFacade;
import ru.inversionkavkaz.DocMod.tools.SessionTimer;
import ru.inversionkavkaz.DocMod.tools.Today;

/**
 *
 * @author Dmitry
 */
@Named(value = "indexController")
@SessionScoped

public class IndexController implements Serializable,Ievent{

    @EJB private PersonsFacade personsFacade;
    @Inject private LoginController loginController;
    @Inject private CalController  calendarController;
    @Inject private SessionTimer sessionTimer;
    
    private Doctors doctor;
    private String docName;
    private  Connection conn;
    private final   List<PriemPersonProp>  itemsList;
    private Date priemDate;
    private long doctor_id;
    private int spec_id;
    private PriemPersonProp selectedPersonProp;
    private String SQL;
    private int sellectedPersonId;
    private int hour;
    private int min;
    private int time;
    private int  sec;
    private Persons selectPerson;
    private String age;
    private String stag;
    private List<DocSpec> specList;
    private DocSpec selectSpec;
    private DocSpecConverter docConverter;
    private boolean sessionConnect;
    private  HttpSession session;

    public IndexController() throws SQLException {
        this.itemsList = new ArrayList<>();

    }
    
    @PostConstruct public void Init() {
        doctor = loginController.getDoctor();
        doctor_id = doctor.getIddoctor();
        docName = doctor.getLastname() + " " + doctor.getFirstname() + " " + doctor.getMiddlename();
        setTime();
        specList = (List<DocSpec>) doctor.getDocSpecCollection();
        if(!specList.isEmpty()){
            spec_id = specList.get(0).getIdspec().getIdspec();
            selectSpec = specList.get(0);
        }
        docConverter = new DocSpecConverter();
            try {
        if(conn == null || conn.isClosed())  conn = ru.inversionkavkaz.DocMod.tools.Connection.ConnectDB();
        } catch (SQLException ex) {
            Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
        }
        sessionTimer.setEventLisener(this);
        
    }

    @PreDestroy void Dectroy(){
        sessionTimer.removeIndexController(this);
        System.out.println("Timer event: " + new Date() +  " @PreDestroy : " + this);

    }
    
    public DocSpec getSelectSpec() {return selectSpec;}

    public void setSelectSpec(DocSpec selectSpec) {this.selectSpec = selectSpec;}

    public void onChangeSpec(){
        spec_id =selectSpec.getIdspec().getIdspec();
        ClearPerson();
    }

    public List<DocSpec> getSpecList() {return specList;}
    
    public int getSellectedPersonId() {return sellectedPersonId;}
    
    public void setPriemList() throws SQLException{
        itemsList.clear();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        SQL = "select common_table_rowset.*,concat(lpad(start_hour::text, 2, '0'),\n" +
                    "':',lpad(start_min::text,2,'0'),' - ',lpad(end_hour::text,2,'0'),':',lpad(end_min::text,2,'0')) as time,\n" +
                    "concat(lastname,' ',firstname,' ',middlename) as PersonName\n" +
                    "from ikmed.get_common_table_rowset(to_date('" + format.format(priemDate) + "','DD.MM.YYYY')," + spec_id + "," +  doctor_id + ") common_table_rowset\n" +
                    "left join ikmed.persons on idperson = person_id order by start_hour,start_min";
        ResultSet rs = conn.createStatement().executeQuery(SQL);
        while(rs.next()){
            itemsList.add( new PriemPersonProp(rs.getString("time"), rs.getString("personname"), rs.getInt("person_id"), rs.getInt("doctor_id"), rs.getInt("start_hour"),
            rs.getInt("end_hour"),rs.getInt("start_min"),rs.getInt("end_min")));
        }
        sessionConnect = true;
        session =  (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        sessionTimer.setEventLisener(this);
    }
    
   
    public List<PriemPersonProp> getItemsList() throws SQLException {
        priemDate = calendarController.getDate();
        setPriemList();
        return itemsList;
    }

    public void onRowSelect(SelectEvent event) throws ParseException {
         sellectedPersonId = ((PriemPersonProp)event.getObject()).getPerson_id();
         if(sellectedPersonId == 0) {
             ClearPerson();
             return;
         }
         selectPerson = GetPerson(sellectedPersonId);
         java.util.Date c1 = Today.getToday();
         java.util.Date c2 = selectPerson.getBornData();
         age =  c2!= null ? "" + (Math.abs(getYearsBetweenDates(c1, c2))-1):"Не установленна дата рождения пациента!";
         c2 = selectPerson.getStagStart();
         stag = c2!= null ? "" + (Math.abs(getYearsBetweenDates(c1, c2))-1):"Не установленна дата рождения пациента!";
     }
    
    private void ClearPerson(){
        selectPerson = null;
        age = "";
        stag = "";
    }

    public PriemPersonProp getSelectedPersonProp() {return selectedPersonProp;}
    
    public void setSelectedPersonProp(PriemPersonProp selectedPersonProp) {this.selectedPersonProp = selectedPersonProp;}
    
    public void setTime(){
        Calendar now = Calendar.getInstance();
        hour = now.get(Calendar.HOUR_OF_DAY);
        min = now.get(Calendar.MINUTE);
        sec = now.get(Calendar.SECOND);
        time = hour * 60 + min;
   }  
    
    public int getTime() {return time;}
   
    public String logout(){
            sessionTimer.removeIndexController(this);
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            return "exit";
    }
            
    public String getDocName() {return docName;}
    

    public Persons getSelectPerson() {
        return selectPerson;
    }
    
    public int getYearsBetweenDates(java.util.Date first, java.util.Date second) {
        Calendar firstCal = GregorianCalendar.getInstance();
        Calendar secondCal = GregorianCalendar.getInstance();
        firstCal.setTime(first);
        secondCal.setTime(second);
        secondCal.add(Calendar.DAY_OF_YEAR, -firstCal.get(Calendar.DAY_OF_YEAR));
        return secondCal.get(Calendar.YEAR) - firstCal.get(Calendar.YEAR);
}
    

    public String getAge() {return age;}

    public String getStag() {return stag;}
        
    private Persons GetPerson(long personId){
        Persons pers = personsFacade.find(BigDecimal.valueOf(personId));
        return pers != null ? pers: null;
    }

    public DocSpecConverter getDocConverter() {
        return docConverter;
    }
    
    public void OnTabChange(){
    int i = 0;
    }

    public void OnTabShow(){
    int i = 0;
    }

    public Doctors getDoctor() {
        return doctor;
    }

    @Override public boolean event() {
        if(!sessionConnect){
            session.setAttribute("login", null);
            return false;
        }
        sessionConnect = false;    
        return true;
    }
    
    public  class PriemPersonProp {
    
        public String time;
        public String personName;
        public int person_id;
        public int doctor_id;
        public int start_hour;
        public int end_hour;
        public int start_min;
        public int end_min;

        public PriemPersonProp(String time, String personName, int person_id, int doctor_id, int start_hour, int end_hour, int start_min, int end_min) {
            this.time = time;
            this.personName = personName;
            this.person_id = person_id;
            this.doctor_id = doctor_id;
            this.start_hour = start_hour;
            this.end_hour = end_hour;
            this.start_min = start_min;
            this.end_min = end_min;
        }
        
        public String getTime() {return time;}
        public String getPersonName() {return personName;}
        public int getPerson_id() {return  person_id;}
        public int getDoctor_id() {return  doctor_id;}

        public int getStart_hour() {return start_hour;}
        public int getEnd_hour() {return end_hour;}
        public int getStart_min() {return start_min;}
        public int getEnd_min() {return end_min;}
    }

    public  class DocSpecConverter implements Converter{

        @Override public Object getAsObject(FacesContext context, UIComponent component, String value) {
            DocSpec get = specList.stream().filter(p -> p.getIdspec().getSpecname().equalsIgnoreCase(value)).findFirst().get();
            return get;
        }
 
        @Override public String getAsString(FacesContext fc, UIComponent uic, Object object) {
            if(object != null) {
                return ((DocSpec) object).getIdspec().getSpecname();
        }
        else {
            return null;
        }        }   
    }

    
    
}
