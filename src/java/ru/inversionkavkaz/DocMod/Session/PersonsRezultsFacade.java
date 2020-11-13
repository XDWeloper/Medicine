
package ru.inversionkavkaz.DocMod.Session;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import ru.inversionkavkaz.DocMod.Entities.PersonsRezults;

@Stateless
public class PersonsRezultsFacade extends AbstractFacade<PersonsRezults> {

    @PersistenceContext(unitName = "DocModPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonsRezultsFacade() {
        super(PersonsRezults.class);
    }
    public Collection<PersonsRezults> findBypersonId(int person_id) {
        TypedQuery<PersonsRezults> query = em.createNamedQuery("PersonsRezults.findByPersonId", PersonsRezults.class);
        query.setParameter("personId", person_id);
        return query.getResultList();
    }    
}
