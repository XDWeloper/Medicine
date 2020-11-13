package ru.inversionkavkaz.DocMod.Controllers;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import ru.inversionkavkaz.DocMod.Interfaces.IDocController;

@Named(value = "surgeonController")
@ViewScoped
public class SurgeonController implements Serializable,IDocController{
    
    private String complaints;
    private String history;
    private String traumaField;
    private String[] trauma;
    private String objectiveField;
    private String[] objective;
    private String[] lordosis;
    private String[] stomach;
    private String herniasField;
    private String[] hernias;
    private String jointsField;
    private String[] joints;
    private String jointsMove;
    private String jointsMoveField;
    private String veinsField;
    private String arteryField;
    private String st_localisField;
    
    
    
    public SurgeonController() {}

    public void lisener(){}
     
    @Override public void save(){}

    public String[] getLordosis() {
        return lordosis;
    }

    public void setLordosis(String[] lordosis) {
        this.lordosis = lordosis;
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

    public String getTraumaField() {
        return traumaField;
    }

    public void setTraumaField(String traumaField) {
        this.traumaField = traumaField;
    }

    public String[] getTrauma() {
        return trauma;
    }

    public void setTrauma(String[] trauma) {
        this.trauma = trauma;
    }

    public String getObjectiveField() {
        return objectiveField;
    }

    public void setObjectiveField(String objectiveField) {
        this.objectiveField = objectiveField;
    }

    public String[] getObjective() {
        return objective;
    }

    public void setObjective(String[] objective) {
        this.objective = objective;
    }

    public String[] getStomach() {
        return stomach;
    }

    public void setStomach(String[] stomach) {
        this.stomach = stomach;
    }

    public String getHerniasField() {
        return herniasField;
    }

    public void setHerniasField(String herniasField) {
        this.herniasField = herniasField;
    }

    public String[] getHernias() {
        return hernias;
    }

    public void setHernias(String[] hernias) {
        this.hernias = hernias;
    }

    public String getJointsField() {
        return jointsField;
    }

    public void setJointsField(String jointsField) {
        this.jointsField = jointsField;
    }

    public String[] getJoints() {
        return joints;
    }

    public void setJoints(String[] joints) {
        this.joints = joints;
    }

    public String getJointsMove() {
        return jointsMove;
    }

    public void setJointsMove(String jointsMove) {
        this.jointsMove = jointsMove;
    }

    public String getJointsMoveField() {
        return jointsMoveField;
    }

    public void setJointsMoveField(String jointsMoveField) {
        this.jointsMoveField = jointsMoveField;
    }

    public String getVeinsField() {
        return veinsField;
    }

    public void setVeinsField(String veinsField) {
        this.veinsField = veinsField;
    }

    public String getArteryField() {
        return arteryField;
    }

    public void setArteryField(String arteryField) {
        this.arteryField = arteryField;
    }

    public String getSt_localisField() {
        return st_localisField;
    }

    public void setSt_localisField(String st_localisField) {
        this.st_localisField = st_localisField;
    }
    
    
}
