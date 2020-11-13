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
import ru.inversionkavkaz.DocMod.Entities.HazRezult;
import ru.inversionkavkaz.DocMod.Entities.MkbRezult;

/**
 *
 * @author DMITRY
 */
@Stateless
public class HazRezultFacade extends AbstractFacade<HazRezult> {

    @PersistenceContext(unitName = "DocModPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HazRezultFacade() {
        super(HazRezult.class);
    }
    
    public Collection<HazRezult> findByRezId(int rez_id) {
        TypedQuery<HazRezult> query = em.createNamedQuery("HazRezult.findByRezId", HazRezult.class);
        query.setParameter("rezId", rez_id);
        return query.getResultList();
    }
}
