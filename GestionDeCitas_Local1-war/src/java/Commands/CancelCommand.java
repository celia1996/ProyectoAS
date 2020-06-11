package Commands;

import Controllers.FrontCommand;
import control.AppointmentFacade;
import control.CalendarFacade;
import ejbs.Log;
import entities.Appointment;
import entities.Calendar;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

public class CancelCommand extends FrontCommand {

    @Override
    public void process() {
        try {
            HttpSession session = request.getSession(true);
            int appointmentID = Integer.parseInt(request.getParameter("appointmentID"));
            CalendarFacade calendarEM = (CalendarFacade) InitialContext
                    .doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/CalendarFacade!control.CalendarFacade");

            List<Calendar> appointments = calendarEM.findCalendarByAppointmentID(appointmentID);
            int calendarAppointmentID = 0;

            for (Calendar calendar : appointments) {
                calendarAppointmentID = calendar.getAppointmentid();
                calendarEM.remove(calendar);
            }

            AppointmentFacade appointmentEM = (AppointmentFacade) InitialContext.
                    doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/AppointmentFacade!control.AppointmentFacade");

            Appointment appointmentToAvailable = appointmentEM.find(calendarAppointmentID);
            appointmentToAvailable.setAvailability(0);
            appointmentToAvailable.setUserid(null);
            appointmentEM.edit(appointmentToAvailable);

            if (session.getAttribute("modifyFlag") != null) {
                int modify = (int) session.getAttribute("modifyFlag");
                if (modify == 1) {
                    session.setAttribute("modifyFlag", 0);
                    forward("/SelectAppointment?page=1.jsp");
                }
            } else {
                //Singleton
                Log log = (Log) InitialContext.doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/Log");
                log.addLog("CancelCommand::process() - Se ha llamado al comando CancelCommand");
                forward("/AppointmentCancelled.jsp");
            }

        } catch (ServletException | IOException | NamingException ex) {
            Logger.getLogger(CancelCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
