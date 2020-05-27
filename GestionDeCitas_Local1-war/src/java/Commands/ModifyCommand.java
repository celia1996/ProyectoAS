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

public class ModifyCommand extends FrontCommand {

    @Override
    public void process() {
        try {
            HttpSession session = request.getSession(true);

            session.setAttribute("modify", 1);
            
            //Singleton
            Log log = (Log) InitialContext.doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/Log");
            log.addLog("ModifyCommand::process() - Se ha llamado al comando ModifyCommand");

            forward("/FrontController?cmd=CancelCommand");

        } catch (ServletException ex) {
            Logger.getLogger(AskForAppointmentCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AskForAppointmentCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(ModifyCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
