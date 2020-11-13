package ru.inversionkavkaz.DocMod.Controllers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import ru.inversionkavkaz.DocMod.Entities.AllergyPerson;
import ru.inversionkavkaz.DocMod.Entities.Hazard;
import ru.inversionkavkaz.DocMod.Session.BenefitFacade;
import ru.inversionkavkaz.DocMod.Session.CusFacade;
import ru.inversionkavkaz.DocMod.Session.HazardFacade;
import ru.inversionkavkaz.DocMod.Session.Mkb10Facade;
import ru.inversionkavkaz.DocMod.Session.ProfessionFacade;
import ru.inversionkavkaz.DocMod.Session.SubvisionFacade;

/**
 *
 * @author DMITRY
 */
@Named(value = "ambulanceDataController")
@Dependent
public class AmbulanceDataController {


    @EJB private HazardFacade hazardFacade;
    @EJB private SubvisionFacade subvisionFacade;
    @EJB private ProfessionFacade professionFacade;
    @EJB private CusFacade cusFacade;
    @EJB private Mkb10Facade mkb10Facade;
    @EJB private BenefitFacade benefitFacade;
    @Inject  private IndexController indexController;
    
    public AmbulanceDataController() {
    }
    
    @PostConstruct void Init(){
    }

    public String getBenefitString() {
        if(indexController.getSelectPerson() == null) return null;
            String benefitCode = indexController.getSelectPerson().getBenefitCode();
            if(benefitCode == null) return "нет";
            String benefitName = benefitFacade.find(benefitCode).getBenefitName();
            return benefitCode + " " + benefitName;
    }
    
    public Collection<AllergyPerson> getAllergiList(){
        if(indexController.getSelectPerson() == null || indexController.getSelectPerson().getIdperson() == null) return null;
            return indexController.getSelectPerson().getAllergyPersonCollection();
    }

    public boolean getPersonIllness(){
        return getPersonsIllnessList() != null && !getPersonsIllnessList().isEmpty();
    }
    
    public List<PersonsIllness> getPersonsIllnessList(){
        if(indexController.getSelectPerson() == null) return null;
        List <PersonsIllness> personsIllnessList = new ArrayList<>();
            BigInteger person_id = indexController.getSelectPerson().getIdperson().toBigInteger();
                indexController.getSelectPerson().getPersonIllnessCollection().forEach(a ->
                {
                personsIllnessList.add(new PersonsIllness(a.getLookStart(), a.getLookFinish(), 
                        mkb10Facade.find(a.getPersonIllnessPK().getIdmkb()).getMkbName() ,
                        a.getPersonIllnessPK().getIdmkb(), a.getDoctor()!= null ? a.getDoctor() : ""));
                });
        return personsIllnessList;
    }

    public String getCustomer(){
        if(indexController.getSelectPerson() == null) return null;
        if(indexController.getSelectPerson().getIcusnum() == null) return "";
        BigDecimal icusnum = new BigDecimal(indexController.getSelectPerson().getIcusnum());
        String ccusname = cusFacade.find(icusnum).getCcusname();
        return ccusname;
    }

    public String getSubvision(){
        if(indexController.getSelectPerson() == null) return null;
        if(indexController.getSelectPerson().getSubId() == null) return "";
        return subvisionFacade.findAll().stream().filter(p -> p.getSubvisionPK().getSubId() == indexController.getSelectPerson().getSubId()).findFirst().get().getSubName();
    }

    public String getProfession(){
        if(indexController.getSelectPerson() == null) return null;
        if(indexController.getSelectPerson().getSubId() == null) return "";
        return professionFacade.find(indexController.getSelectPerson().getProfId()).getProfName();
    }
    
    public List<PersonHazard> getHazardList(){
        if(indexController.getSelectPerson() == null) return null;
        List<PersonHazard> personHazard = new ArrayList<>();
        indexController.getSelectPerson().getPersonHazardCollection().
                forEach(a -> {
                    String hazName = hazardFacade.find(a.getPersonHazardPK().getHazId()).getHazName();
                    Hazard find = hazardFacade.find(a.getPersonHazardPK().getHazId());
                    String hazCode = find.getHazCode();
                    personHazard.add(new PersonHazard(hazCode, hazName));
                });
        return personHazard;
    }
    
    public List<PersonJobRoute> getPersonJobRoute(){
        if(indexController.getSelectPerson() == null) return null;
            List<PersonJobRoute> personJobRouteList = new ArrayList<>();
            indexController.getSelectPerson().getPersonJobCollection() .forEach(a -> {
                        String ccusname = cusFacade.find(new BigDecimal(a.getIcusnum())).getCcusname();                        
                        String subName = subvisionFacade.findAll().stream().filter(p -> p.getSubvisionPK().getSubId() == a.getSubvision()).findFirst().get().getSubName();
                        String profName = professionFacade.find(a.getProfId()).getProfName();
                        String hazName = hazardFacade.find(a.getHazId()).getHazName();
                        String hazJobName = hazardFacade.find(a.getHazJobId()).getHazName();
                        personJobRouteList.add(new PersonJobRoute(a.getStartDate(), a.getEndDate(), ccusname, subName, profName, hazName, hazJobName));
                    });
        return personJobRouteList;
    }
    
    public class PersonHazard{
    private final String haz_code;
    private final String haz_name;

        public PersonHazard(String haz_code, String haz_name) {
            this.haz_code = haz_code;
            this.haz_name = haz_name;
        }

        public String getHaz_code() {
            return haz_code;
        }

        public String getHaz_name() {
            return haz_name;
        }
    
    
    
    }
    
    public class PersonsIllness{
        private final Date start_date;
        private final Date end_date;
        private final String diagnosis;
        private final String mkb_code;
        private final String doctor;

        public PersonsIllness(Date start_date, Date end_date, String diagnosis, String mkb_code, String doctor) {
            this.start_date = start_date;
            this.end_date = end_date;
            this.diagnosis = diagnosis;
            this.mkb_code = mkb_code;
            this.doctor = doctor;
        }

        public Date getStart_date() {
            return start_date;
        }

        public Date getEnd_date() {
            return end_date;
        }

        public String getDiagnosis() {
            return diagnosis;
        }

        public String getMkb_code() {
            return mkb_code;
        }

        public String getDoctor() {
            return doctor;
        }
        
        
    }
    
    public class PersonJobRoute{
        private final Date start_date;
        private final Date end_date;
        private final String customer;
        private final String subvision;
        private final String position;
        private final String hazFact;
        private final String hazJob;

        public PersonJobRoute(Date start_date, Date end_date, String customer, String subvision, String position, String hazFact, String hazJob) {
            this.start_date = start_date;
            this.end_date = end_date;
            this.customer = customer;
            this.subvision = subvision;
            this.position = position;
            this.hazFact = hazFact;
            this.hazJob = hazJob;
        }

        public Date getStart_date() {
            return start_date;
        }

        public Date getEnd_date() {
            return end_date;
        }

        public String getCustomer() {
            return customer;
        }

        public String getSubvision() {
            return subvision;
        }

        public String getPosition() {
            return position;
        }

        public String getHazFact() {
            return hazFact;
        }

        public String getHazJob() {
            return hazJob;
        }
        
        
    }
}
