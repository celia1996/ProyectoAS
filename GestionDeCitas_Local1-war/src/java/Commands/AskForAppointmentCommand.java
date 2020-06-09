package Commands;

import Controllers.FrontCommand;
import control.AppointmentFacade;
import control.CalendarFacade;
import control.SystemuserFacade;
import ejbs.Counter;
import ejbs.Log;
import entities.Appointment;
import entities.Calendar;
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
            int appointmentID = (int) Integer.parseInt(request.getParameter("appointmentID"));
            int userID = (Integer) session.getAttribute("userID");
            
            int calendarID = (int) (Math.random() * 100 + 4);

            AppointmentFacade appointments = (AppointmentFacade) InitialContext.
                    doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/AppointmentFacade!control.AppointmentFacade");
            Appointment appointment = appointments.find(appointmentID);

            CalendarFacade calendarEM = (CalendarFacade) session.getAttribute("calendar");

            if (calendarEM == null) {
                calendarEM = (CalendarFacade) InitialContext
                        .doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/CalendarFacade!control.CalendarFacade");
                session.setAttribute("calendar", calendarEM);
            }
            System.out.println(userID);
            Calendar calendar = new Calendar(calendarID, userID, appointmentID);
            calendarEM.create(calendar);

            request.setAttribute("appointmentConfirmed", appointment);

            appointment.setAvailability(1);
            appointment.setUserid(userID);
            appointments.edit(appointment);

            //Singleton
            Counter counter = (Counter) InitialContext.doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/Counter");
            SystemuserFacade user = (SystemuserFacade) InitialContext
                    .doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/SystemuserFacade!control.SystemuserFacade");

            counter.newAppointment(user.find(userID).getUsername());

            Log log = (Log) InitialContext.doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/Log");
            log.addLog("AskForAppointmentCommand::process()- Se ha llamado al comando AskForAppointmentCommand");

            forward("/AppointmentConfirmed.jsp");

        } catch (ServletException | IOException | NamingException ex) {
            Logger.getLogger(AskForAppointmentCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
