package Commands;

import Controllers.FrontCommand;
import control.SystemuserFacade;
import ejbs.Log;
import entities.Systemuser;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;

public class RegisterCommand extends FrontCommand {

    @Override
    public void process() {

        try {
            
            SystemuserFacade users = (SystemuserFacade) InitialContext
                    .doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/SystemuserFacade!control.SystemuserFacade");
            String user = request.getParameter("newUser");
            String password = request.getParameter("newPassword");
            int id = (int) (Math.random() * 10 + 4);

                //INSERT
                Systemuser newUser = new Systemuser(id);
                newUser.setUsername(user);
                newUser.setPassword(password);
                users.create(newUser);
                
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
