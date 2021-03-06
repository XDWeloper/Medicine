package ru.inversionkavkaz.DocMod.Controllers;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;


@Named(value = "narcologyController")
@ViewScoped
public class NarcologyController implements Serializable{

    private String complaints;
    private String history;
    private String objective;
    private String recomendation;
    private String moment;

    public NarcologyController() {}
    public void lisener(){}
    public void save(){}

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

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getRecomendation() {
        return recomendation;
    }

    public void setRecomendation(String recomendation) {
        this.recomendation = recomendation;
    }

    public String getMoment() {
        return moment;
    }

    public void setMoment(String moment) {
        this.moment = moment;
    }
    
}
