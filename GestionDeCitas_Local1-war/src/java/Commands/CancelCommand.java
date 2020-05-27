package Commands;

import Controllers.FrontCommand;
import ejbs.CalendarEJB;
import ejbs.Log;
import java.io.IOException;
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
            CalendarEJB myCalendar = (CalendarEJB) session.getAttribute("myCalendar");

            if (myCalendar == null) {

                myCalendar = (CalendarEJB) InitialContext.doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/CalendarEJB");

            }
            int id = Integer.parseInt(request.getParameter("appointmentItem"));
            myCalendar.remove(id);
            session.setAttribute("myCalendar", myCalendar);

            if (session.getAttribute("modify") != null) {

                int modify = (int) session.getAttribute("modify");

                if (modify == 1) {
                    session.setAttribute("modify", 0);
                    forward("/SelectAppointment.jsp");
                }
            } else {
                //Singleton
                Log log = (Log) InitialContext.doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/Log");
                log.addLog("CancelCommand::process() - Se ha llamado al comando CancelCommand");
                forward("/AppointmentCancelled.jsp");
            }

        } catch (ServletException ex) {
            Logger.getLogger(CancelCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CancelCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CancelCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
