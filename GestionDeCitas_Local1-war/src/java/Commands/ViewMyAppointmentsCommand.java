package Commands;

import Controllers.FrontCommand;
import control.CalendarFacade;
import entities.Calendar;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

public class ViewMyAppointmentsCommand extends FrontCommand {

    @Override
    public void process() {
        try {
            HttpSession session = request.getSession(true);
            
            if (session.getAttribute("userID") != null ) {
                   
                    CalendarFacade calendarEM = (CalendarFacade) InitialContext
                            .doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/CalendarFacade!control.CalendarFacade");
                    int userID = (Integer) session.getAttribute("userID");
                    
                    List<Calendar> userCalendar = calendarEM.findCalendarByUser(userID);
                    
                    session.setAttribute("userCalendar", userCalendar);

                forward("/AppointmentsView.jsp");
            }

        } catch (ServletException ex) {
            Logger.getLogger(ViewMyAppointmentsCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ViewMyAppointmentsCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(ViewMyAppointmentsCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

//eliminado del primer if && session.getAttribute("appointment") != null