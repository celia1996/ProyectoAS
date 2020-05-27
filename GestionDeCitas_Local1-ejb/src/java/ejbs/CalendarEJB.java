package ejbs;

import database.Appointment;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;

/**
 *
 * @author celia
 */
@Stateful
@LocalBean
public class CalendarEJB {

    @EJB
    Log log;
    
    private ArrayList<Appointment> myAppointments = new ArrayList<>();

    public void addAppointment(Appointment appointment) {
        log.addLog("CalendarEJB::addAppointment()");
        myAppointments.add(appointment);
    }

    public ArrayList<Appointment> getMyAppointments() {
        log.addLog("CalendarEJB::getMyAppointment()");
        return myAppointments;
    }

    public void remove(int id) {
        log.addLog("CalendarEJB::remove()");
        Appointment appointment = Appointment.getAppointmentById(id);
        myAppointments.remove(appointment);
        appointment.setAvailable(0);
    }

    @Remove
    public void remove() {
        System.out.println("CalendarEJB::remove - @Remove del Stateful");
    }

    @PostConstruct
    public void init() {
        System.out.println("CalendarEJB::init - @PostConstruct del Stateful");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("CalendarEJB::destroy - @PreDestroy del Stateful");
    }

    @PostActivate
    public void postActivate() {
        System.out.println("CalendarEJB::postActivate - @PostActivate del Stateful");
    }

    @PrePassivate
    public void prePassivate() {
        System.out.println("CalendarEJB::prePassivate - @PrePassivate del Stateful");
    }
}
