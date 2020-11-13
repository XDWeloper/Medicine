
package ru.inversionkavkaz.DocMod.Controllers;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import ru.inversionkavkaz.DocMod.Entities.Doctors;
import ru.inversionkavkaz.DocMod.Entities.Password;
import ru.inversionkavkaz.DocMod.Entities.Role;
import ru.inversionkavkaz.DocMod.Entities.StartPage;
import ru.inversionkavkaz.DocMod.Session.DoctorsFacade;
import ru.inversionkavkaz.DocMod.Session.PasswordFacade;
import ru.inversionkavkaz.DocMod.Session.RoleFacade;
import ru.inversionkavkaz.DocMod.Session.StartPageFacade;
import ru.inversionkavkaz.DocMod.tools.LoginTools;



@Named(value = "loginController")
@SessionScoped

public class LoginController implements Serializable {

    @EJB  private StartPageFacade startPageFacade;
    @EJB  private RoleFacade roleFacade;
    @EJB  private DoctorsFacade doctorsFacade;
    @EJB  private PasswordFacade passwordFacade;
    
    
    private String login;
    private String password;
    private Doctors doctor;

    public LoginController() {
    }
    
    
    public void addMessage(String massage) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, massage,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String login() throws IOException, SQLException{
        if(login.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
            List<Doctors> findAll = doctorsFacade.findAll();
            boolean present = findAll.stream().filter(a ->  (a.getRoleId()  != null ? a.getRoleId():0) == 4).findAny().isPresent();
            if(!present){
                FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
                addMessage("Профиль администратора подождите");
                return "admin";
            }  
        }
        doctor = getDoctor(login,password);
        if(doctor == null){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        addMessage("Неверно введен логин или пароль !!!");
        return null;
        }
        Integer roleId = doctor.getRoleId();
        if(roleId == null) {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        addMessage("Для данного пользователя не задана роль обратитесь к администратору !!!");
        return null;
        }
        Role find = roleFacade.find(roleId);
        Integer startPageId = find.getStartPageId();
        StartPage sPage = startPageFacade.find(startPageId);
        String startPageFile = sPage.getStartPageFile();
        HttpSession session =  (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.setAttribute("login", login);
        switch(startPageFile){
            case "welcome": return "doctor";
            case "ADMIN":
                FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
                addMessage("Профиль администратора подождите");
                return "admin";
            case "CounterPage": return "counter";
        }
        return null;
    }

    public String getLogin() {return login;}
    public void setLogin(String login) {this.login = login;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public Doctors getDoctor() {return doctor;}
    
    private Doctors getDoctor(String login,String password){
        String hashPass = LoginTools.getPasswordHash(password);
        Password pass = passwordFacade.find(login);
        if(pass == null || !pass.getPassword().equals(hashPass)) return null;
        return pass.getDocId();
    }
}
