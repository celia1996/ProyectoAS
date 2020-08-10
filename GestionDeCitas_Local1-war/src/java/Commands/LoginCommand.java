package Commands;

import Controllers.FrontCommand;
import control.SystemuserFacade;
import entities.Systemuser;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

public class LoginCommand extends FrontCommand {

    @Override
    public void process() {

        try {
            HttpSession session = request.getSession(true);
            String userName = (String) request.getParameter("user");
            String password = (String) request.getParameter("password");
            int userID;

            SystemuserFacade users = (SystemuserFacade) InitialContext.doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/SystemuserFacade!control.SystemuserFacade");
            List<Systemuser> usersList = users.findAll();

            for (Systemuser user : usersList) {
                if (userName.equals(user.getUsername()) && password.equals(user.getPassword())) {
                    userID = user.getUserid();
                    session.setAttribute("userID", userID);
                }
            }
                forward("/index.jsp");

            } catch (ServletException ex) {
                Logger.getLogger(LoginCommand.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(LoginCommand.class.getName()).log(Level.SEVERE, null, ex);
            }catch (NamingException ex) {
            Logger.getLogger(LoginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
