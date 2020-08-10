package Commands;

import Controllers.FrontCommand;
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

            session.setAttribute("modifyFlag", 1);

            forward("/FrontController?cmd=CancelCommand");

        } catch (ServletException ex) {
            Logger.getLogger(AskForAppointmentCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AskForAppointmentCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
