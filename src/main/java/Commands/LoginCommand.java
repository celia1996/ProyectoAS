package Commands;

import Model.DataAccess;
import Controllers.FrontCommand;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

public class LoginCommand extends FrontCommand {

    @Override
    public void process() {
        if (DataAccess.Validation(request.getParameter("user"), request.getParameter("password"))) {
            try {
                HttpSession session = request.getSession(true);
                String user = request.getParameter("user");
                session.setAttribute("user",user);
                
                forward("/index.jsp");
                
            } catch (ServletException ex) {
                Logger.getLogger(LoginCommand.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(LoginCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
