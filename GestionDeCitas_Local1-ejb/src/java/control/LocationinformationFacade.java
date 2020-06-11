/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entities.Locationinformation;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Celia Navarro Pérez
 */
@Stateless
public class LocationinformationFacade extends AbstractFacade<Locationinformation> {

    @PersistenceContext(unitName = "GestionDeCitas_Local1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocationinformationFacade() {
        super(Locationinformation.class);
    }
    
}
