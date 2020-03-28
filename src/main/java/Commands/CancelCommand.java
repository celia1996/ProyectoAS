package Commands;

import Controllers.FrontCommand;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

public class CancelCommand extends FrontCommand {

    @Override
    public void process() {
        try{
            HttpSession session = request.getSession(true);
            
                session.setAttribute("appointment",null);
                
                 forward("/AppointmentCancelled.jsp");
           
            
        }catch(ServletException ex){
            Logger.getLogger(CancelCommand.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
                Logger.getLogger(CancelCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
