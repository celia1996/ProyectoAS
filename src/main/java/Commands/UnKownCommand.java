package Commands;

import Controllers.FrontCommand;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

public class UnKownCommand extends FrontCommand{
    public void process() {
        try {
            forward("/unkown.html");
            return;
        } catch (ServletException ex) {
            Logger.getLogger(UnKownCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UnKownCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
