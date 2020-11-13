
package ru.inversionkavkaz.DocMod.Controllers;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;

@Named(value = "calController")
@SessionScoped

public class CalController implements Serializable {
    private Date date;
    private String dateStr;
    private final SimpleDateFormat format;
    
    public CalController() {
        this.format = new SimpleDateFormat("dd.MM.yyyy");
        this.date = Date.from(Instant.now());
        this.dateStr = format.format(date);
    }
    
    
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Выбрана дата: ",dateStr));
    }
     
    public Date getDate() {
        return date;}
    public void setDate(Date date) {
        this.date = date;
        dateStr = format.format(date);
    } 

    public String getDateStr() {return dateStr;}
    public void setDateStr(String dateStr) {this.dateStr = dateStr;}
 
    
}
