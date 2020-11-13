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
import ru.inversionkavkaz.DocMod.Entities.Mkb10Classes;

/**
 *
 * @author DMITRY
 */
@Stateless
public class Mkb10ClassesFacade extends AbstractFacade<Mkb10Classes> {

    @PersistenceContext(unitName = "DocModPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Mkb10ClassesFacade() {
        super(Mkb10Classes.class);
    }
    
    public Collection<Mkb10Classes> findByParentCode(int parentCode) {
        TypedQuery<Mkb10Classes> query = em.createNamedQuery("Mkb10Classes.findByMkbClassParentCode", Mkb10Classes.class);
        query.setParameter("mkbClassParentCode", parentCode);
        return query.getResultList();
    }
    
}
