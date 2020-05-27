package Commands;

import Controllers.FrontCommand;
import database.User;
import ejbs.Counter;
import ejbs.Log;
import ejbs.UserEJB;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

public class LoginCommand extends FrontCommand {

    @Override
    public void process() {

        HttpSession session = request.getSession(true);
        String userName = (String) request.getParameter("user");
        String password = (String) request.getParameter("password");

        User user = User.findUser(userName);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                try {

                    UserEJB userEJB = (UserEJB) InitialContext.doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/UserEJB");
                    userEJB.setUser(user);
                    session.setAttribute("userEJB", userEJB);

                    //Singleton
                    Counter counter = (Counter) InitialContext.doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/Counter");
                    counter.newLogin();

                    Log log = (Log) InitialContext.doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/Log");
                    log.addLog("LoginCommand::process() - Se ha llamado al comando LoginCommand");

                    forward("/index.jsp");

                } catch (ServletException ex) {
                    Logger.getLogger(LoginCommand.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(LoginCommand.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NamingException ex) {
                    Logger.getLogger(LoginCommand.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

}
