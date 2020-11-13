/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.inversionkavkaz.DocMod.tools;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import ru.inversionkavkaz.DocMod.Controllers.IndexController;

/**
 *
 * @author DMITRY
 */
@Singleton
public class SessionTimer {
    private List<IndexController> indexControllerList = new ArrayList<>();
    private List<IndexController> indexControllerListRemove = new ArrayList<>();
    
    @Schedule(dayOfWeek = "*", month = "*", hour = "*", dayOfMonth = "*", year = "*", minute = "*", second = "0", persistent = false)
    
    public void myTimer() {
        for (IndexController indexC: indexControllerList){
            if(! indexC.event()) indexControllerListRemove.add(indexC);
        System.out.println("Timer event: " + new Date() +  (indexControllerListRemove.size() !=0 ? "Сброшено":"") + " Размер листа : " +indexControllerList.size());
        }
        indexControllerList.removeAll(indexControllerListRemove);
        indexControllerListRemove.clear();
        System.out.println("Timer event: " + new Date() + "  " + (indexControllerList.size() !=0 ? "Восстановлено":"") + " Размер листа : " +indexControllerList.size());
    }

public void setEventLisener(IndexController indexController){
        if(!indexControllerList.contains(indexController)) {
            indexControllerList.add(indexController);
            System.out.println("Timer event: " + new Date() + "  открыта новая сессия и добавлен бин  :" + indexController + " Размер листа : " +indexControllerList.size());
        }
}

public void removeIndexController(IndexController indexController){
        if(indexControllerList.contains(indexController)) {
            indexControllerList.remove(indexController);
            System.out.println("Timer event: " + new Date() + "  удален бин  :" + indexController + " Размер листа : " +indexControllerList.size());
        }

}
}
