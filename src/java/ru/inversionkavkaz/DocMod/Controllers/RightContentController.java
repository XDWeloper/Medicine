package ru.inversionkavkaz.DocMod.Controllers;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.inject.Inject;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import ru.inversionkavkaz.DocMod.Entities.DocSpec;
import ru.inversionkavkaz.DocMod.Entities.Doctors;
import ru.inversionkavkaz.DocMod.Entities.PersonsRezults;
import ru.inversionkavkaz.DocMod.Session.DocSpecFacade;
import ru.inversionkavkaz.DocMod.Session.DoctorSpecialtyFacade;
import ru.inversionkavkaz.DocMod.Session.DoctorsFacade;
import ru.inversionkavkaz.DocMod.Session.PersonsRezultsFacade;

@Named(value = "rightContentController")
@RequestScoped
public class RightContentController implements Serializable{

    @EJB private DoctorsFacade doctorsFacade;
    @EJB private DocSpecFacade docSpecFacade;
    @EJB private DoctorSpecialtyFacade doctorSpecialtyFacade;
    @EJB  private PersonsRezultsFacade personsRezultsFacade;
   
    @Inject IndexController indexController;
    @Inject DoctorsPagesController doctorController;

    private  TreeNode root;
    private TreeNode selectedNode;
    private Set<String> yearList = new TreeSet<>();
    
     @PostConstruct void Init(){
        root = new DefaultTreeNode(new String(), null);
         createNodes(indexController.getSellectedPersonId());
   }

     void createNodes(int person_id) {
         if(person_id == 0) return;
        Collection<PersonsRezults> findBypersonId = personsRezultsFacade.findBypersonId(person_id);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY");
        findBypersonId.stream().forEach(a -> {
             String s = simpleDateFormat.format(a.getRezDate()).toUpperCase();
            yearList.add(s);
        });
        yearList.stream().forEach(a -> {
         DefaultTreeNode defaultTreeNode = new DefaultTreeNode(new String(a), root);
         findBypersonId.stream().filter(p -> simpleDateFormat.format(p.getRezDate()).equalsIgnoreCase(a)).forEach(r -> {
             Rezult rezult = new Rezult(r.getRezDate(), r.getSpecId(), r.getRezId());
             new DefaultTreeNode(rezult, defaultTreeNode);
         });
        });
        
     }     
  
    public void onSellectedRezult(String openType){
        if(selectedNode != null && selectedNode.getData() instanceof Rezult ){
           if(indexController.getDoctor().getIddoctor().intValue() ==  personsRezultsFacade.find(((Rezult) selectedNode.getData()).getRez_id()).getDoctorId()) openType = "edit";
            Integer doctorId = personsRezultsFacade.find(((Rezult) selectedNode.getData()).getRez_id()).getDoctorId();
            Doctors find = doctorsFacade.find(doctorId.longValue());
            Integer specId = personsRezultsFacade.find(((Rezult) selectedNode.getData()).getRez_id()).getSpecId();
            Collection<DocSpec> findByDoctorId = docSpecFacade.findByDoctorId(find);
            DocSpec get = findByDoctorId.stream().filter(a ->  a.getIdspec().getIdspec().equals(specId)).findFirst().get();
            doctorController.openRezultView(openType,get,((Rezult) selectedNode.getData()).getRez_id());
        }
    }
  
    public RightContentController() {
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }
 
    public class Rezult {
        private Date date;
        private int spec_id;
        private int rez_id;
        private final String specName;
        
        public Rezult(Date date, int spec_id, int rez_id) {
            this.date = date;
            this.spec_id = spec_id;
            this.rez_id = rez_id;
            this.specName = doctorSpecialtyFacade.find(spec_id).getSpecname();
        }

        public String getSpecName() {
            return specName;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public int getSpec_id() {
            return spec_id;
        }

        public void setSpec_id(int spec_id) {
            this.spec_id = spec_id;
        }

        public int getRez_id() {
            return rez_id;
        }

        public void setRez_id(int rez_id) {
            this.rez_id = rez_id;
        }
        
        @Override public String toString(){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM");
             String s = simpleDateFormat.format(date).toUpperCase();            
        return "" +s+ "  "+specName;
        }
        
}

}
