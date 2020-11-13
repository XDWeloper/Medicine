/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.inversionkavkaz.DocMod.Session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ru.inversionkavkaz.DocMod.Entities.HtmlPageType;

/**
 *
 * @author DMITRY
 */
@Stateless
public class HtmlPageTypeFacade extends AbstractFacade<HtmlPageType> {

    @PersistenceContext(unitName = "DocModPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HtmlPageTypeFacade() {
        super(HtmlPageType.class);
    }
    
}
