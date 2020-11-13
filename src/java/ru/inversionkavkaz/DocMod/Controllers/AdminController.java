
package ru.inversionkavkaz.DocMod.Controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.primefaces.model.DualListModel;
import ru.inversionkavkaz.DocMod.Entities.DocSpec;
import ru.inversionkavkaz.DocMod.Entities.Doctors;
import ru.inversionkavkaz.DocMod.Entities.Group1;
import ru.inversionkavkaz.DocMod.Entities.GroupList;
import ru.inversionkavkaz.DocMod.Entities.HtmlPageType;
import ru.inversionkavkaz.DocMod.Entities.HtmlPages;
import ru.inversionkavkaz.DocMod.Entities.Role;
import ru.inversionkavkaz.DocMod.Session.DocSpecFacade;
import ru.inversionkavkaz.DocMod.Session.DoctorsFacade;
import ru.inversionkavkaz.DocMod.Session.Group1Facade;
import ru.inversionkavkaz.DocMod.Session.GroupListFacade;
import ru.inversionkavkaz.DocMod.Session.HtmlPageTypeFacade;
import ru.inversionkavkaz.DocMod.Session.HtmlPagesFacade;
import ru.inversionkavkaz.DocMod.Session.RoleFacade;

@Named(value = "adminController")
@SessionScoped
public class AdminController implements Serializable{

    @EJB  private GroupListFacade groupListFacade;
    @EJB  private Group1Facade group1Facade;
    @EJB  private RoleFacade roleFacade;
    @EJB  private DoctorsFacade doctorsFacade;
    @EJB  private DocSpecFacade docSpecFacade;
    @EJB  private HtmlPageTypeFacade htmlPageTypeFacade;
    @EJB  private HtmlPagesFacade htmlPagesFacade;
    @Inject DoctorsPagesController doctorController;
    
    
    
    private Set<Long> doctors_id;
    private List <Pages> pages;
    private Pages sellectedPage;

    private String htmlPagesNameSellected;
    private String htmlPagesTypeSellected;
    private HtmlPageTypeConverter htmlPageTypeConverter;
    private HtmlPageConverter htmlPageConverter;
    private RoleConverter roleConverter;
    private GroupConverter groupConverter;

    @PostConstruct  public void init() {
        pages = new ArrayList<>();
//        doctors_id = new TreeSet<>();
//        List<DocSpec> docSpecList = docSpecFacade.findAll();
//        docSpecList.stream().forEach(a -> {
//            doctors_id.add(a.getIddoctor().getIddoctor());
//        });
//        doctors_id.stream().forEach(a -> pages.add(new Pages(a)));
        doctorsFacade.findAll().stream().forEach(a -> pages.add(new Pages(a.getIddoctor())));
        Comparator<Pages> comp = (Pages a, Pages b) -> {
        return a.doctorName.compareToIgnoreCase(b.doctorName);
    };
        Collections.sort(pages,comp);
        htmlPageTypeConverter = new HtmlPageTypeConverter();
        htmlPageConverter = new HtmlPageConverter();
        roleConverter = new  RoleConverter();
        groupConverter = new  GroupConverter();
    }
    
    public AdminController() {
    }

    public String logout(){
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            return "exit";
    }

    public GroupConverter getGroupConverter() {
        return groupConverter;
    }
    
    public RoleConverter getRoleConverter() {
        return roleConverter;
    }
    
    public HtmlPageTypeConverter getHtmlPageTypeConverter() {
        return htmlPageTypeConverter;
    }

    public HtmlPageConverter getHtmlPageConverter() {
        return htmlPageConverter;
    }

    public List<Pages> getPages() {
        return pages;
    }

    public void setPages(List<Pages> pages) {
        this.pages = pages;
    }

    public Pages getSellectedPage() {
        return sellectedPage;
    }

    public void setSellectedPage(Pages sellectedPage) {
        this.sellectedPage = sellectedPage;
    }

    public String getHtmlPagesNameSellected() {
        return htmlPagesNameSellected;
    }

