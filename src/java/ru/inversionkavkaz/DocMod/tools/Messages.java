
package ru.inversionkavkaz.DocMod.tools;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;

/**
 *
 * @author DMITRY
 */
@Named(value = "messages")
@Dependent
public class Messages {

    public Messages() {
    }

public static void showMessage(String messageString, FacesMessage.Severity fms){
    FacesMessage message = new FacesMessage(fms, messageString,messageString);
    RequestContext.getCurrentInstance().showMessageInDialog(message);
}    
}
