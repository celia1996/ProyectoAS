/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Controllers.FrontCommand;
import ejbs.Log;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;

/**
 *
 * @author celia
 */
public class TimerCommand extends FrontCommand{

    @Override
    public void process() {
        long time = Long.parseLong(request.getParameter("time")) ;
        Log log;
        try {
            log = (Log) InitialContext.doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/Log");
            log.setTime(time);
            log.startTimer();
            forward("/index.jsp");
            
        } catch (NamingException ex) {
            Logger.getLogger(TimerCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(TimerCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TimerCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
            

    }
    
}
