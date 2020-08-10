/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Controllers.FrontCommand;
import control.AppointmentFacade;
import java.io.IOException;
import java.util.List;
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

            AppointmentFacade appointments = (AppointmentFacade) InitialContext.doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/AppointmentFacade!control.AppointmentFacade");
            List<entities.Appointment> appointmentList = appointments.orderAppointmentByDate();
            session.setAttribute("appointments", appointmentList);
       

            forward("/SelectAppointment.jsp?page=1");

        } catch (NamingException ex) {
            Logger.getLogger(GoToSelectAppointmentCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(GoToSelectAppointmentCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GoToSelectAppointmentCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
