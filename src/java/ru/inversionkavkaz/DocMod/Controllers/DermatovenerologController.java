package ru.inversionkavkaz.DocMod.Controllers;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "dermatovenerologController")
@ViewScoped
public class DermatovenerologController implements Serializable {

    private String complaints;
    private String history;
    private String skin;
    private String skinField;

    public DermatovenerologController() {}
    public void lisener(){}
    public void save(){}

    public String getSkinField() {
        return skinField;
    }

    public void setSkinField(String skinField) {
        this.skinField = skinField;
    }

    public String getComplaints() {
        return complaints;
    }

    public void setComplaints(String complaints) {
        this.complaints = complaints;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }
    
}
