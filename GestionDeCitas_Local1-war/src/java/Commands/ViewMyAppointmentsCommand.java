package Commands;

import Controllers.FrontCommand;
import ejbs.Log;
import java.io.IOException;
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
            if (session.getAttribute("user") != null && session.getAttribute("appointment") != null) {
                
                //Singleton
                Log log = (Log) InitialContext.doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/Log");
                log.addLog("ViewMyAppointments::process() - Se ha llamado al comando ViewMyAppointmentsCommand");
                
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
