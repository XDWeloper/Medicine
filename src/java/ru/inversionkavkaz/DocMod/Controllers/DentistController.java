
package ru.inversionkavkaz.DocMod.Controllers;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.DiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.connector.StraightConnector;
import org.primefaces.model.diagram.endpoint.BlankEndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;


@Named(value = "dentistController")
@ViewScoped
public class DentistController implements Serializable{

    private String complaints;
    private String objective;
    private String bite;
    private String x_ray;
    private String oralCavity;
    private int elNum;
    
    public DentistController() {}
    
    public void lisener(){}
    public void save(){}
    


    public int getElNum() {
        return elNum;
    }

    public void setElNum(int elNum) {
        this.elNum = elNum;
    }
    
    
    public String getOralCavity() {
        return oralCavity;
    }

    public void setOralCavity(String oralCavity) {
        this.oralCavity = oralCavity;
    }

    public String getComplaints() {
        return complaints;
    }

    public void setComplaints(String complaints) {
        this.complaints = complaints;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getBite() {
        return bite;
    }

    public void setBite(String bite) {
        this.bite = bite;
    }

    public String getX_ray() {
        return x_ray;
    }

    public void setX_ray(String x_ray) {
        this.x_ray = x_ray;
    }

    
}
