/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entities.Systemuser;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Celia Navarro Pérez
 */
@Stateless
public class SystemuserFacade extends AbstractFacade<Systemuser> {

    @PersistenceContext(unitName = "GestionDeCitas_Local1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SystemuserFacade() {
        super(Systemuser.class);
    }

    public List<Systemuser> findUserbyName(String userName) {
        return em.createQuery("SELECT s FROM Systemuser s WHERE s.username LIKE :userName")
                .setParameter("userName", userName).getResultList();

    }


}
