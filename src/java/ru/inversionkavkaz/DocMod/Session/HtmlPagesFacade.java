/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.inversionkavkaz.DocMod.Session;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import ru.inversionkavkaz.DocMod.Entities.HtmlPages;

/**
 *
 * @author DMITRY
 */
@Stateless
public class HtmlPagesFacade extends AbstractFacade<HtmlPages> {

    @PersistenceContext(unitName = "DocModPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HtmlPagesFacade() {
        super(HtmlPages.class);
    }

        public Collection<HtmlPages> findByTypeId(int htmlTypeId) {
        TypedQuery<HtmlPages> query = em.createNamedQuery("HtmlPages.findByHtmlTypeId", HtmlPages.class);
        query.setParameter("htmlTypeId", htmlTypeId);
        return query.getResultList();
    }    
}
