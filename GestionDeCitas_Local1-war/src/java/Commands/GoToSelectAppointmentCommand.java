/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Controllers.FrontCommand;
import database.Appointment;
import ejbs.AppointmentEJB;
import ejbs.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author celia
 */
public class GoToSelectAppointmentCommand extends FrontCommand {

    @Override
    public void process() {
        try {
            HttpSession session = request.getSession(true);

            AppointmentEJB appointment = (AppointmentEJB) InitialContext.doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/AppointmentEJB");

            ArrayList<Appointment> appointments = appointment.getFromDB();

            session.setAttribute("appointment", appointments);

            //Singleton
            Log log = (Log) InitialContext.doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/Log");
            log.addLog("GoToSelectAppointmentCommand::process() - Se ha llamado al comando GoToSelectAppointmentCommand");

            forward("/SelectAppointment.jsp");

        } catch (NamingException ex) {
            Logger.getLogger(GoToSelectAppointmentCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(GoToSelectAppointmentCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GoToSelectAppointmentCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
