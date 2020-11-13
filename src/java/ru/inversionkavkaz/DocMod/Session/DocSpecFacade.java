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
import ru.inversionkavkaz.DocMod.Entities.DocSpec;
import ru.inversionkavkaz.DocMod.Entities.Doctors;

/**
 *
 * @author DMITRY
 */
@Stateless
public class DocSpecFacade extends AbstractFacade<DocSpec> {

    @PersistenceContext(unitName = "DocModPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocSpecFacade() {
        super(DocSpec.class);
    }
    
        public Collection<DocSpec> findByDoctorId(Doctors doctor_id) {
        TypedQuery<DocSpec> query = em.createNamedQuery("DocSpec.findByDoctor", DocSpec.class);
        query.setParameter("iddoctor", doctor_id);
        return query.getResultList();
    }
}
