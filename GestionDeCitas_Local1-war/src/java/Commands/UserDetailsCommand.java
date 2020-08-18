/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Controllers.FrontCommand;
import control.CalendarFacade;
import entities.Calendar;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Celia Navarro Pérez
 */
public class UserDetailsCommand extends FrontCommand {

    @Override
    public void process() {
        try {
            HttpSession session = request.getSession();
            int personalID = (int) Integer.parseInt(request.getParameter("personalID"));
            int phoneNumber = (int) Integer.parseInt(request.getParameter("phoneNumber"));
            int calendarID = (Integer) session.getAttribute("calendarID");
            CalendarFacade calendarEM = (CalendarFacade) session.getAttribute("calendar");
            
            Calendar calendar = calendarEM.find(calendarID);
            calendar.setPersonalid(personalID);
            calendar.setPhonenumber(phoneNumber);
            calendarEM.edit(calendar);

            forward("/AppointmentConfirmed.jsp");
            
        } catch (ServletException | IOException ex) {
            Logger.getLogger(UserDetailsCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
