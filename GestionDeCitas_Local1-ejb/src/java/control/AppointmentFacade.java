/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entities.Appointment;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Celia Navarro Pérez
 */
@Stateless
public class AppointmentFacade extends AbstractFacade<Appointment> {

    @PersistenceContext(unitName = "GestionDeCitas_Local1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AppointmentFacade() {
        super(Appointment.class);
    }

    public List<Appointment> orderAppointmentByDate() {
        return em.createQuery("SELECT a FROM Appointment a ORDER BY a.date ASC")
                .getResultList();
    }
    
    public List<Appointment> getAppointmentByUserID(int userID) {
        return em.createNamedQuery("Appointment.findByUserid")
                .setParameter("userid", userID)
                .getResultList();
    }    

    public List<Appointment> getAppointmetByCategoryOrderedByDate(Integer categoryID) {
        CriteriaQuery<Appointment> q = em.getCriteriaBuilder().createQuery(Appointment.class);
        Root<Appointment> c = q.from(Appointment.class);
        q.select(c).where(
                em.getCriteriaBuilder().equal(c.get("categoryid"), categoryID))
                .orderBy(em.getCriteriaBuilder().asc(c.get("date")));
        List<Appointment> search_results = em.createQuery(q).getResultList();
        return search_results;
    }

    public List<Appointment> setPagination(int page) {
        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<Appointment> cq = qb.createQuery(Appointment.class);

        Root<Appointment> appointments = cq.from(Appointment.class);
        cq.orderBy(qb.asc(appointments.get("date")));

        List<Appointment> appointmentsList = em.createQuery(cq)
                .setFirstResult((page - 1) * 3)
                .setMaxResults(3)
                .getResultList();
        return appointmentsList;
    }
}
