package Commands;

import Controllers.FrontCommand;
import control.AppointmentFacade;
import ejbs.CalendarEJB;
import ejbs.Counter;
import ejbs.Log;
import ejbs.UserEJB;
import entities.Appointment;
import entities.Systemuser;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

public class AskForAppointmentCommand extends FrontCommand {
    
    
    @Override
    public void process() {

        try {
            HttpSession session = request.getSession();
            int appointmentItem = (int) Integer.parseInt(request.getParameter("appointmentID"));
            int userID = (Integer) session.getAttribute("userID");
            
            AppointmentFacade appointments = (AppointmentFacade) InitialContext.
                    doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/AppointmentFacade!control.AppointmentFacade");
            Appointment appointment = appointments.find(appointmentItem);

            
            /*CalendarEJB myCalendar = (CalendarEJB) session.getAttribute("myCalendar");

            if (myCalendar == null) {

                myCalendar = (CalendarEJB) InitialContext.doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/CalendarEJB");

            }*/
            request.setAttribute("appointmentConfirmed", appointment);
            
            /*myCalendar.addAppointment(appointment);
            session.setAttribute("myCalendar", myCalendar);*/
            appointment.setAvailability(1);
            appointment.setUserid(userID);
          
           //Singleton
          /* Counter counter = (Counter) InitialContext.doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/Counter");
           Systemuser user = (Systemuser) request.getAttribute("user"); 
           
            counter.newAppointment(user.getUsername());
            */
            Log log = (Log) InitialContext.doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/Log");
            log.addLog("AskForAppointmentCommand::process()- Se ha llamado al comando AskForAppointmentCommand");
            
            forward("/AppointmentConfirmed.jsp");

        } catch (ServletException | IOException | NamingException ex) {
            Logger.getLogger(AskForAppointmentCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
