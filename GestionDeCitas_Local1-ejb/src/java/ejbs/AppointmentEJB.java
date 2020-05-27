
package ejbs;

import database.Appointment;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author celia
 */
@Stateless
@LocalBean
public class AppointmentEJB {
    @EJB
    Log log;
    public ArrayList<Appointment> getFromDB(){
        log.addLog("AppointmentsEJB::getFromDB()");
        return Appointment.appointments;
    }

    public Appointment getAppointment(int id){
        log.addLog("AppointmentsEJB::getAppointment()");
        return Appointment.getAppointmentById(id);
    }
    
    @PostConstruct
    public void init(){
        System.out.println("AppointmentEJB::init() - @PostConstruct del Stateless");
    }
    
    @PreDestroy
    public void destroy(){
        System.out.println("AppointmentEJB::destroy() - @PreDestroy del Stateless");
    }
}
