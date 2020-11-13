/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.inversionkavkaz.DocMod.Controllers;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import ru.inversionkavkaz.DocMod.Beans.HazardService;
import ru.inversionkavkaz.DocMod.Entities.Hazard;

/**
 *
 * @author DMITRY
 */
@Named(value = "hazardController")
@ViewScoped
public class HazardController implements Serializable{
    @Inject FooterController footer;
    @Inject HazardService hazServ;
    private List<Hazard> sellectedHaz;
    
    @PostConstruct void Init(){
}
    public HazardController() {
    }
    
    public List<Hazard> getHazList(){
        return hazServ.getHazList();
    }

    public List<Hazard> getSellectedHaz() {
        return sellectedHaz;
    }

    public void setSellectedHaz(List<Hazard> sellectedHaz) {
        this.sellectedHaz = sellectedHaz;
    }
   
    public void onSaveButton(){
        footer.setHazSellected(sellectedHaz);
        onCloseButton();
    }

    public void onCloseButton(){
        sellectedHaz.clear();
    }
    
    
}
