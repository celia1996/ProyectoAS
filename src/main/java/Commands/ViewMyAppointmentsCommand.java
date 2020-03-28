package Commands;

import Controllers.FrontCommand;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

public class ViewMyAppointmentsCommand extends FrontCommand {

    @Override
    public void process() {
        try{
            HttpSession session = request.getSession(true);
            if(session.getAttribute("user")!= null && session.getAttribute("appointment") != null){
            forward("/AppointmentsView.jsp");
            }
            
        } catch(ServletException ex) {
            Logger.getLogger(ViewMyAppointmentsCommand.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ViewMyAppointmentsCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
