package ru.inversionkavkaz.DocMod.Beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import ru.inversionkavkaz.DocMod.Entities.Hazard;
import ru.inversionkavkaz.DocMod.Session.HazardFacade;

@Named(value = "hazardService")
@ApplicationScoped
public class HazardService implements Serializable{
    @EJB  private HazardFacade hazardFacade;
    List<Hazard> hazTable;
    
    @PostConstruct void Init(){
        hazTable = hazardFacade.findAll();
    }
    
    public HazardService() {
    }
    
    public List<Hazard> getHazList(){
        if(!hazTable.isEmpty()) return hazTable;
        Init();
        return hazTable;
    }
    
}
