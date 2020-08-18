package Commands;

import Controllers.FrontCommand;
import control.AppointmentFacade;
import control.CalendarFacade;
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
            session.setAttribute("calendarID", calendarID);

            AppointmentFacade appointments = (AppointmentFacade) InitialContext.
                    doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/AppointmentFacade!control.AppointmentFacade");
            Appointment appointment = appointments.find(appointmentID);

            CalendarFacade calendarEM = (CalendarFacade) session.getAttribute("calendar");

            if (calendarEM == null) {
                calendarEM = (CalendarFacade) InitialContext
                        .doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/CalendarFacade!control.CalendarFacade");
                session.setAttribute("calendar", calendarEM);
            }
            
            Calendar calendar = new Calendar(calendarID, userID, appointmentID);
            calendarEM.create(calendar);

            session.setAttribute("appointmentConfirmed", appointment);

            appointment.setAvailability(1);
            appointment.setUserid(userID);
            appointments.edit(appointment);



            forward("/UserDetails.jsp");

        } catch (ServletException | IOException | NamingException ex) {
            Logger.getLogger(AskForAppointmentCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