    public void setHtmlPagesNameSellected(String htmlPagesNameSellected) {
        this.htmlPagesNameSellected = htmlPagesNameSellected;
    }

    public String getHtmlPagesTypeSellected() {
        return htmlPagesTypeSellected;
    }

    public void setHtmlPagesTypeSellected(String htmlPagesTypeSellected) {
        this.htmlPagesTypeSellected = htmlPagesTypeSellected;
    }

    public  class HtmlPageTypeConverter implements Converter{
    
        private List<HtmlPageType> htmlPagesType;
    
        public HtmlPageTypeConverter() {
            htmlPagesType = htmlPageTypeFacade.findAll();
        }
    
   @Override public Object getAsObject(FacesContext context, UIComponent component, String value) {
       HtmlPageType get = htmlPagesType.stream().filter(p -> p.getHtmlTypeName().equalsIgnoreCase(value)).findFirst().get();
       return get;
   }

   @Override public String getAsString(FacesContext fc, UIComponent uic, Object object) {
       if(object != null) {
           return ((HtmlPageType) object).getHtmlTypeName();
   }
   else {
       return null;
   }        }   
   }

    public  class HtmlPageConverter implements Converter{
    
        private List<HtmlPages> htmlPages;
    
        public HtmlPageConverter() {
            htmlPages = htmlPagesFacade.findAll();
        }
    
   @Override public Object getAsObject(FacesContext context, UIComponent component, String value) {
       HtmlPages get = htmlPages.stream().filter(p -> p.getHtmlPageName().equalsIgnoreCase(value)).findFirst().get();
       return get;
   }

   @Override public String getAsString(FacesContext fc, UIComponent uic, Object object) {
            if(object != null)  return ((HtmlPages) object).getHtmlPageName();
            else  return null;
       }   
   }
    
    public  class RoleConverter implements Converter{
        private List<Role> roleList;
        public RoleConverter() {
            roleList = roleFacade.findAll();
        }
    
   @Override public Object getAsObject(FacesContext context, UIComponent component, String value) {
       Role get = roleList.stream().filter(p -> p.getRoleName().equalsIgnoreCase(value)).findFirst().get();
       return get;
   }

   @Override public String getAsString(FacesContext fc, UIComponent uic, Object object) {
            if(object != null)  return ((Role) object).getRoleName();
            else  return null;
       }   
   }

    public  class GroupConverter implements Converter{
        private List<Group1> group;
        public  GroupConverter() {
            group = group1Facade.findAll();
        }
    
   @Override public Object getAsObject(FacesContext context, UIComponent component, String value) {
       Group1 get = group.stream().filter(p -> p.getGroupName().equalsIgnoreCase(value)).findFirst().get();
       return get;
   }

   @Override public String getAsString(FacesContext fc, UIComponent uic, Object object) {
            if(object != null)  return ((Group1) object).getGroupName();
            else  return null;
       }   
   }
    
    
    public class Pages{
        private String doctorName;
        private List<SpecPages> docSpecName;
        private Long doc_id;
        private Role roleName;
        private List<Role> roleList;
        private DualListModel<Group1> group;
        private Doctors doctor;
        
        public Pages(Long doctor_id) {
            this.doc_id = doctor_id;
            docSpecName = new ArrayList<>();
            doctor = doctorsFacade.find(doctor_id);
            doctorName = doctor.getLastname() +" "+ doctor.getFirstname() + " " + doctor.getMiddlename();
            roleList = roleFacade.findAll();
            if(doctor.getRoleId() != null)  roleName = roleFacade.findAll().stream().filter(p -> p .getRoleId().equals(doctor.getRoleId())).findFirst().get();
            Collection<DocSpec> findByDoctorId = docSpecFacade.findByDoctorId(doctor);

            findByDoctorId.stream().forEach(a -> {
                HtmlPages htmlPagesL = htmlPagesFacade.find(a.getHtmlPageId());
                HtmlPageType htmlPagesType = htmlPagesL != null ? htmlPageTypeFacade.find(htmlPagesL.getHtmlTypeId()): null;
                SpecPages specPages = new SpecPages(a,htmlPagesType,htmlPagesL,this);
                this.docSpecName.add(specPages);
            } );

            List<Group1> allGroupList = group1Facade.findAll();
            List<Group1> docGroupList = new ArrayList<>();            
            List<GroupList> collect = groupListFacade.findAll().stream().filter(p -> p.getDoctorId().equals(doctor)).collect(Collectors.toList());
            collect.stream().forEach(a -> {
                docGroupList.add(a.getGroupId());
            });
            group = new DualListModel<>(allGroupList, docGroupList);            
        }

