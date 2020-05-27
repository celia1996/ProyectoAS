package Commands;

import Controllers.FrontCommand;
import ejbs.Log;
import ejbs.RegisterEJB;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;

public class RegisterCommand extends FrontCommand {

    @Override
    public void process() {

        String newUser = request.getParameter("newUser");
        String newPassword = request.getParameter("newPassword");

        try {
            RegisterEJB newRegister = (RegisterEJB) InitialContext.doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/RegisterEJB");
            newRegister.addUser(newUser, newPassword);

            //Singleton
            Log log = (Log) InitialContext.doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/Log");
            log.addLog("RegisterCommand::process() - Se ha llamado al comando RegisterCommand");
            
            forward("/Login.jsp");

        } catch (NamingException ex) {
            Logger.getLogger(RegisterCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(RegisterCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RegisterCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
