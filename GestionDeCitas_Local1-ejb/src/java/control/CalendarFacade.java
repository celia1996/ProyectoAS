/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entities.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Celia Navarro Pérez
 */
@Stateless
public class CalendarFacade extends AbstractFacade<Calendar> {

    @PersistenceContext(unitName = "GestionDeCitas_Local1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CalendarFacade() {
        super(Calendar.class);
    }

    public List<Calendar> findCalendarByUser(Integer user) {
        return em.createQuery("SELECT c FROM Calendar c WHERE c.userid = :user")
                .setParameter("user", user).getResultList();

    }

    public List<Calendar> findCalendarByAppointmentID(Integer appointmentID) {
        return em.createQuery("SELECT c FROM Calendar c WHERE c.appointmentid = :appointmentID")
                .setParameter("appointmentID", appointmentID).getResultList();

    }

}
