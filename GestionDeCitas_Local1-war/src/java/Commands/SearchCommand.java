package Commands;

import Controllers.FrontCommand;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

public class SearchCommand extends FrontCommand {

    @Override
    public void process() {

        try {
            
            forward("/Search.jsp");

        } catch (ServletException | IOException ex) {
            Logger.getLogger(SearchCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
