package ru.inversionkavkaz.DocMod.Controllers;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.inject.Inject;
import org.primefaces.model.TreeNode;
import ru.inversionkavkaz.DocMod.Beans.MkbServicess;
import ru.inversionkavkaz.DocMod.Entities.Mkb10;
import ru.inversionkavkaz.DocMod.Entities.Mkb10Classes;
import ru.inversionkavkaz.DocMod.Session.Mkb10ClassesFacade;


@Named(value = "mkbController")
@ViewScoped

public class MkbController implements Serializable{

    @EJB  private Mkb10ClassesFacade mkb10ClassesFacade;
    private TreeNode root;
    private TreeNode selectedNode;
    private List<Mkb10> mkbSellected;
    private List<Mkb10> mkbList;
    private Mkb10Classes sellectedClass;
    
    public MkbController() {
    }
    
    @Inject MkbServicess service;
    @Inject FooterController footer;
     
    @PostConstruct
    public void init() {
        root = service.getRoot();
    }

    public void onSelectedMkbClass(){
        sellectedClass = (Mkb10Classes) selectedNode.getData();
        MkbList();
    }
    
    public void MkbList(){
        if(sellectedClass == null) return ;
        mkbList = (List<Mkb10>) mkb10ClassesFacade.find(sellectedClass.getMkbClassId()).getMkb10Collection();
    }

    public void onSaveButton(){
        footer.setMkbSellected(mkbSellected);
        onCloseButton();
    }

    public void onCloseButton(){
        sellectedClass = null;
        mkbSellected.clear();
        this.root.getChildren().stream().filter(r -> r.isExpanded()).forEach(a -> a.setExpanded(false));
    }
    
    
    
    public List<Mkb10> getMkbList() {
        return mkbList;
    }

    public void setMkbList(List<Mkb10> mkbList) {
        this.mkbList = mkbList;
    }

    public List<Mkb10> getMkbSellected() {
        return mkbSellected;
    }

    public void setMkbSellected(List<Mkb10> mkbSellected) {
        this.mkbSellected = mkbSellected;
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

    
    
}
