package ru.inversionkavkaz.DocMod.Beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.DiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.connector.StraightConnector;
import org.primefaces.model.diagram.endpoint.BlankEndPoint;
import org.primefaces.model.diagram.endpoint.DotEndPoint;
import org.primefaces.model.diagram.endpoint.EndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;
 
@ManagedBean(name = "diagramHierarchicalView")
@SessionScoped
public class HierarchicalView implements Serializable{
    private int elemenNum;
    private DefaultDiagramModel model;
 
    @PostConstruct
    public void init() {
        model = new DefaultDiagramModel();
        model.setMaxConnections(-1);
                 
        Element base = new Element("", "50px", "50px");
        base.addEndPoint(new BlankEndPoint(EndPointAnchor.AUTO_DEFAULT));
        base.setDraggable(false);
        model.addElement(base);
         elemenNum++;
         
        StraightConnector connector = new StraightConnector();
        connector.setPaintStyle("{strokeStyle:'#404a4e', lineWidth:1}");
        connector.setHoverPaintStyle("{strokeStyle:'#FFD700'}");
                         
        //connections
//        model.connect(new Connection(ceo.getEndPoints().get(0), cfo.getEndPoints().get(0), connector));        
//        model.connect(new Connection(ceo.getEndPoints().get(0), cto.getEndPoints().get(0), connector));
//        model.connect(new Connection(cfo.getEndPoints().get(1), fin.getEndPoints().get(0), connector));
//        model.connect(new Connection(cfo.getEndPoints().get(1), pur.getEndPoints().get(0), connector));
//        model.connect(new Connection(cto.getEndPoints().get(1), dev.getEndPoints().get(0), connector));
//        model.connect(new Connection(cto.getEndPoints().get(1), tst.getEndPoints().get(0), connector));
    }
     
    private EndPoint createEndPoint(EndPointAnchor anchor) {
        DotEndPoint endPoint = new DotEndPoint(anchor);
        endPoint.setStyle("{fillStyle:'#2B579A'}");
        endPoint.setHoverStyle("{fillStyle:'#DC143C'}");
         
        return endPoint;
    }
     
    private void setNewElement(int x, int y){
        String X = ""+x+"px";
        String Y = ""+y+"px";
        Element base = new Element("",X ,Y);
        base.addEndPoint(new BlankEndPoint(EndPointAnchor.AUTO_DEFAULT));
        model.addElement(base);
         elemenNum++;
    }
    
    public DiagramModel getModel() {
        return model;
    }
    
    public void onClick(){
        String get = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("elementId");
        String[] split = get.split(",");
        int x = Integer.decode(split[0]);
        int y = Integer.decode(split[1]);
        setNewElement(x, y);
        System.out.println("x:"+x+"   y:"+y+"");
    }
}