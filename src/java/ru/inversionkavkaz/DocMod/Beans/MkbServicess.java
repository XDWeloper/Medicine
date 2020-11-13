package ru.inversionkavkaz.DocMod.Beans;

import java.io.Serializable;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import ru.inversionkavkaz.DocMod.Entities.Mkb10Classes;
import ru.inversionkavkaz.DocMod.Session.Mkb10ClassesFacade;

@Named(value = "mkbServicess")
@ApplicationScoped

public class MkbServicess implements Serializable{

    @EJB private Mkb10ClassesFacade mkb10ClassesFacade;
    TreeNode root;

   @PostConstruct void Inuit(){
       createNodes();
   }
   
   
    public MkbServicess() {
    }
    
  TreeNode createNodes() {
        root = new DefaultTreeNode(new Mkb10Classes(), null);
        setNodeTree(root,0);
        return root;
    }
    
    private void setNodeTree(TreeNode parentNode, int parentClass){
        Collection<Mkb10Classes> findAll = mkb10ClassesFacade.findByParentCode(parentClass);
        if(findAll.isEmpty()) return;
        findAll.stream().forEach(a -> {
            TreeNode deniro = new DefaultTreeNode(a, parentNode);
            setNodeTree(deniro, a.getMkbClassCode());
        });
    }

    public TreeNode getRoot() {
        if(root != null)  return root;
        return createNodes();
    }
    
}