        public void onRoleChange(){
            doctor.setRoleId(roleName != null ? roleName.getRoleId(): null);
            doctorsFacade.edit(doctor);
        }
        
        public DualListModel<Group1> getGroup() {
            return group;
        }

        public void setGroup(DualListModel<Group1> group) {
            this.group = group;
        }

        public Role getRoleName() {
            return roleName;
        }

        public void setRoleName(Role roleName) {
            this.roleName = roleName;
        }

        public List<Role> getRoleList() {
            return roleList;
        }

        public void setRoleList(List<Role> roleList) {
            this.roleList = roleList;
        }

        public Long getDoc_id() {
            return doc_id;
        }

        public void setDoc_id(Long doc_id) {
            this.doc_id = doc_id;
        }

        public String getDoctorName() {
            return doctorName;
        }

        public void setDoctorName(String doctorName) {
            this.doctorName = doctorName;
        }

        public List<SpecPages> getDocSpecName() {
            return docSpecName;
        }

        public void setDocSpecName(List<SpecPages> docSpecName) {
            this.docSpecName = docSpecName;
        }

        
        public class SpecPages{
            private final Pages parentPage;
            private DocSpec docSpec;
            private HtmlPageType htmlType;
            private HtmlPages htmlPage;
            private final String specName;
            private final List<HtmlPageType> htmlPagesType;
            private List<HtmlPages> htmlPagesName;
        
            public SpecPages(DocSpec docSpec, HtmlPageType htmlType, HtmlPages htmlPage,Pages parentPage) {
                this.parentPage = parentPage;
                this.docSpec = docSpec;
                this.htmlType = htmlType;
                this.htmlPage = htmlPage;
                this.specName = docSpec.getIdspec().getSpecname();
                 htmlPagesType = htmlPageTypeFacade.findAll();
                 htmlPagesName = htmlType != null ? new ArrayList<>(htmlPagesFacade.findByTypeId(htmlType.getHtmlTypeId())): null;
            }
    
            public void onTypeChange(){
                 htmlPagesName = htmlType != null ? new ArrayList<>(htmlPagesFacade.findByTypeId(htmlType.getHtmlTypeId())): null;
            }
            
            public void onPageChange(){
                docSpec.setHtmlPageId(htmlPage.getHtmlPageId());
                docSpecFacade.edit(docSpec);
            }

            public void onView(){
                HttpSession session =  (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                session.setAttribute("login", "admin");
                doctorController.openRezultView("adminView",docSpec,0);
        }
            
            
            
            public List<HtmlPageType> getHtmlPagesType() {
                return htmlPagesType;
            }

            public List<HtmlPages> getHtmlPagesName() {
                return htmlPagesName;
            }

            public String getSpecName() {
                return specName;
            }

            public DocSpec getDocSpec() {
                return docSpec;
            }

            public void setDocSpec(DocSpec docSpec) {
                this.docSpec = docSpec;
            }

            public HtmlPageType getHtmlType() {
                return htmlType;
            }

            public void setHtmlType(HtmlPageType htmlType) {
                this.htmlType = htmlType;
            }

            public HtmlPages getHtmlPage() {
                return htmlPage;
            }

            public void setHtmlPage(HtmlPages htmlPage) {
                this.htmlPage = htmlPage;
            }
         
        }

    }
}
