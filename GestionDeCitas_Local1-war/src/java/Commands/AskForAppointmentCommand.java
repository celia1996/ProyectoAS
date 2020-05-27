package Commands;

import Controllers.FrontCommand;
import database.Appointment;
import ejbs.AppointmentEJB;
import ejbs.CalendarEJB;
import ejbs.Counter;
import ejbs.Log;
import ejbs.UserEJB;
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
            int appointmentItem = (int) Integer.parseInt(request.getParameter("appointmentItem"));
            AppointmentEJB appointmentejb = (AppointmentEJB) InitialContext.doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/AppointmentEJB");
            Appointment appointment = appointmentejb.getAppointment(appointmentItem);

            HttpSession session = request.getSession();
            CalendarEJB myCalendar = (CalendarEJB) session.getAttribute("myCalendar");

            if (myCalendar == null) {

                myCalendar = (CalendarEJB) InitialContext.doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/CalendarEJB");

            }
            request.setAttribute("appointmentConfirmed", appointment);
            myCalendar.addAppointment(appointment);
            session.setAttribute("myCalendar", myCalendar);
            appointment.setAvailable(1);
          
           //Singleton
           Counter counter = (Counter) InitialContext.doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/Counter");
            UserEJB user = (UserEJB) session.getAttribute("userEJB");
            counter.newAppointment(user.getUserName());
            
            Log log = (Log) InitialContext.doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/Log");
            log.addLog("AskForAppointmentCommand::process()- Se ha llamado al comando AskForAppointmentCommand");
            
            forward("/AppointmentConfirmed.jsp");

        } catch (ServletException | IOException | NamingException ex) {
            Logger.getLogger(AskForAppointmentCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
